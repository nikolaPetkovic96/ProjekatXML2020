package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.repository.AutomobilRepository;

@Service
public class AutomobilService {

	@Autowired
	private AutomobilRepository automobilRepository;
	
	public List<Automobil> getAllAutomobil(){
		List<Automobil> listaAutomobila = new ArrayList<>();
		automobilRepository.findAll().forEach(listaAutomobila::add);
		return listaAutomobila;
	}
	
	public Automobil findOne(Long id) {
		return automobilRepository.findById(id).orElseGet(null);
	}
	
	public Automobil addAutomobil(Automobil automobil) throws Exception {
		if(automobil.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Automobil savedAutomobil = automobilRepository.save(automobil);
		return savedAutomobil;	
	}
	
	public Automobil updateAutomobil(Long id, Automobil automobil) throws Exception{
		Optional<Automobil> automobilToUpdate = automobilRepository.findById(id);
		if(automobilToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Automobil updateAutomobil = automobilRepository.save(automobil);
		return updateAutomobil;
	}
	
	public void deleteAutomobil(Long id) {
		automobilRepository.deleteById(id);
	}
	
}
