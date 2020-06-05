package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.repository.KomentarRepository;

@Service
public class KomentarService {

	@Autowired
	private KomentarRepository komentarRepository;
	
	public List<Komentar> getAllKomentar(){
		List<Komentar> komentari = new ArrayList<>();
		komentarRepository.findAll().forEach(komentari::add);
		return komentari;
	}
	
	public Komentar findOne(Long id) {
		return komentarRepository.findById(id).orElse(null);
	}
	
	public Komentar addKomentar(Komentar komentar) throws Exception{
		if(komentar.getId() != 0) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Komentar savedKomentar = komentarRepository.save(komentar);
		return savedKomentar;
	}
	
	public Komentar updateKomentar(Long id, Komentar komentar) throws Exception{
		Optional<Komentar> komentarToUpdate = komentarRepository.findById(id);
		if(komentarToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Komentar updateKomentar = komentarRepository.save(komentar);
		return updateKomentar;
	}
	
	public void deleteKomentar(Long id) {
		komentarRepository.deleteById(id);
	}
}
