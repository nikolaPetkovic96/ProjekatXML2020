package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestOcenaController {
	@GetMapping(value="/testOcena")
	public String TestOcenController() {
		return "uspesno nalazenje servisa Ocene";
	}
}
