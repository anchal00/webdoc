package com.example.webdoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ThreadPoolTaskSchedulerConfig {

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(DEFAULT_THREAD_POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("Task ::: ");
        return threadPoolTaskScheduler;
    }
}