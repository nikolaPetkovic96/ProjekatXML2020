package com.example.Messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"com.example.Messages"}) // scan JPA entities
@EnableAutoConfiguration
public class MessagesApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(MessagesApplication.class, args);
	}

}
