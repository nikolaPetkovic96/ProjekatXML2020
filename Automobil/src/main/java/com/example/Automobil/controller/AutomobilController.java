package com.example.Automobil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.service.AutomobilService;

@RestController
@RequestMapping(value = "/auto")
public class AutomobilController {

	@Autowired
	private AutomobilService autorServ;

	@GetMapping(value = "")
	public List<AutomobilDTO> getAutomobil(	@RequestParam(name = "auto_id", required = false) Long rezId
			){
		return autorServ.getAllAuto();
	}
}
