package Lcc.PayrollBatchService.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionListener implements JobExecutionListener {
    @Autowired
    private EmployeeReportPDFGenerator pdfGenerator;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job Started: " + jobExecution.getJobInstance().getJobName());
    }
    @Override
    public void afterJob(JobExecution jobExecution) {
//        pdfGenerator.generatePdfReport();
        System.out.println("Job Completed: " + jobExecution.getJobInstance().getJobName());
        // You can add additional logic here, such as sending notifications or logging job completion status.
    }
}
