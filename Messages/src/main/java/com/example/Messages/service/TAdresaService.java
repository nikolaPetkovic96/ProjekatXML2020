package com.example.Messages.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;
import com.example.Messages.repository.TAdresaRepository;

@Service
public class TAdresaService {
	
	@Autowired
	private TAdresaRepository tAdresaRepository;
	
	public List<TAdresa> getAllTAdresa(){
		List<TAdresa> tAdrese = new ArrayList<>();
		tAdresaRepository.findAll().forEach(tAdrese::add);
		return tAdrese;
	}
	
	public TAdresa findOne(Long id) {
		return tAdresaRepository.findById(id).orElse(null);
	}
	public TAdresa addTAdresa(TAdresa tAdresa) throws Exception{
		if(tAdresa.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TAdresa savedTAdresa = tAdresaRepository.save(tAdresa);
		return savedTAdresa;
	}
	public TAdresa updateTAdresa(Long id, TAdresa tAdresa) throws Exception{
		Optional<TAdresa> tAdresaToUpdate = tAdresaRepository.findById(id);
		if(tAdresaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen."); 
		}
		TAdresa updateTAdresa = tAdresaRepository.save(tAdresa);
		return updateTAdresa;
	}
	public void deteleTAdresa(Long id) {
		tAdresaRepository.deleteById(id);
	}
	

}
