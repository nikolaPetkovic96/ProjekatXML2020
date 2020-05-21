package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLoginRegController {
	
	@GetMapping(value="testLogin")
	public String TestLoginController() {
		
		return "uspesno nalazenje servisa logovanja";
	}
	@GetMapping(value="testReg")
	public String TestRegController() {
		
		return "uspesno nalazenje servisa registracije";
	}

}
