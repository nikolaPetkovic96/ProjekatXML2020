package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.ModelAutomobila;
import com.team32.AgentApp.repository.ModelAutomobilaRepository;

@Service
public class ModelAutomobilaService {

	@Autowired
	private ModelAutomobilaRepository modelAutomobilaRepository;
	
	public List<ModelAutomobila> getAllModelAutomobila(){
		List<ModelAutomobila> modeliAutomobila = new ArrayList<>();
		modelAutomobilaRepository.findAll().forEach(modeliAutomobila::add);
		return modeliAutomobila;
	}
	
	public ModelAutomobila findOne(Long id) {
		return modelAutomobilaRepository.findById(id).orElse(null);
	}
	public ModelAutomobila addModelAutomobila(ModelAutomobila modelAutomobila) throws Exception{
		if(modelAutomobila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		ModelAutomobila savedTModelAutomobila = modelAutomobilaRepository.save(modelAutomobila);
		return savedTModelAutomobila;
	}
	
	public ModelAutomobila updateModelAutomobila(Long id, ModelAutomobila modelAutomobila) throws Exception{
		Optional<ModelAutomobila> modelAutomobilaToUpdate = modelAutomobilaRepository.findById(id);
		if(modelAutomobilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		ModelAutomobila updateTModelAutomobila = modelAutomobilaRepository.save(modelAutomobila);
		return updateTModelAutomobila;
	}
	
	public void deleteModelAutomobila(Long id) {
		modelAutomobilaRepository.deleteById(id);
	}
}
