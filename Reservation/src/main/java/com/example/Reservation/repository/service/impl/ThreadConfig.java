//package com.example.Reservation.repository.service.impl;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import rx.annotations.Beta;
//
//@Configuration("threadConfig")
//public class ThreadConfig {
//
//	@Bean
//	public TaskExecutor threadPoolTaskExecutor() {
//		ThreadPoolTaskExecutor exec=new ThreadPoolTaskExecutor();
//		exec.setCorePoolSize(4);
//		exec.setMaxPoolSize(4);
//		exec.setThreadGroupName("defaultName");
//		exec.initialize();
//		return exec;
//	}
//
//}
