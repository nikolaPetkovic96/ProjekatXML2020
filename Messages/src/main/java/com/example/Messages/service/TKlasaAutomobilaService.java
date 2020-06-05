package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.repository.TKlasaAutomobilaRepository;

@Service
public class TKlasaAutomobilaService {

	@Autowired
	private TKlasaAutomobilaRepository tKlasaAutomobilaRepository;
	
	public List<TKlasaAutomobila> getAllTKlasaAutomobila(){
		List<TKlasaAutomobila> tKlaseAutomobila = new ArrayList<>();
		tKlasaAutomobilaRepository.findAll().forEach(tKlaseAutomobila::add);
		return tKlaseAutomobila;
	}
	
	public TKlasaAutomobila findOne(Long id) {
		return tKlasaAutomobilaRepository.findById(id).orElse(null);
	}
	public TKlasaAutomobila addTKlasaAutomobila(TKlasaAutomobila tKlasaAutomobila) throws Exception{
		if(tKlasaAutomobila.getId() != 0) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TKlasaAutomobila savedTKlasaAutomobila = tKlasaAutomobilaRepository.save(tKlasaAutomobila);
		return savedTKlasaAutomobila;
	}
	public TKlasaAutomobila updateTKlasaAutomobila(Long id, TKlasaAutomobila tKlasaAutomobila) throws Exception{
		Optional<TKlasaAutomobila> tKlasaAutomobilaToUpdate = tKlasaAutomobilaRepository.findById(id);
		if(tKlasaAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TKlasaAutomobila updateTKlasaAutomobila = tKlasaAutomobilaRepository.save(tKlasaAutomobila);
		return updateTKlasaAutomobila;
	}
	
	public void deleteTKlasaAutomobila(Long id) {
		tKlasaAutomobilaRepository.deleteById(id);
	}
}
