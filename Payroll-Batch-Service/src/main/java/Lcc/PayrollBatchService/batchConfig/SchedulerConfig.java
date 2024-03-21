package Lcc.PayrollBatchService.batchConfig;

import Lcc.PayrollBatchService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfig {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(cron = "0 0 0 15 * *")
    public void scheduleJob() throws Exception{
        log.info("In handling all employees");
        jobLauncher
                .run(job, new JobParametersBuilder().
                        addLong("uniqueness", System.nanoTime()).toJobParameters());
        log.info("Job done");
    }
}
