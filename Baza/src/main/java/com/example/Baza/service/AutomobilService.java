package com.example.Baza.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Baza.dto.AutomobilDTO;
import com.example.Baza.repository.AutomobilRepository;
import com.example.Baza.repository.CommonDataRepository;
import com.example.Baza.service.mapper.AutomobilMapper;

@Service
public class AutomobilService {
	@Autowired
	private AutomobilRepository autoRep;
	@Autowired
	private AutomobilMapper autoMapper;
	@Autowired
	private CommonDataRepository cmdRep;
	
	public AutomobilDTO getAutomobil(Long id) {
		return autoRep.findById(id).map(a -> autoMapper.toDTO(a)).orElse(null);
	}
	public List<AutomobilDTO> getAllAuto() {		
		return autoRep.findAll().stream().map(auto->autoMapper.toDTO(auto)).collect(Collectors.toList());
	}
}
