package com.example.Reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFromReservation {
		
		@GetMapping(value="/testReservation")
		public String helloFromReservation() {
			return "Hello from Reservation!";
		}
}
