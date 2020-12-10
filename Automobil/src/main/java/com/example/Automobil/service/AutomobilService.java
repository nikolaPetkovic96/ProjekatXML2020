package com.example.Automobil.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.service.mapper.AutomobilMapper;

@Service
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
	public List<AutomobilDTO> getAllAuto() {		
		return autoRep.findAll().stream().map(auto->autoMapper.toDTO(auto)).collect(Collectors.toList());
	}
}
