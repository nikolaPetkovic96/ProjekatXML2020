package com.example.Messages.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
import com.example.Messages.repository.TTipMenjacaRepository;

@Service
public class TTipMenjacaService {

	@Autowired
	private TTipMenjacaRepository tTipMenjacaRepository;
	
	public List<TTipMenjaca> getAllTTipMenjaca(){
		List<TTipMenjaca> tTipoviMenjaca = new ArrayList<>();
		tTipMenjacaRepository.findAll().forEach(tTipoviMenjaca::add);
		return tTipoviMenjaca;
	}
	public TTipMenjaca findOne(Long id) {
		return tTipMenjacaRepository.findById(id).orElse(null);
	}
	public TTipMenjaca addTTipMenjaca(TTipMenjaca tTipMenjaca) throws Exception{
		if(tTipMenjaca.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TTipMenjaca savedTTipMenjaca = tTipMenjacaRepository.save(tTipMenjaca);
		return savedTTipMenjaca;
	}
	public TTipMenjaca updateTTipMenjaca(Long id, TTipMenjaca tTipMenjaca) throws Exception{
		Optional<TTipMenjaca> tTipMenjacaToUpdate = tTipMenjacaRepository.findById(id);
		if(tTipMenjacaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TTipMenjaca updateTTipMenjaca = tTipMenjacaRepository.save(tTipMenjaca);
		return updateTTipMenjaca;
	}
	public void deleteTTipMenjaca(Long id) {
		tTipMenjacaRepository.deleteById(id);
	}
	
}
