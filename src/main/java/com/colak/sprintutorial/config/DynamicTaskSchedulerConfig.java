package com.colak.sprintutorial.config;

import com.colak.sprintutorial.dynamictaskscheduler.DynamicTaskScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DynamicTaskSchedulerConfig {

    // A scheduled task is run by "scheduling-n" thread
    // Schedule using my class that is DynamicTaskScheduler
    @Bean
    CommandLineRunner commandLineRunner(DynamicTaskScheduler dynamicTaskScheduler) {
        return args -> dynamicTaskScheduler.scheduleTask(
                "0/10 * * * * ?", // Runs every 10 seconds
                () -> log.info("Dynamically scheduled task running."));
    }
}
