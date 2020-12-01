package com.example.Oglas.repository.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.OglasRepository;
import com.example.Oglas.repository.service.mapper.OglasMapper;

@Service
public class OglasService {
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired 
	private OglasMapper oglasMapper;
	@Autowired
	private OglasRepository oglasRep;
	
	public OglasDTO getOglas(Long id) {
		return oglasRep.findById(id).map(oglas-> oglasMapper.toDTO(oglas)).orElse(null);
	}
	
	public List<OglasDTO> getOglaseForUser(Long userId){//user id
		return oglasRep.findAll().stream().
				filter(oglas-> oglas.getId()==userId).
				map(oglas->oglasMapper.toDTO(oglas))
				.collect(Collectors.toList());
	}
	
	public Boolean deleteOglas(Long id) {
		
		try {
			oglasRep.deleteById(id);
		}catch(Exception e){
			System.out.println("Oglas sa id: "+id+" nije uspesno obrisan");
			return false;
		}
		return true;		
	}
	public OglasDTO addOglas(OglasDTO dto) {
		Oglas o=oglasMapper.fromDTO(dto);
		oglasRep.saveAndFlush(o);
		return oglasMapper.toDTO(o);
	}
}
