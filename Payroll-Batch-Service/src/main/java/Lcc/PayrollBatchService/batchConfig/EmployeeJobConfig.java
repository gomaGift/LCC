package Lcc.PayrollBatchService.batchConfig;

import Lcc.PayrollBatchService.batch.*;
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
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
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

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private PayrollProcessorTasklet payrollProcessorTasklet;

    @Bean
    public Job employeeJob() {
        return new JobBuilder("employeeJob", jobRepository)
                .listener(jobCompletionListener)

                .incrementer(new RunIdIncrementer())
                .start(chunkStep())
                .next(payrollProcessTaskletStep())
                .build();
    }
    @Bean
    public Step chunkStep() {
        return new StepBuilder("employPayrollProcess1", jobRepository).<EmployeeOnPayroll, Payroll>
                chunk(1, transactionManager)
                .reader(employeeReader)
                .processor(employeeProcessor)
                .writer(employeeWriter)
                .build();
    }
    @Bean
    public Step payrollProcessTaskletStep(){
        return  new StepBuilder("payrollProcessorTasklet", jobRepository)
                            .tasklet(payrollProcessorTasklet,transactionManager)
                            .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(8);
        return taskExecutor;
    }


}
