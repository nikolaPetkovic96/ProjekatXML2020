package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPretraga {
	@GetMapping(value="/testPretraga")
	public String testPretraga() {
		return "uspesno nalazenje servisa pretrage!";
	}
}
