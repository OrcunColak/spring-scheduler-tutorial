package com.colak.sprintutorial.config;

import com.colak.sprintutorial.dynamictaskscheduler.DynamicTaskScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
@Slf4j
public class SchedulerConfig {

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task");
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {
        log.info("Fixed rate task with one second initial delay");
    }

    // runs at 10 AM every day
    @Scheduled(cron = "0 0 10 * * ?")
    public void performDailyTask() {
        log.info("Performing the daily task.");
    }

    @Bean
    CommandLineRunner commandLineRunner(DynamicTaskScheduler dynamicTaskScheduler) {
        return args -> dynamicTaskScheduler.scheduleTask(
                "0/10 * * * * ?", // Runs every 10 seconds
                () -> log.info("Dynamically scheduled task running."));
    }
}