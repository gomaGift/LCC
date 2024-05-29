package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.payrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Slf4j
@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeOnPayroll, Payroll> {
    @Autowired
    private  EmployeeService employeeService;
    @Autowired
    private  EmployeePensionService employeePensionService;
    @Autowired
    private  EmployeeInsuranceService employeeInsuranceService;
    @Autowired
    private  InsuranceService insuranceService;
    @Autowired
    private  EmployeePayrollDeductionService employeePayrollDeductionService;
    @Autowired
    private  EmployeeOtherDeductionService employeeOtherDeductionService;
    @Autowired
    private  OtherDeductionService otherDeductionService;
    @Autowired
    private  PositionService positionService;
    @Autowired
    private  SalaryNotchService salaryNotchService;
    @Autowired
    private EmployeeBankDetailService employeeBankDetailService;
    @Autowired
    private PensionService pensionService;
    @Autowired
    private EmployeePersonalDataService employeePersonalDataService;
    @Autowired
    private PayrollPdfGenerator pdfGenerator;
    @Autowired
    private PayAsYouEarnTaxBandService payAsYouEarnTaxBandService;
    @Autowired
    private PayrollService payrollService;
    @Override
    public Payroll process(EmployeeOnPayroll employee) throws Exception {

        String empId = employee.getEmployeeId();
        System.out.println("Processing employee with: " + empId);
        String date = formatDate(); // get the current payment date

        Payroll payroll = new Payroll();
        payroll.setKey(new PayrollCompositeKey(empId, date));
        String employeePosition = employeeService.findPositionByEmployeeId(empId);
        Position position = positionService.findPositionByEmpPosition(employeePosition);

        String salaryScale = position.getSalaryScale();
        System.out.println(salaryScale);
        double basicSalary = salaryNotchService.findBasicSalaryBySalaryScale(salaryScale);

        double housingAllowance = position.getHousingAllowance() * basicSalary / 100;
        double educationAllowance = position.getEducationAllowance() * basicSalary / 100;
        double transportAllowance = position.getTransportAllowance() * basicSalary / 100;
        double fuelAllowance = position.getFuelAllowance() * basicSalary / 100;
        double riskAllowance = position.getRiskAllowance() * basicSalary / 100;

        log.info("\nbasic salary: {}", basicSalary);
        log.info("\nhousing allowance: {}" , housingAllowance);
        System.out.println("education allowance: {}" +educationAllowance);
        System.out.println("transport allowance: {}" +transportAllowance);
        System.out.println("fuel allowance: {}" + fuelAllowance);
        System.out.println("risk allowance: {}" + riskAllowance);

        double grossSalary  =  basicSalary
                            + housingAllowance
                            + educationAllowance
                            + transportAllowance
                            + riskAllowance
                            + fuelAllowance;
        System.out.println("gross salary: " + grossSalary);


        // pay as you earn/ income tax
        double payAsYouEarnDeductions = calculatePayAsYouEarn(empId, grossSalary);

        // pension deductions
        String pensionType = employeePensionService.findPensionTypeByEmployeeId(empId);
        log.info("\n");
        double pensionDeduction = calculatePensionDeduction(empId, pensionType, basicSalary, grossSalary);
        System.out.println(pensionType+ " "+ pensionDeduction);
        if (pensionType.equalsIgnoreCase("napsa")) {
            double napsaYearToDate = getPensionYearToDate(empId, pensionType) ;
            log.info("\n napsa year to year to date {}",napsaYearToDate);
            napsaYearToDate =+ pensionDeduction;
            log.info("\n napsa year to year to date + current pension amount {}", napsaYearToDate);
            payroll.setNapsaYearToDate(napsaYearToDate);
        }
        else {
            double pensionYearToDate = getPensionYearToDate(empId, pensionType);
            log.info("\npension year to date {}",pensionYearToDate);
            pensionYearToDate =+ pensionDeduction;
            log.info("\npension to year to date + current pension amount {}", pensionYearToDate);

            payroll.setPensionYearToDate(pensionYearToDate);
        }

        // get insurance Deductions
        double insuranceDeductions = calculateInsuranceDeductions(empId, basicSalary);

        //get other deductions
        double otherDeductions = calculateOtherDeductions(empId, basicSalary);

        // net salary
        double totalDeductions = roundOff(insuranceDeductions + otherDeductions + pensionDeduction +     payAsYouEarnDeductions);
        double netPay =  roundOff(grossSalary - totalDeductions);

        double ytdGrossSalary = getYtdGrossSalary(empId);
        double totalYtd = ytdGrossSalary+grossSalary;


        double taxPaidYearToDate = payrollService.findTaxPaidYearToDate(empId, getStartDate()) + payAsYouEarnDeductions;
        System.out.println("Tax paid year to date: " + taxPaidYearToDate);


        payroll.setBasicSalary(basicSalary);
        payroll.setTaxDue(payAsYouEarnDeductions);
        payroll.setGrossPayYearToDate(totalYtd);
        payroll.setTaxPaidYearToDate(taxPaidYearToDate);
        payroll.setGrossPay(grossSalary);
        payroll.setTaxableGross(grossSalary);
        payroll.setFuelAllowance(fuelAllowance);
        payroll.setNetPay(netPay);
        payroll.setEducationAllowance(educationAllowance);
        payroll.setHousingAllowance(housingAllowance);
        payroll.setTransportAllowance(transportAllowance);
        payroll.setTotalDeductions(totalDeductions);
        payroll.setRiskAllowance(riskAllowance);


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

//      pay as you earn calculation
      private double calculatePayAsYouEarn(String employeeNumber, double grossSalary){
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

                  }
                  break;
              }
              else {
                  if (taxBand.getUpperBound() < 0){
                      bandContribution = (grossSalary - previousBand.getUpperBound()) * taxBand.getPercentage() / 100.0;
                      payAsYouEarnDeductions += bandContribution;

                      break;
                  }
                  else {
                      if (previousBand == null) {
                          previousBand = taxBand;
                      }
                      else {
                          bandContribution = (taxBand.getUpperBound() - previousBand.getUpperBound()) * taxBand.getPercentage()/ 100.0;
                          payAsYouEarnDeductions += bandContribution;

                          previousBand = taxBand;

                      }
                  }

              }

          }
          EmpDeductionCompositeKey deductionKey = new EmpDeductionCompositeKey(employeeNumber, "P.A.Y.E(INCOME TAX)" , formatDate());
          EmployeePayrollDeduction payAsYouEarn = new EmployeePayrollDeduction(deductionKey,
                  0, payAsYouEarnDeductions);

          employeePayrollDeductionService.add(payAsYouEarn);
       return payAsYouEarnDeductions;
      }
     /* Calculates other employee deductions e.g union contribution*/
    private double calculateOtherDeductions(String employeeNumber, double basicSalary){
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

            }
        }
        return otherDeductions;
    }
    private double calculateInsuranceDeductions(String employeeNumber, double basicSalary){
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


            }

        }
        return insuranceDeductions;
    }

    private double calculatePensionDeduction(String employeeNumber,String pensionType, double basicSalary,double grossSalary){
        double pensionDeduction = 0;
        double employeePercentage = 0;

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

        }

        System.out.println("Pension Type: "+ pensionType +  " " + pensionDeduction);
        return pensionDeduction;
    }

    private Date getStartDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
         return  calendar.getTime();
    }

    private double getYtdGrossSalary(String empId) throws ParseException {
        // Get the start of the current year (January 1st)
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate =  calendar.getTime();
        System.out.println("start date "+ startDate);
        SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date formattedDate = desiredFormat.parse(desiredFormat.format(startDate));
        System.out.println("formatted date " + formattedDate);
        return payrollService.findYtdGrossSalary(empId, formattedDate);
    }

    private double getPensionYearToDate(String employeeId, String deductionType){
        return employeePayrollDeductionService.getPensionYearToDate(employeeId,deductionType, getStartDate());
    }


}
