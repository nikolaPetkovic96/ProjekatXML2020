package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestKomentarController {
	
	@GetMapping(value="testKomentar")
	public String TestKomentarController() {
		return "uspesno nalazenje servisa komentar !";
	}
}
