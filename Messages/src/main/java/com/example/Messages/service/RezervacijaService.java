package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
import com.example.Messages.SchemaToJava2.model.user.Administrator;
import com.example.Messages.repository.AdministratorRepository;
import com.example.Messages.repository.RezervacijaRepository;

@Service
public class RezervacijaService {
	@Autowired
	private  RezervacijaRepository  rezervacijaRepository;
	
	public List< Rezervacija> getAllRezervacija(){
		List< Rezervacija>  rezervacijaKlinCentra = new ArrayList<>();
			rezervacijaRepository.findAll().forEach(rezervacijaKlinCentra::add);
			return rezervacijaKlinCentra;
		}

		public Rezervacija findOne(Long id) {
			return rezervacijaRepository.findById(id).orElseGet(null);
		}
		
		public Rezervacija addRezervacija(Rezervacija rezervacija)throws Exception{
			  if (rezervacija.getRezervacija_id() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Rezervacija savedRezervacijaKlinCentra = rezervacijaRepository.save(rezervacija);
		        return savedRezervacijaKlinCentra;
			
		}
		
		public Rezervacija updateRezervacija(Long id, Rezervacija rezervacija) throws Exception {
			Optional<Rezervacija> rezervacijaKlinCentraToUpadet = rezervacijaRepository.findById(id);
			if (rezervacijaKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Rezervacija updateRezervacijaKilCentra = rezervacijaRepository.save(rezervacija);
			return updateRezervacijaKilCentra;
		}
		
		public void deleteRezervacija(Long id) {
			rezervacijaRepository.deleteById(id);
		}
}
