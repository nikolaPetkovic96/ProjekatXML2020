package com.example.Messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessagesApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(MessagesApplication.class, args);
	}

}
