package com.example.Baza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Baza.dto.AutomobilDTO;
import com.example.Baza.service.AutomobilService;



@RestController
@RequestMapping(value = "/automobil")
public class AutomobilController {

	@Autowired
	private AutomobilService autorServ;

	@GetMapping(value = "")
	public List<AutomobilDTO> getPoruke(	@RequestParam(name = "auto_id", required = false) Long rezId
			){
		return autorServ.getAllAuto();
	}

}
