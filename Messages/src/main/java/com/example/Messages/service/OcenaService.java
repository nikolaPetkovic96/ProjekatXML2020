package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.repository.OcenaRepository;

@Service
public class OcenaService {

	@Autowired
	private OcenaRepository ocenaRepository;
	
	public List<Ocena> getAllOcena(){
		List<Ocena> ocene = new ArrayList<>();
		ocenaRepository.findAll().forEach(ocene::add);
		return ocene;
	}
	
	public Ocena findOne(Long id) {
		return ocenaRepository.findById(id).orElse(null);
	}
	
	public Ocena addOcena(Ocena ocena) throws Exception{
		if(ocena.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Ocena savedOcena = ocenaRepository.save(ocena);
		return savedOcena;
	}
	public Ocena updateOcena(Long id, Ocena ocena) throws Exception{
		Optional<Ocena> ocenaToUpdate = ocenaRepository.findById(id);
		if(ocenaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Ocena updateOcena = ocenaRepository.save(ocena);
		return updateOcena;
	}
	
	public void deleteOcena(Long id) {
		ocenaRepository.deleteById(id);
	}
	
}
