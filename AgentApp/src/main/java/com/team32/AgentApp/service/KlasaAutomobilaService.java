package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.KlasaAutomobila;
import com.team32.AgentApp.repository.KlasaAutomobilaRepository;

@Service
public class KlasaAutomobilaService {

	@Autowired
	private KlasaAutomobilaRepository klasaAutomobilaRepository;
	
	public List<KlasaAutomobila> getAllKlasaAutomobila(){
		List<KlasaAutomobila> klaseAutomobila = new ArrayList<>();
		klasaAutomobilaRepository.findAll().forEach(klaseAutomobila::add);
		return klaseAutomobila;
	}
	
	public KlasaAutomobila findOne(Long id) {
		return klasaAutomobilaRepository.findById(id).orElse(null);
	}
	public KlasaAutomobila addKlasaAutomobila(KlasaAutomobila klasaAutomobila) throws Exception{
		if(klasaAutomobila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		KlasaAutomobila savedTKlasaAutomobila = klasaAutomobilaRepository.save(klasaAutomobila);
		return savedTKlasaAutomobila;
	}
	public KlasaAutomobila updateKlasaAutomobila(Long id, KlasaAutomobila klasaAutomobila) throws Exception{
		Optional<KlasaAutomobila> klasaAutomobilaToUpdate = klasaAutomobilaRepository.findById(id);
		if(klasaAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		KlasaAutomobila updateTKlasaAutomobila = klasaAutomobilaRepository.save(klasaAutomobila);
		return updateTKlasaAutomobila;
	}
	
	public void deleteKlasaAutomobila(Long id) {
		klasaAutomobilaRepository.deleteById(id);
	}
}
