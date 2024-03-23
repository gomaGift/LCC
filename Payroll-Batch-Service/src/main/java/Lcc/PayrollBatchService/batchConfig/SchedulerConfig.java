package Lcc.PayrollBatchService.batchConfig;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.service.EmployeePdfGenerator;
import Lcc.PayrollBatchService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.ByteArrayInputStream;
import java.util.List;


@EnableScheduling
@Configuration
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfig {

    private final Job job;
    private final JobLauncher jobLauncher;


    @Scheduled(fixedDelay = 10000, initialDelay = 2000)
    public void scheduleJob() throws Exception {
        log.info("Job Started");
        jobLauncher
                .run(job, new JobParametersBuilder().
                        addLong("uniqueness", System.nanoTime()).toJobParameters());
    }
}
