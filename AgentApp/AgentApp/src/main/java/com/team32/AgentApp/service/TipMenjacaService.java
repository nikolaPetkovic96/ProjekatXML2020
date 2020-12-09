package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.TipMenjaca;
import com.team32.AgentApp.repository.TipMenjacaRepository;

@Service
public class TipMenjacaService {

	@Autowired
	private TipMenjacaRepository tipMenjacaRepository;
	
	public List<TipMenjaca> getAllTipMenjaca(){
		List<TipMenjaca> tipoviMenjaca = new ArrayList<>();
		tipMenjacaRepository.findAll().forEach(tipoviMenjaca::add);
		return tipoviMenjaca;
	}
	public TipMenjaca findOne(Long id) {
		return tipMenjacaRepository.findById(id).orElse(null);
	}
	public TipMenjaca addTipMenjaca(TipMenjaca tipMenjaca) throws Exception{
		if(tipMenjaca.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TipMenjaca savedTipMenjaca = tipMenjacaRepository.save(tipMenjaca);
		return savedTipMenjaca;
	}
	public TipMenjaca updateTipMenjaca(Long id, TipMenjaca tipMenjaca) throws Exception{
		Optional<TipMenjaca> tipMenjacaToUpdate = tipMenjacaRepository.findById(id);
		if(tipMenjacaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TipMenjaca updateTipMenjaca = tipMenjacaRepository.save(tipMenjaca);
		return updateTipMenjaca;
	}
	public void deleteTipMenjaca(Long id) {
		tipMenjacaRepository.deleteById(id);
	}
	
}
