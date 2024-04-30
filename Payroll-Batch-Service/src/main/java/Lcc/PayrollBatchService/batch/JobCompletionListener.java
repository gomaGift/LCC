package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.payrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JobCompletionListener implements JobExecutionListener {

    private final PayrollPdfGenerator pdfGenerator;
    private final PayrollService payrollService;

    @Autowired
    private EmployeePayrollDeductionService employeePayrollDeductionService;



    @Autowired
    private EmployeeService employeeService;


    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job Started: " + jobExecution.getJobInstance().getJobName());
    }
    @Override
    public void afterJob(JobExecution jobExecution) {

        String payrollDate = EmployeeProcessor.formatDate();

        List<PaySlipEmployeeData> employeeData = new ArrayList<>();

//        List<Payroll> payrollList = payrollService.findPayrollRecordsByDate(payrollDate);
//        payrollList.forEach(e -> System.out.println(e.getBasicSalary()));
        List<List<EmployeePayrollDeduction>> employeePayrollDeductions = new ArrayList<>();
//        for (Payroll payroll: payrollList){
//            List<EmployeePayrollDeduction> payrollDeductions = employeePayrollDeductionService.findAllDeductionsByEmployeeNumberAndDate(payroll.getKey().getEmployeeId(), payroll.getKey().getPaymentDate());
//            employeePayrollDeductions.add(payrollDeductions);
//
//            EmployeePersonalData employeePersonalData = employeePersonalDataService.findEmployeeDataByEmployeeNumber(payroll.getKey().getEmployeeId());
//            EmployeeBankDetails employeeBankDetails = employeeBankDetailService.findEmployeeBankDetailByEmployeeNumber(payroll.getKey().getEmployeeId());
//            Employee employeeDetails = employeeService.findEmployeeByEmployeeId(payroll.getKey().getEmployeeId());
//            String empFullname = employeePersonalData.getFirstname() + " " + employeePersonalData.getSurname();
//            PaySlipEmployeeData paySlipEmployeeData = new PaySlipEmployeeData("name","name","name","name",employeeDetails.getDateAppointedToCurrentPosition(),"name","name","name","name","name","name","name","name","name" ,"name");
//            employeeData.add(paySlipEmployeeData);
//
//        }

//        pdfGenerator.generatePayroll(payrollList, employeePayrollDeductions, employeeData);
        System.out.println("Job Completed: " + jobExecution.getJobInstance().getJobName());
        // You can add additional logic here, such as sending notifications or logging job completion status.
    }
}
