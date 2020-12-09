package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.Cenovnik;
import com.team32.AgentApp.repository.CenovnikRepository;

@Service
public class CenovnikService {

	@Autowired
	private  CenovnikRepository  cenovnikRepository; 
	
	public List< Cenovnik> getAllCenovnik(){
		List< Cenovnik>  cenovnici = new ArrayList<>();
		cenovnikRepository.findAll().forEach(cenovnici::add);
			return cenovnici;
		}
	
	public Cenovnik findOne(Long id) {
		return cenovnikRepository.findById(id).orElseGet(null);
	}
	
	public Cenovnik addCenovnik(Cenovnik cenovnik) throws Exception{
		if(cenovnik.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Cenovnik savedCenovnik = cenovnikRepository.save(cenovnik);
		return savedCenovnik;
	}
	
	public Cenovnik updateCenovnik(Long id, Cenovnik cenovnik) throws Exception{
		Optional<Cenovnik> cenovnikToUpdate = cenovnikRepository.findById(id);
		if(cenovnikToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Cenovnik updateCenovnik = cenovnikRepository.save(cenovnik);
		return updateCenovnik;
	}
	
	public void deleteCenovnik(Long id) {
		cenovnikRepository.deleteById(id);
	}
}
