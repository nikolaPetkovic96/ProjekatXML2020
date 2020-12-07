package com.team32.AgentApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class AgentController {
	
	@PostMapping(value="/login")
	public void login() {
	}
	
	@PostMapping(value="/refresh")
	public void refreshToken() {		
	}
	@ResponseBody
	@GetMapping(value="/dummy")
	public String dummy() {
		return "<h1 style='color:gold'>Working!</h1>";
	}
}