package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.repository.TTipGorivaRepository;

@Service
public class TTipGorivaService {

	@Autowired
	private TTipGorivaRepository tTipGorivaRepository;
	
	public List<TTipGoriva> getAllTTipGoriva(){
		List<TTipGoriva> tTipoviGoriva = new ArrayList<>();
		tTipGorivaRepository.findAll().forEach(tTipoviGoriva::add);
		return tTipoviGoriva;
	}
	public TTipGoriva findOne(Long id) {
		return tTipGorivaRepository.findById(id).orElse(null);
	}
	public TTipGoriva addTTipGoriva(TTipGoriva tTipGoriva) throws Exception{
		if(tTipGoriva.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TTipGoriva savedTTipGoriva = tTipGorivaRepository.save(tTipGoriva);
		return savedTTipGoriva;
	}
	public TTipGoriva updateTTipGoriva(Long id, TTipGoriva tTipGoriva) throws Exception{
		Optional<TTipGoriva> tTipGorivaToUpdate = tTipGorivaRepository.findById(id);
		if(tTipGorivaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TTipGoriva updateTTipGoriva = tTipGorivaRepository.save(tTipGoriva);
		return updateTTipGoriva;
	}
	public void deleteTTipGoriva(Long id) {
		tTipGorivaRepository.deleteById(id);
	}
	
	
}
