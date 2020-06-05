package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.repository.TModelAutomobilaRepository;

@Service
public class TModelAutomobilaService {

	@Autowired
	private TModelAutomobilaRepository tModelAutomobilaRepository;
	
	public List<TModelAutomobila> getAllTModelAutomobila(){
		List<TModelAutomobila> tModeliAutomobila = new ArrayList<>();
		tModelAutomobilaRepository.findAll().forEach(tModeliAutomobila::add);
		return tModeliAutomobila;
	}
	
	public TModelAutomobila findOne(Long id) {
		return tModelAutomobilaRepository.findById(id).orElse(null);
	}
	public TModelAutomobila addTModelAutomobila(TModelAutomobila tModelAutomobila) throws Exception{
		if(tModelAutomobila.getId() != 0) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TModelAutomobila savedTModelAutomobila = tModelAutomobilaRepository.save(tModelAutomobila);
		return savedTModelAutomobila;
	}
	
	public TModelAutomobila updateTModelAutomobila(Long id, TModelAutomobila tModelAutomobila) throws Exception{
		Optional<TModelAutomobila> tModelAutomobilaToUpdate = tModelAutomobilaRepository.findById(id);
		if(tModelAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TModelAutomobila updateTModelAutomobila = tModelAutomobilaRepository.save(tModelAutomobila);
		return updateTModelAutomobila;
	}
	
	public void deleteTModelAutomobila(Long id) {
		tModelAutomobilaRepository.deleteById(id);
	}
}
