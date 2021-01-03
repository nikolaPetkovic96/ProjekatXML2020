package com.example.Automobil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Automobil.dto.AutomobilAgentDTO;
import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.service.AutomobilService;

@RestController
@RequestMapping("car")
public class AutomobilController {
	
	@Autowired
	private AutomobilService autoService;
	
	@GetMapping("")
	public List<AutomobilDTO> getAll() {
		return autoService.getAllAutomobil();
	}
	
	@GetMapping("agent")
	public List<AutomobilAgentDTO> getAllAgentsAutomobil() {
		
		return autoService.getAllAutomobilByAgent();
	}
}
