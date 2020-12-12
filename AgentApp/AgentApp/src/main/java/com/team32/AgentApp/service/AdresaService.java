package com.team32.AgentApp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.repository.AdresaRepository;


@Service
public class AdresaService {
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	public List<Adresa> getAllAdresa(){
		List<Adresa> tAdrese = new ArrayList<>();
		adresaRepository.findAll().forEach(tAdrese::add);
		return tAdrese;
	}
	
	public Adresa findOne(Long id) {
		return adresaRepository.findById(id).orElse(null);
	}
	
	public Adresa addAdresa(Adresa adresa) throws Exception{
		if(adresa.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Adresa savedAdresa = adresaRepository.save(adresa);
		return savedAdresa;
	}
	public Adresa updateAdresa(Long id, Adresa adresa) throws Exception{
		Optional<Adresa> adresaToUpdate = adresaRepository.findById(id);
		if(adresaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Adresa updateAdresa = adresaRepository.save(adresa);
		return updateAdresa;
	}
	public void deleteAdresa(Long id) {
		adresaRepository.deleteById(id);
	}
 
}
