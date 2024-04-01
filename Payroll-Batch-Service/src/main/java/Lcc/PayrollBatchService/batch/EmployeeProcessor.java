package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final PayrollService payrollService;
    // Do processing here
    @Override
    public Payroll process(EmployeeOnPayroll employee) throws Exception {

        String empId = employee.getEmployeeId();
        System.out.println("Processing employee with: " + empId);
        String date = formatDate(); // get the current payment date

        Position position = employeeService.findPositionByEmployeeId(empId);

        // obtain the basic salary and calculate the allowances and gross
        double basicSalary = position.getSalaryScale().getBasicSalary();
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
        // pension deductions
        String pensionType = employeePensionService.findPensionTypeByEmployeeId(empId);


        double employeePercentage = employeePensionService.findEmployeePercentageByPensionType(pensionType);

        double pensionDeduction = 0;
        if (pensionType.equalsIgnoreCase("napsa")){
            pensionDeduction = -1 * employeePercentage * grossSalary  / 100;
        }
        else {
            pensionDeduction = -1 * employeePercentage * basicSalary / 100;
        }
        EmpDeductionCompositeKey deductionKey = new EmpDeductionCompositeKey(empId, pensionType, date);
        employeePayrollDeductionService.add(new EmployeePayrollDeduction(deductionKey,
                employeePercentage, pensionDeduction));


        System.out.println(pensionType +  " " + pensionDeduction);

        // insurance deductions
        List<String> insuranceList = employeeInsuranceService.findInsuranceTypeByEmployeeId(empId);
        double insuranceDeductions = 0;
        for (String insuranceType : insuranceList) {
            double deductionPercentage = insuranceService.
                    findPercentageContributionByInsuranceType(insuranceType);
            System.out.println(insuranceType + " " + deductionPercentage );
            double deductAmount = -1 * deductionPercentage * basicSalary / 100;
            insuranceDeductions += deductAmount;

           // fill the employee payroll Deduction's table for each insurance an employee has
            EmpDeductionCompositeKey insurancesKey = new EmpDeductionCompositeKey(empId, insuranceType, date);
            employeePayrollDeductionService.add(new EmployeePayrollDeduction(insurancesKey,
                    deductionPercentage, deductAmount));

      }
        System.out.println(insuranceDeductions);
        //other deductions
       List<String> otherDeductionList = employeeOtherDeductionService.findOtherDeductionByEmployeeId(empId);
       double otherDeductions = 0;
        for (String deduction : otherDeductionList) {
            double percentDeduction = otherDeductionService.findPercentageDeductionByDeductionType(deduction);
            double deductAmount = -1 * percentDeduction * basicSalary / 100;
            otherDeductions += deductAmount;
            System.out.println(deduction + " " + percentDeduction + " " + deductAmount);
            EmpDeductionCompositeKey compositeKey = new EmpDeductionCompositeKey(empId, deduction, date);
            employeePayrollDeductionService.add(new EmployeePayrollDeduction(compositeKey,percentDeduction,deductAmount));
        }
        // net salary
        double totalDeductions = insuranceDeductions + otherDeductions + pensionDeduction;
        double netPay = grossSalary + totalDeductions;


        PayrollCompositeKey key = new PayrollCompositeKey(empId, date);
        Payroll payroll = new  Payroll(key, basicSalary, housingAllowance,educationAllowance, transportAllowance, fuelAllowance, riskAllowance,totalDeductions,netPay,grossSalary);
        System.out.println("netpay: " + netPay);
        return payroll;


    }
        public static String formatDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyy");
        return date.format(formatter);
    }


    }

