package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.Poruka;
import com.team32.AgentApp.repository.PorukaRepository;


@Service
public class PorukaService {
	
	@Autowired
	private  PorukaRepository  porukaRepository;
	
	public List< Poruka> getAllPoruka(){
		List< Poruka>  porukaKlinCentra = new ArrayList<>();
			porukaRepository.findAll().forEach(porukaKlinCentra::add);
			return porukaKlinCentra;
		}

		public Poruka findOne(Long id) {
			return porukaRepository.findById(id).orElseGet(null);
		}
		
		public Poruka addPoruka(Poruka poruka)throws Exception{
			  if (poruka.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Poruka savedPorukaKlinCentra = porukaRepository.save(poruka);
		        return savedPorukaKlinCentra;
			
		}
		
		public Poruka updatePoruka(Long id, Poruka poruka) throws Exception {
			Optional<Poruka> porukaKlinCentraToUpadet = porukaRepository.findById(id);
			if (porukaKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Poruka updatePorukaKilCentra = porukaRepository.save(poruka);
			return updatePorukaKilCentra;
		}
		
		public void deletePoruka(Long id) {
			porukaRepository.deleteById(id);
		}

		
		//Dodatne custom metode
		public List<Poruka> findAllPorukeByRezervId(Long rezervId) {
			
			return porukaRepository.findAllByRezervacijaId(rezervId);
		}
}
