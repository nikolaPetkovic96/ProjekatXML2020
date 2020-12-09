package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.TipGoriva;
import com.team32.AgentApp.repository.TipGorivaRepository;

@Service
public class TipGorivaService {

	@Autowired
	private TipGorivaRepository tipGorivaRepository;
	
	public List<TipGoriva> getAllTipGoriva(){
		List<TipGoriva> tipoviGoriva = new ArrayList<>();
		tipGorivaRepository.findAll().forEach(tipoviGoriva::add);
		return tipoviGoriva;
	}
	public TipGoriva findOne(Long id) {
		return tipGorivaRepository.findById(id).orElse(null);
	}
	public TipGoriva addTipGoriva(TipGoriva tipGoriva) throws Exception{
		if(tipGoriva.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TipGoriva savedTipGoriva = tipGorivaRepository.save(tipGoriva);
		return savedTipGoriva;
	}
	public TipGoriva updateTipGoriva(Long id, TipGoriva tipGoriva) throws Exception{
		Optional<TipGoriva> tipGorivaToUpdate = tipGorivaRepository.findById(id);
		if(tipGorivaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TipGoriva updateTipGoriva = tipGorivaRepository.save(tipGoriva);
		return updateTipGoriva;
	}
	public void deleteTTipGoriva(Long id) {
		tipGorivaRepository.deleteById(id);
	}
	
	
}
