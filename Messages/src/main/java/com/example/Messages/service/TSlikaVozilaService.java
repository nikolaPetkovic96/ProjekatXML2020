package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
import com.example.Messages.repository.TSlikaVozilaRepository;

@Service
public class TSlikaVozilaService {

	@Autowired
	private TSlikaVozilaRepository tSlikaVozilaRepository;
	
	public List<TSlikaVozila> getAllTSlikaVozila(){
		List<TSlikaVozila> tSlikeVozila = new ArrayList<>();
		tSlikaVozilaRepository.findAll().forEach(tSlikeVozila::add);
		return tSlikeVozila;
	}
	public TSlikaVozila findOne(Long id) {
		return tSlikaVozilaRepository.findById(id).orElse(null);
	}
	public TSlikaVozila addTSlikaVozila(TSlikaVozila tSlikaVozila) throws Exception{
		if(tSlikaVozila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TSlikaVozila savedTSlikaVozila = tSlikaVozilaRepository.save(tSlikaVozila);
		return savedTSlikaVozila;
	}
	public TSlikaVozila updateTSlikaVozila(Long id, TSlikaVozila tSlikaVozila) throws Exception{
		Optional<TSlikaVozila> tSlikaVozilaToUpdate = tSlikaVozilaRepository.findById(id);
		if(tSlikaVozilaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		TSlikaVozila updateTSlikaVozila = tSlikaVozilaRepository.save(tSlikaVozila);
		return updateTSlikaVozila;
	}
	public void deleteTSlikaVozila(Long id) {
		tSlikaVozilaRepository.deleteById(id);
	}
}
