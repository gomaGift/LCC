package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.PayrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JobCompletionListener implements JobExecutionListener {

    private final PayrollPdfGenerator pdfGenerator;
    private final PayrollService payrollService;



    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job Started: " + jobExecution.getJobInstance().getJobName());
    }
    @Override
    public void afterJob(JobExecution jobExecution) {
        String payrollDate = EmployeeProcessor.formatDate();
        List<Payroll> payrollList = payrollService.findPayrollRecordsByDate(payrollDate);
        pdfGenerator.generatePayroll(payrollList);
        System.out.println("Job Completed: " + jobExecution.getJobInstance().getJobName());
        // You can add additional logic here, such as sending notifications or logging job completion status.
    }
}
