package com.example.LoginReg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegController {
	@GetMapping(value="testLogin")
	public String TestLoginController() {
		
		return "uspesno nalazenje servisa logovanja";
	}
	@GetMapping(value="testReg")
	public String TestRegController() {
		
		return "uspesno nalazenje servisa registracije";
	}
}
