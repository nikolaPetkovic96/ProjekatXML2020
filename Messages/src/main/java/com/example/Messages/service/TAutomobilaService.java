package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TAutomobila;
import com.example.Messages.repository.TAutomobilaRepository;

@Service
public class TAutomobilaService {

	@Autowired
	private TAutomobilaRepository tAutomobilaRepository;
	
	public List<TAutomobila> getAllTAutomobila(){
		List<TAutomobila> tAutomobili = new ArrayList<>();
		tAutomobilaRepository.findAll().forEach(tAutomobili::add);
		return tAutomobili;
	}
	
	public TAutomobila findOne(Long id) {
		return tAutomobilaRepository.findById(id).orElse(null);
	}
	public TAutomobila addTAutomobila(TAutomobila tAutomobila) throws Exception{
		if(tAutomobila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TAutomobila savedTAutomobila = tAutomobilaRepository.save(tAutomobila);
		return savedTAutomobila;
	}
	
	public TAutomobila updateTAutomobila(Long id, TAutomobila tAutomobila) throws Exception{
		Optional<TAutomobila> tAutomobilaToUpdate = tAutomobilaRepository.findById(id);
		if(tAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TAutomobila updateTAutomobila = tAutomobilaRepository.save(tAutomobila);
		return updateTAutomobila;
	}
	public void deleteTAutomobila(Long id) {
		tAutomobilaRepository.deleteById(id);
	}
	
	
}
