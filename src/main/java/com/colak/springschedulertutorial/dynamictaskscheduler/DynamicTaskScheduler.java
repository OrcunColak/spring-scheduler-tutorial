package com.colak.springschedulertutorial.dynamictaskscheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DynamicTaskScheduler {

    private final TaskScheduler taskScheduler;

    public void scheduleTask(String cronExpression,Runnable runnable) {
        taskScheduler.schedule(
                runnable,
                new CronTrigger(cronExpression)
        );
    }
}
