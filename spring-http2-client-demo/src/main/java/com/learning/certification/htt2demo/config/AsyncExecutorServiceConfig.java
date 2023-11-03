package com.learning.certification.htt2demo.config;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration

public class AsyncExecutorServiceConfig {

	@Bean
	public ThreadPoolTaskExecutor customThreadPool() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5); // Adjust the core pool size as needed
		executor.setMaxPoolSize(10); // Adjust the maximum pool size as needed
		executor.setThreadNamePrefix("async-okhttp-thread");
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}

	// Define a method to close the custom thread pool when the Spring context is
	// destroyed
	@PreDestroy
	public void destroyCustomThreadPool() {
		ThreadPoolTaskExecutor executor = customThreadPool();
		if (executor != null) {
			executor.shutdown();
		}
	}
}
