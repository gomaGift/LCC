package Lcc.PayrollBatchService.batchConfig;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    private  Job job;
    @Autowired
    private JobLauncher jobLauncher;

//   @Scheduled(fixedDelay = 2000, initialDelay = 1000) // for test purposes
     @Scheduled(cron = "0 59 3 * * *") // runs every 15th day of the month
    public void scheduleJob() throws Exception {

        jobLauncher
                .run(job, new JobParametersBuilder().
                        addLong("startAt", System.currentTimeMillis()).toJobParameters());
    }

    }

    

