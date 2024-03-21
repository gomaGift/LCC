package Lcc.PayrollBatchService.batchConfig;

import Lcc.PayrollBatchService.batch.EmployeeProcessor;
import Lcc.PayrollBatchService.batch.EmployeeReader;
import Lcc.PayrollBatchService.batch.EmployeeWriter;
import Lcc.PayrollBatchService.model.Employee;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class EmployeeJobConfig {

    private final EmployeeReader employeeReader;
    private final EmployeeProcessor employeeProcessor;
    private final EmployeeWriter employeeWriter;

    @Bean
    public Job employeeJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("employeeJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(chunkStep(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("employPayrollProcess1", jobRepository).<Employee, Employee>
                chunk(10, transactionManager)
                .reader(employeeReader)
                .processor(employeeProcessor)
                .writer(employeeWriter)
                .build();

    }

}
