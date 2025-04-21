# yaml file
Spring picks this configuriation automatically if virtual threads are not used. If virtual threads are used then code is required
```yaml
spring:
  task:
    scheduling:
      pool:
        size: 5
```
For example
```java
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@EnableConfigurationProperties(TaskSchedulingProperties.class)
public class SchedulerConfig {

    private final boolean virtualThreadsEnabled;

    public SchedulerConfig(Environment env) {
        this.virtualThreadsEnabled = env.getProperty("spring.threads.virtual.enabled", Boolean.class, false);
    }

    @Bean
    public TaskScheduler taskScheduler(TaskSchedulingProperties properties) {
        if (virtualThreadsEnabled) {
            return task -> Thread.startVirtualThread(task);
        } else {
            ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
            scheduler.setPoolSize(properties.getPool().getSize());
            scheduler.setThreadNamePrefix(properties.getThreadNamePrefix());
            return scheduler;
        }
    }
}

```
# Cron

The original idea is from  
https://medium.com/@kiarash.shamaii/distributed-lock-spring-in-deep-f6a463d4c7b6

# Dynamic Scheduling

The original idea is from  
https://medium.com/@ak123aryan/mastering-task-scheduling-in-spring-boot-a-guide-with-java-code-examples-e8aab648a3b7

# Best Practices
1. Always log the start and completion of tasks
2. Name your scheduler classes with Scheduler suffix 
