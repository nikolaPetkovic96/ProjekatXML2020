//package com.example.Messages.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
//import com.example.Messages.repository.OglasRepository;
//
//@Service
//public class OglasService {
//
//	@Autowired
//	private OglasRepository oglasRepository;
//	
//	public List<Oglas> getAllOglas(){
//		List<Oglas> oglasi = new ArrayList<>();
//		oglasRepository.findAll().forEach(oglasi::add);
//		return oglasi;
//	}
//	
//	public Oglas findOne(Long id) {
//		return oglasRepository.findById(id).orElse(null);
//	}
//	
//	public Oglas addOglas(Oglas oglas) throws Exception{
//		if(oglas.getId() != null) {
//			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
//		}
//		Oglas savedOglas = oglasRepository.save(oglas);
//		return savedOglas;
//	}
//	public Oglas updateOglas(Long id, Oglas oglas) throws Exception{
//		Optional<Oglas> oglasToUpdate = oglasRepository.findById(id);
//		if(oglasToUpdate == null) {
//			throw new Exception("Trazeni entitet nije pronadjen.");
//		}
//		Oglas updateOglas = oglasRepository.save(oglas);
//		return updateOglas;
//	}
//	public void deleteOglas(Long id) {
//		oglasRepository.deleteById(id);
//	}
//}
