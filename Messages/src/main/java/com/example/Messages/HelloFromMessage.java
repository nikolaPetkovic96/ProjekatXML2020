package com.example.Messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFromMessage {
	
	@GetMapping(value="/testMessage")
	public String helloFromReservation() {
		return "Hello from Message!";
	}
}
