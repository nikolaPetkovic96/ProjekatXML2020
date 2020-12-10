package com.example.LoginReg.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
