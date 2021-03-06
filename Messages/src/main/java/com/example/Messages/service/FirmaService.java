package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.user.Firma;
import com.example.Messages.repository.FirmaRepository;

@Service
public class FirmaService {
	
	@Autowired
	private  FirmaRepository  firmaRepository;
	
	public List< Firma> getAllFirma(){
		List< Firma>  firma = new ArrayList<>();
			firmaRepository.findAll().forEach(firma::add);
			return firma;
		}

		public Firma findOne(Long id) {
			return firmaRepository.findById(id).orElseGet(null);
		}
		
		public Firma addFirma(Firma firma)throws Exception{
			  if (firma.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Firma savedFirma = firmaRepository.save(firma);
		        return savedFirma;
			
		}
		
		public Firma updateFirma(Long id, Firma firma) throws Exception {
			Optional<Firma> firmaToUpadet = firmaRepository.findById(id);
			if (firmaToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Firma updateFirma = firmaRepository.save(firma);
			return updateFirma;
		}
		
		public void deleteFirma(Long id) {
			firmaRepository.deleteById(id);
		}

}
