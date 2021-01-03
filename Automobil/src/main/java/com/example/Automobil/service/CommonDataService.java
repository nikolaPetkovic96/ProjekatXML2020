package com.example.Automobil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Automobil.model.CommonData;
import com.example.Automobil.repository.CommonDataRepository;

@Component
public class CommonDataService {

	@Autowired
	private CommonDataRepository commonDataRepository;
	
	public CommonData findOne(Long id) {
		return commonDataRepository.findById(id).orElseGet(null);
	}
}
