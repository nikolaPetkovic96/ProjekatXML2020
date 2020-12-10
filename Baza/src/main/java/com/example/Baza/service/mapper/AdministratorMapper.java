package com.example.Baza.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Baza.repository.AdministratorRepository;

@Component
public class AdministratorMapper {
	
	@Autowired
	private AdministratorRepository adminRep;
	
	@Autowired 
	private TAdresaMapper adresaMapper;
	
}
