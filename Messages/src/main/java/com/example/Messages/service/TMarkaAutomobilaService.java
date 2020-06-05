package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.repository.TMarkaAutomobilaRepository;

@Service
public class TMarkaAutomobilaService {

	@Autowired
	private TMarkaAutomobilaRepository tMarkaAutomobilaRepository;
	
	public List<TMarkaAutomobila> getAllTMarkaAutomobila(){
		List<TMarkaAutomobila> tMarkeAutomobila = new ArrayList<>();
		tMarkaAutomobilaRepository.findAll().forEach(tMarkeAutomobila::add);
		return tMarkeAutomobila;
	}
	
	public TMarkaAutomobila findOne(Long id) {
		return tMarkaAutomobilaRepository.findById(id).orElse(null);
	}
	public TMarkaAutomobila addTMarkaAutomobila(TMarkaAutomobila tMarkaAutomobila) throws Exception{
		if(tMarkaAutomobila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TMarkaAutomobila savedTMarkaAutomobila = tMarkaAutomobilaRepository.save(tMarkaAutomobila);
		return savedTMarkaAutomobila;
	}
	
	public TMarkaAutomobila updateTMarkaAutomobila(Long id, TMarkaAutomobila tMarkaAutomobila) throws Exception{
		Optional<TMarkaAutomobila> tMarkaAutomobilaToUpdate = tMarkaAutomobilaRepository.findById(id);
		if(tMarkaAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TMarkaAutomobila updateTMarkaAutomobila = tMarkaAutomobilaRepository.save(tMarkaAutomobila);
		return updateTMarkaAutomobila;
	}
	public void deleteTMarkaAutomobila(Long id) {
		tMarkaAutomobilaRepository.deleteById(id);
	}
	
}
