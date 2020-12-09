package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.tentitet.SlikaVozila;
import com.team32.AgentApp.repository.SlikaVozilaRepository;

@Service
public class SlikaVozilaService {

	@Autowired
	private SlikaVozilaRepository slikaVozilaRepository;
	
	public List<SlikaVozila> getAllSlikaVozila(){
		List<SlikaVozila> slikeVozila = new ArrayList<>();
		slikaVozilaRepository.findAll().forEach(slikeVozila::add);
		return slikeVozila;
	}
	public SlikaVozila findOne(Long id) {
		return slikaVozilaRepository.findById(id).orElse(null);
	}
	public SlikaVozila addSlikaVozila(SlikaVozila slikaVozila) throws Exception{
		if(slikaVozila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		SlikaVozila savedSlikaVozila = slikaVozilaRepository.save(slikaVozila);
		return savedSlikaVozila;
	}
	public SlikaVozila updateSlikaVozila(Long id, SlikaVozila slikaVozila) throws Exception{
		Optional<SlikaVozila> slikaVozilaToUpdate = slikaVozilaRepository.findById(id);
		if(slikaVozilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		SlikaVozila updateSlikaVozila = slikaVozilaRepository.save(slikaVozila);
		return updateSlikaVozila;
	}
	public void deleteSlikaVozila(Long id) {
		slikaVozilaRepository.deleteById(id);
	}
}
