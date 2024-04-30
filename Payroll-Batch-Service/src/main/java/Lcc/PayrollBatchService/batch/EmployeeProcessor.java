package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.payrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeProcessor implements ItemProcessor<EmployeeOnPayroll, Payroll> {

    private final EmployeeService employeeService;
    private final EmployeePensionService employeePensionService;
    private final EmployeeInsuranceService employeeInsuranceService;
    private final InsuranceService insuranceService;
    private final EmployeePayrollDeductionService employeePayrollDeductionService;
    private final EmployeeOtherDeductionService employeeOtherDeductionService;
    private final OtherDeductionService otherDeductionService;
    private final PositionService positionService;
    private final SalaryNotchService salaryNotchService;
    @Autowired
    private EmployeeBankDetailService employeeBankDetailService;

    @Autowired
    private PensionService pensionService;

    @Autowired
    private EmployeePersonalDataService employeePersonalDataService;
    // Do processing here
    @Autowired
    private PayrollPdfGenerator pdfGenerator;

    @Autowired
    private PayAsYouEarnTaxBandService payAsYouEarnTaxBandService;
    @Override
    public Payroll process(EmployeeOnPayroll employee) throws Exception {

        String empId = employee.getEmployeeId();
        System.out.println("Processing employee with: " + empId);
        String date = formatDate(); // get the current payment date

        // access the position of the employee
        String employeePosition = employeeService.findPositionByEmployeeId(empId);
        Position position = positionService.findPositionByEmpPosition(employeePosition);

        String salaryScale = position.getSalaryScale();
        System.out.println(salaryScale);
        //obtain the basic salary and calculate the allowances and gross
        double basicSalary = salaryNotchService.findBasicSalaryBySalaryScale(salaryScale);

       // allowances are recorded as percentages thus the division by 100
        double housingAllowance = position.getHousingAllowance() * basicSalary / 100;
        double educationAllowance = position.getEducationAllowance() * basicSalary / 100;
        double transportAllowance = position.getTransportAllowance() * basicSalary / 100;
        double fuelAllowance = position.getFuelAllowance() * basicSalary / 100;
        double riskAllowance = position.getRiskAllowance() * basicSalary / 100;

        System.out.println("basic salary: " + basicSalary);
        System.out.println("housing allowance: " + housingAllowance);
        System.out.println("education allowance " + educationAllowance);
        System.out.println("transport allowance " + transportAllowance);
        System.out.println("fuel allowance:" + fuelAllowance);
        System.out.println("risk allowance: " + riskAllowance);

        double grossSalary  =  basicSalary
                            + housingAllowance
                            + educationAllowance
                            + transportAllowance
                            + riskAllowance
                            + fuelAllowance;


        System.out.println("gross salary: " + grossSalary);

        // Payroll Deductions
        List<EmployeePayrollDeduction> employeePayrollDeductions = new ArrayList<>();

        // pay as you earn/ income tax
        double payAsYouEarnDeductions = calculatePayAsYouEarn(empId, employeePayrollDeductions, grossSalary);

        // pension deductions
        double pensionDeduction = calculatePensionDeduction(empId, basicSalary, grossSalary, employeePayrollDeductions);

        // get insurance Deductions
        double insuranceDeductions = calculateInsuranceDeductions(empId, basicSalary, employeePayrollDeductions);

        //get other deductions
        double otherDeductions = calculateOtherDeductions(empId, basicSalary, employeePayrollDeductions);

        // net salary
        double totalDeductions = roundOff(insuranceDeductions + otherDeductions + pensionDeduction +     payAsYouEarnDeductions);
        double netPay =  roundOff(grossSalary - totalDeductions);

        Payroll payroll = new Payroll();
        payroll.setKey(new PayrollCompositeKey(empId, date));
        payroll.setBasicSalary(basicSalary);
        payroll.setGrossPay(grossSalary);
        payroll.setFuelAllowance(fuelAllowance);
        payroll.setNetPay(netPay);
        payroll.setEducationAllowance(educationAllowance);
        payroll.setHousingAllowance(housingAllowance);
        payroll.setTransportAllowance(transportAllowance);
        payroll.setTotalDeductions(totalDeductions);
        payroll.setRiskAllowance(riskAllowance);

        System.out.println("netpay: " + netPay);

        // retrieve personal information
        EmployeePersonalData employeePersonalData = employeePersonalDataService.findEmployeeDataByEmployeeNumber(payroll.getKey().getEmployeeId());
        // retrieve employee bank details
        EmployeeBankDetails employeeBankDetails = employeeBankDetailService.findEmployeeBankDetailByEmployeeNumber(payroll.getKey().getEmployeeId());
        // access other employee data
        Employee employeeDetails = employeeService.findEmployeeByEmployeeId(payroll.getKey().getEmployeeId());
        String empFullname = employeePersonalData.getFirstname() + " " + employeePersonalData.getSurname();
        PaySlipEmployeeData empInfo = new PaySlipEmployeeData(payroll.getKey().getEmployeeId(),empFullname,employeePersonalData.getNrc(),employeePersonalData.getNrc(), employeeDetails.getDateAppointedToCurrentPosition(), employeeDetails.getEmploymentType(),"name","name",employeeBankDetails.getBranch(),"name","name",employeeBankDetails.getBankName(),employeeBankDetails.getAccountNumber(),"name" ,"");

        pdfGenerator.generatePayroll(payroll, employeePayrollDeductions, empInfo, empFullname);
        return payroll;


    }
        public static String formatDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyy");
        return date.format(formatter);
    }

      private double roundOff(double amount){
          return amount * 100 / 100.0;
      }

      private double calculatePayAsYouEarn(String employeeNumber,List<EmployeePayrollDeduction> employeePayrollDeductions, double grossSalary){
          List<PayAsYouEarnTaxBand> payAsYouEarnTaxBands = payAsYouEarnTaxBandService.findAll();
          payAsYouEarnTaxBands.forEach(band -> System.out.println(band.getUpperBound()));
          PayAsYouEarnTaxBand previousBand = null;
          double payAsYouEarnDeductions = 0;
          double bandContribution =0;
          for (PayAsYouEarnTaxBand taxBand: payAsYouEarnTaxBands){
              if (grossSalary <= taxBand.getUpperBound()){
                  if (previousBand != null) {
                      bandContribution = (taxBand.getUpperBound() - previousBand.getUpperBound()) * taxBand.getPercentage() / 100;
                      payAsYouEarnDeductions += bandContribution;
                      EmpDeductionCompositeKey deductionKey = new EmpDeductionCompositeKey(employeeNumber, "P.A.Y.E(INCOME TAX) BAND" + taxBand.getKey().getBand(), formatDate());
                      EmployeePayrollDeduction bandDeduction = new EmployeePayrollDeduction(deductionKey,
                              taxBand.getPercentage(), bandContribution);

                      employeePayrollDeductionService.add(bandDeduction);
                      employeePayrollDeductions.add(bandDeduction);
                  }

                  break;
              }
              else {
                  if (taxBand.getUpperBound() < 0){
                      bandContribution = (grossSalary - previousBand.getUpperBound()) * taxBand.getPercentage() / 100.0;
                      payAsYouEarnDeductions += bandContribution;
                      EmpDeductionCompositeKey deductionKey = new EmpDeductionCompositeKey(employeeNumber, "P.A.Y.E(INCOME TAX) BAND " + taxBand.getKey().getBand(), formatDate());
                      EmployeePayrollDeduction bandDeduction = new EmployeePayrollDeduction(deductionKey,
                              taxBand.getPercentage(), bandContribution);

                      employeePayrollDeductionService.add(bandDeduction);
                      employeePayrollDeductions.add(bandDeduction);
                      break;
                  }
                  else {
                      if (previousBand == null) {
                          previousBand = taxBand;
                      }
                      else {
                          bandContribution = (taxBand.getUpperBound() - previousBand.getUpperBound()) * taxBand.getPercentage()/ 100.0;
                          payAsYouEarnDeductions += bandContribution;
                          EmpDeductionCompositeKey deductionKey = new EmpDeductionCompositeKey(employeeNumber, "P.A.Y.E(INCOME TAX) BAND " + taxBand.getKey().getBand(), formatDate());
                          EmployeePayrollDeduction bandDeduction = new EmployeePayrollDeduction(deductionKey,
                                  taxBand.getPercentage(), bandContribution);

                          employeePayrollDeductionService.add(bandDeduction);
                          employeePayrollDeductions.add(bandDeduction);
                          previousBand = taxBand;

                      }
                  }

              }

          }

       return payAsYouEarnDeductions;
      }

     /* Calculates other employee deductions e.g union contribution*/
    private double calculateOtherDeductions(String employeeNumber, double basicSalary, List<EmployeePayrollDeduction> employeePayrollDeductions){
        double otherDeductions = 0;
        List<String> otherDeductionList = employeeOtherDeductionService.findOtherDeductionByEmployeeId(employeeNumber);
        if (!otherDeductionList.isEmpty()) {
            for (String deduction : otherDeductionList) {
                double percentDeduction = otherDeductionService.findPercentageDeductionByDeductionType(deduction);
                double deductAmount =  percentDeduction * basicSalary / 100;
                otherDeductions += deductAmount;
                System.out.println(deduction + " " + percentDeduction + " " + deductAmount);
                EmpDeductionCompositeKey compositeKey = new EmpDeductionCompositeKey(employeeNumber, deduction, formatDate());

                EmployeePayrollDeduction otherDeduction = new EmployeePayrollDeduction(compositeKey,
                        percentDeduction, deductAmount);
                employeePayrollDeductionService.add(otherDeduction);
                employeePayrollDeductions.add(otherDeduction);
            }
        }
        return otherDeductions;
    }
    private double calculateInsuranceDeductions(String employeeNumber, double basicSalary, List<EmployeePayrollDeduction> employeePayrollDeductions){
        double insuranceDeductions = 0;
        List<String> insuranceList = employeeInsuranceService.findInsuranceTypeByEmployeeId(employeeNumber);
        if (!insuranceList.isEmpty()) {
            for (String insuranceType : insuranceList) {
                double deductionPercentage = insuranceService.
                        findPercentageContributionByInsuranceType(insuranceType);
                System.out.println(insuranceType + " " + deductionPercentage);
                double deductAmount = deductionPercentage * basicSalary / 100;
                insuranceDeductions += deductAmount;

                // fill the employee payroll Deduction's table for each insurance an employee has
                EmpDeductionCompositeKey insurancesKey = new EmpDeductionCompositeKey(employeeNumber, insuranceType, formatDate());
                EmployeePayrollDeduction insurance = new EmployeePayrollDeduction(insurancesKey,
                        deductionPercentage, deductAmount);
                employeePayrollDeductionService.add(insurance);
                employeePayrollDeductions.add(insurance);

            }

        }
        return insuranceDeductions;
    }

    private double calculatePensionDeduction(String employeeNumber, double basicSalary,double grossSalary, List<EmployeePayrollDeduction> employeePayrollDeductions){
        double pensionDeduction = 0;
        double employeePercentage = 0;
        String pensionType = employeePensionService.findPensionTypeByEmployeeId(employeeNumber);
        System.out.println("pension:" + pensionType);
        if (pensionType != null){
            employeePercentage = pensionService.findEmployeePercentageByPensionType(pensionType);
            System.out.println("employee percentage: " + employeePercentage);
            if (pensionType.equalsIgnoreCase("napsa")){
                pensionDeduction =  employeePercentage * grossSalary  / 100;
            }
            else {
                pensionDeduction =  employeePercentage * basicSalary / 100;
            }
            EmpDeductionCompositeKey deductionKey = new EmpDeductionCompositeKey(employeeNumber, pensionType, formatDate());
            EmployeePayrollDeduction pension = new EmployeePayrollDeduction(deductionKey,
                    employeePercentage, pensionDeduction);

            employeePayrollDeductionService.add(pension);
            employeePayrollDeductions.add(pension);
        }

        System.out.println("Pension Type: "+ pensionType +  " " + pensionDeduction);
        return pensionDeduction;
    }


}

