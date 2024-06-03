package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.payrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.respository.PayrollRepository;
import Lcc.PayrollBatchService.service.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PayrollProcessorTasklet implements Tasklet {

    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private EmployeePersonalDataService employeePersonalDataService;
    @Autowired
    private EmployeeBankDetailService employeeBankDetailService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeePayrollDeductionService employeePayrollDeductionService;
    @Autowired
    private PayrollPdfGenerator pdfGenerator;
    @Autowired
    private EmailService emailService;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        int currentYear = date.getYear();
        List<Payroll> payrollList = payrollRepository.findByMonthAndYear(currentMonth, currentYear);

        payrollList.forEach(payroll -> {
            EmployeePersonalData employeePersonalData = employeePersonalDataService.findEmployeeDataByEmployeeNumber(payroll.getKey().getEmployeeId());
            // retrieve employee bank details
            EmployeeBankDetails employeeBankDetails = employeeBankDetailService.findEmployeeBankDetailByEmployeeNumber(payroll.getKey().getEmployeeId());
            // access other employee data
            Employee employeeDetails = employeeService.findEmployeeByEmployeeId(payroll.getKey().getEmployeeId());
            String empFullname = employeePersonalData.getFirstname() + " " + employeePersonalData.getSurname();
            PaySlipEmployeeData empInfo = new PaySlipEmployeeData(payroll.getKey().getEmployeeId(),empFullname,employeePersonalData.getNrc(),employeePersonalData.getNrc(), employeeDetails.getDateAppointedToCurrentPosition(), employeeDetails.getEmploymentType(),"name","name",employeeBankDetails.getBranch(),"name","name",employeeBankDetails.getBankName(),employeeBankDetails.getAccountNumber(),"name" ,"");
            List<EmployeePayrollDeduction> employeePayrollDeductions = employeePayrollDeductionService.findAllDeductionsByEmployeeNumberAndDate(payroll.getKey().getEmployeeId(), payroll.getKey().getPaymentDate());

            byte[] payrollBytes =  pdfGenerator.generatePayroll(payroll, employeePayrollDeductions, empInfo, empFullname);
            emailService.sendMail(payrollBytes, employeePersonalData.getEmail(), empFullname);
//            emailService.sendMail(payrollBytes, "Bank email", empFullname); send payroll to employee Bank

        });
        return RepeatStatus.FINISHED;
    }
}
