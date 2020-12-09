package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.MarkaAutomobila;
import com.team32.AgentApp.repository.MarkaAutomobilaRepository;

@Service
public class MarkaAutomobilaService {

	@Autowired
	private MarkaAutomobilaRepository markaAutomobilaRepository;
	
	public List<MarkaAutomobila> getAllMarkaAutomobila(){
		List<MarkaAutomobila> markeAutomobila = new ArrayList<>();
		markaAutomobilaRepository.findAll().forEach(markeAutomobila::add);
		return markeAutomobila;
	}
	
	public MarkaAutomobila findOne(Long id) {
		return markaAutomobilaRepository.findById(id).orElse(null);
	}
	public MarkaAutomobila addMarkaAutomobila(MarkaAutomobila markaAutomobila) throws Exception{
		if(markaAutomobila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		MarkaAutomobila savedMarkaAutomobila = markaAutomobilaRepository.save(markaAutomobila);
		return savedMarkaAutomobila;
	}
	
	public MarkaAutomobila updateMarkaAutomobila(Long id, MarkaAutomobila markaAutomobila) throws Exception{
		Optional<MarkaAutomobila> markaAutomobilaToUpdate = markaAutomobilaRepository.findById(id);
		if(markaAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		MarkaAutomobila updateMarkaAutomobila = markaAutomobilaRepository.save(markaAutomobila);
		return updateMarkaAutomobila;
	}
	public void deleteMarkaAutomobila(Long id) {
		markaAutomobilaRepository.deleteById(id);
	}
	
}
