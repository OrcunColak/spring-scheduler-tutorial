package com.colak.sprintutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling

@Slf4j
public class SchedulerConfig {

    // A scheduled task is run by "scheduling-n" thread
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task");
    }

    // A scheduled task is run by "scheduling-n" thread
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {
        log.info("Fixed rate task with one second initial delay");
    }

    // runs at 10 AM every day
    // A scheduled task is run by "scheduling-n" thread
    @Scheduled(cron = "0 0 10 * * ?")
    public void performDailyTask() {
        log.info("Performing the daily task.");
    }
}