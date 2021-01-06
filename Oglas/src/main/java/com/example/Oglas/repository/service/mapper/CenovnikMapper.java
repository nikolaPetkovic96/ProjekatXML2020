package com.example.Oglas.repository.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.dto.CenovnikDTO;
import com.example.Oglas.model.Cenovnik;
import com.example.Oglas.repository.CenovnikRepository;
import com.example.Oglas.repository.service.CommonDataService;
@Component
public class CenovnikMapper {
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private CenovnikRepository cenRep;
	
	public CenovnikDTO toDTO(Cenovnik c) {
		CenovnikDTO dto=new CenovnikDTO(c);	
		return dto;
	}

}
