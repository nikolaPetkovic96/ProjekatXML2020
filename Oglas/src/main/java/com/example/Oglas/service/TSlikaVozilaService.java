package com.example.Oglas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Oglas.model.auto.TSlikaVozila;
import com.example.Oglas.repository.auto.TSlikaVozilaRepository;


@Service
public class TSlikaVozilaService {

	@Autowired
	private TSlikaVozilaRepository slikaVozilaRepository;
	
	public List<TSlikaVozila> getAllSlikaVozila(){
		List<TSlikaVozila> slikeVozila = new ArrayList<>();
		slikaVozilaRepository.findAll().forEach(slikeVozila::add);
		return slikeVozila;
	}
	public TSlikaVozila findOne(Long id) {
		return slikaVozilaRepository.findById(id).orElse(null);
	}
	public TSlikaVozila addSlikaVozila(TSlikaVozila slikaVozila) throws Exception{
		if(slikaVozila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TSlikaVozila savedSlikaVozila = slikaVozilaRepository.save(slikaVozila);
		return savedSlikaVozila;
	}
	public TSlikaVozila updateSlikaVozila(Long id, TSlikaVozila slikaVozila) throws Exception{
		Optional<TSlikaVozila> slikaVozilaToUpdate = slikaVozilaRepository.findById(id);
		if(slikaVozilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TSlikaVozila updateSlikaVozila = slikaVozilaRepository.save(slikaVozila);
		return updateSlikaVozila;
	}
	public void deleteSlikaVozila(Long id) {
		slikaVozilaRepository.deleteById(id);
	}
	public TSlikaVozila getSlikaVozilaByAutomobilId(Long automobilId) throws Exception {
		if(slikaVozilaRepository.findByAutomobilId(automobilId) == null) {
			throw new Exception("Slika vozila je null!");
		}
		return slikaVozilaRepository.findByAutomobilId(automobilId);
	}
}
