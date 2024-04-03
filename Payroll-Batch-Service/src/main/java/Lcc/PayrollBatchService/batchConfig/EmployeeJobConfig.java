package Lcc.PayrollBatchService.batchConfig;

import Lcc.PayrollBatchService.batch.EmployeeProcessor;
import Lcc.PayrollBatchService.batch.EmployeeReader;
import Lcc.PayrollBatchService.batch.EmployeeWriter;
import Lcc.PayrollBatchService.batch.JobCompletionListener;
import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import Lcc.PayrollBatchService.model.Payroll;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class EmployeeJobConfig {

    @Autowired
    private  EmployeeReader employeeReader;
    @Autowired
    private  EmployeeProcessor employeeProcessor;
    @Autowired
    private  EmployeeWriter employeeWriter;
    @Autowired
    private  JobCompletionListener jobCompletionListener;


    @Bean
    public Job employeeJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("employeeJob", jobRepository)
                .listener(jobCompletionListener)
                .incrementer(new RunIdIncrementer())
                .start(chunkStep(jobRepository, transactionManager))
                .build();
    }
    @Bean
    public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("employPayrollProcess1", jobRepository).<EmployeeOnPayroll, Payroll>
                chunk(10, transactionManager)
                .reader(employeeReader)
                .processor(employeeProcessor)
                .writer(employeeWriter)
                .build();

    }


}
