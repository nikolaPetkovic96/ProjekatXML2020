package com.example.Automobil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.service.mapper.AutomobilMapper;

public class AutomobilService {
	@Autowired
	private AutomobilRepository autoRep;
	@Autowired
	private AutomobilMapper autoMapper;
	@Autowired
	private CommonDataRepository cmdRep;
	
	private List<AutomobilDTO> getAutomobils(){
		return null;
	}
	private AutomobilDTO getAutomobil(Long id) {
		return autoRep.findById(id).map(a -> autoMapper.toDTO(a)).orElse(null);
	}
}
