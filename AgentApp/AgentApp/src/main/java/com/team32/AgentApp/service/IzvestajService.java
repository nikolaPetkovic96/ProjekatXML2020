package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.Izvestaj;
import com.team32.AgentApp.repository.IzvestajRepository;

@Service
public class IzvestajService{
	
	@Autowired
	private IzvestajRepository izvestajRepository;
	
	
	
	public List<Izvestaj> getAllIzvestaj(){
		List<Izvestaj> izvestaji = new ArrayList<>();
		izvestajRepository.findAll().forEach(izvestaji::add);
		return izvestaji;
	}
	
	public Izvestaj findOne(Long id) {
		return izvestajRepository.findById(id).orElse(null);
	}
	public Izvestaj addIzvestaj(Izvestaj izvestaj) throws Exception{
		if(izvestaj.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		
		List<Izvestaj> izvestaji = getAllIzvestaj();
		//Provera da li je vec unet izvestaj za dati automobil u datoj rezervaciji
		for(Izvestaj i:izvestaji) {
			if(i.getAutomobilId() == izvestaj.getAutomobilId() && 
				i.getRezervacijaId() ==  izvestaj.getRezervacijaId()) {
				throw new Exception("Report already exist!");
			}
		}
		Izvestaj savedTKlasaAutomobila = izvestajRepository.save(izvestaj);
		return savedTKlasaAutomobila;
	}
	public Izvestaj updateIzvestaj(Long id, Izvestaj izvestaj) throws Exception{
		Optional<Izvestaj> izvestajToUpdate = izvestajRepository.findById(id);
		if(izvestajToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Izvestaj updateIzvestaj = izvestajRepository.save(izvestaj);
		return updateIzvestaj;
	}
	
	public void deleteIzvestaj(Long id) {
		izvestajRepository.deleteById(id);
	}

}
