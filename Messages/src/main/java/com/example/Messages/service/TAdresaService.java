package com.example.Messages.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;
import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa.Kordinate;
import com.example.Messages.repository.KordinateRepository;
import com.example.Messages.repository.TAdresaRepository;

@Service
public class TAdresaService {
	
	@Autowired
	private TAdresaRepository tAdresaRepository;
	
	public List<TAdresa> getAllTAdresa(){
		List<TAdresa> tAdrese = new ArrayList<>();
		tAdresaRepository.findAll().forEach(tAdrese::add);
		return tAdrese;
	}
	
	public TAdresa findOne(Long id) {
		return tAdresaRepository.findById(id).orElse(null);
	}
	public TAdresa addTAdresa(TAdresa tAdresa) throws Exception{
		if(tAdresa.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		TAdresa savedTAdresa = tAdresaRepository.save(tAdresa);
		return savedTAdresa;
	}
	public TAdresa updateTAdresa(Long id, TAdresa tAdresa) throws Exception{
		Optional<TAdresa> tAdresaToUpdate = tAdresaRepository.findById(id);
		if(tAdresaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen."); 
		}
		TAdresa updateTAdresa = tAdresaRepository.save(tAdresa);
		return updateTAdresa;
	}
	public void deleteTAdresa(Long id) {
		tAdresaRepository.deleteById(id);
	}
	
 @Service
 public class KordinateService {
	 @Autowired
	 private KordinateRepository kordinateRepo;
	 
	 public List<Kordinate> getAllKordinate(){
		 List<Kordinate> kordinate = new ArrayList<>();
		 kordinateRepo.findAll().forEach(kordinate::add);
			return kordinate;
	 }
	 public Kordinate findOne(Long id) {
			return kordinateRepo.findById(id).orElse(null);
	 }
	 public Kordinate addKordinate(Kordinate kord) throws Exception{
			if(kord.getId() != null) {
				throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
			}
			Kordinate savedKord = kordinateRepo.save(kord);
			return savedKord;
	 }
	 public Kordinate updateKordinate(Long id, Kordinate kord) throws Exception{
			Optional<Kordinate> KordinateToUpdate = kordinateRepo.findById(id);
			if(KordinateToUpdate == null) {
				throw new Exception("Trazeni entitet nije pronadjen."); 
			}
			Kordinate updateKordinate = kordinateRepo.save(kord);
			return updateKordinate;
	}
	public void deleteKordinate(Long id) {
		kordinateRepo.deleteById(id);
	}
 }
 
}
