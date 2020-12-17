package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.repository.OglasRepository;


@Service
public class OglasService {

	@Autowired
	private OglasRepository oglasRepository;
	
	@Autowired
	private CommonDataService comDataService;
	
	public List<Oglas> getAllOglas(){
		List<Oglas> oglasi = new ArrayList<>();
		oglasRepository.findAll().forEach(oglasi::add);
		return oglasi;
	}
	
	public Oglas findOne(Long id) {
		return oglasRepository.findById(id).orElse(null);
	}
	
	public Oglas addOglas(Oglas oglas) throws Exception{
		if(oglas.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Oglas savedOglas = oglasRepository.save(oglas);
		return savedOglas;
	}
	public Oglas updateOglas(Long id, Oglas oglas) throws Exception{
		Optional<Oglas> oglasToUpdate = oglasRepository.findById(id);
		if(oglasToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Oglas updateOglas = oglasRepository.save(oglas);
		return updateOglas;
	}
	public void deleteOglas(Long id) {
		oglasRepository.deleteById(id);
	}

	//Dodatne metode
	
	//Metoda koja vraca sve oglase napravljene od strane jednog agenta
	public List<Oglas> getAllOglasByAgentId(Long agentId) {
		List<Oglas> oglasi = new ArrayList<>();
		
		//Dobavim sve oglase iz baze
		List<Oglas> sviOglasi = oglasRepository.findAll();
		
		//Prolazim kroz oglase i proveravam da li je agentId = userId u commonData oglasa
		for(Oglas o : sviOglasi){
			if(comDataService.findOne(o.getCommonDataId()).getUserid() == agentId) {
				oglasi.add(o);
			}
		}
		return oglasi;	
	}
}
