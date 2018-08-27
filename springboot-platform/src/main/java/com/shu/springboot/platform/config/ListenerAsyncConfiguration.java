package com.shu.springboot.platform.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author shudongping
 * @date 2018/07/17
 */
@Configuration
@EnableAsync
public class ListenerAsyncConfiguration implements AsyncConfigurer {


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置线程池参数
        taskExecutor.setCorePoolSize(50);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setQueueCapacity(250);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {


        return null;
    }
}
