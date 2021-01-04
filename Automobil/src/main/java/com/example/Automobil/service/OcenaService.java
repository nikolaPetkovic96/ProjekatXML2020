package com.example.Automobil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Automobil.model.Ocena;
import com.example.Automobil.repository.OcenaRepository;
import com.example.Automobil.service.mapper.OcenaMapper;

public class OcenaService {

	@Autowired
	private OcenaRepository ocenaRep;
	@Autowired
	private OcenaMapper ocenaMap;
	
	public List<Ocena> findAllforAutoId(Long autoId){
		return ocenaRep.findAll().stream().filter(x->x.getAutomobilId().equals(autoId)).collect(Collectors.toList());
	}
}
