package Lcc.PayrollBatchService.batchConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@Configuration
@Slf4j
@RequiredArgsConstructor
public class SchedulerConfig {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 1000, initialDelay = 1000) // for test purposes
    // @Scheduled(cron = "0 0 0 15 0 0") // runs every 15th day of the month
    public void scheduleJob() throws Exception {
        log.info("Job Started");
        jobLauncher
                .run(job, new JobParametersBuilder().
                        addLong("uniqueness", System.nanoTime()).toJobParameters());


    }




    }

    

