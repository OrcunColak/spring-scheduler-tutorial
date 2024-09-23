package com.colak.sprintutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@Slf4j
public class AsyncSchedulerConfig {

    // Schedule a task to run asynchronously.
    // Normally a scheduled task is run by "scheduling-n" thread
    // However since this task is marked as @Async, this task is run by "task-n" thread
    @Scheduled(fixedRate = 5000)
    @Async
    public void scheduledTask() {
        log.info("Scheduled task running asynchronously every 5 seconds");
    }
}