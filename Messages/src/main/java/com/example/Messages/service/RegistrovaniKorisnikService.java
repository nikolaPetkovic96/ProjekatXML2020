package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;
import com.example.Messages.repository.RegistrovaniKorisnikRepository;

@Service
public class RegistrovaniKorisnikService {
	
	@Autowired
	private  RegistrovaniKorisnikRepository  registrovanikorisnikRepository;
	
	public List< RegistrovaniKorisnik> getAllRegistrovaniKorisnik(){
		List< RegistrovaniKorisnik>  registrovanikorisnikKlinCentra = new ArrayList<>();
			registrovanikorisnikRepository.findAll().forEach(registrovanikorisnikKlinCentra::add);
			return registrovanikorisnikKlinCentra;
		}

		public RegistrovaniKorisnik findOne(Long id) {
			return registrovanikorisnikRepository.findById(id).orElseGet(null);
		}
		
		public RegistrovaniKorisnik addRegistrovaniKorisnik(RegistrovaniKorisnik registrovanikorisnik)throws Exception{
			  if (registrovanikorisnik.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  RegistrovaniKorisnik savedRegistrovaniKorisnikKlinCentra = registrovanikorisnikRepository.save(registrovanikorisnik);
		        return savedRegistrovaniKorisnikKlinCentra;
			
		}
		
		public RegistrovaniKorisnik updateRegistrovaniKorisnik(Long id, RegistrovaniKorisnik registrovanikorisnik) throws Exception {
			Optional<RegistrovaniKorisnik> registrovanikorisnikKlinCentraToUpadet = registrovanikorisnikRepository.findById(id);
			if (registrovanikorisnikKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
		 RegistrovaniKorisnik updateRegistrovaniKorisnikKilCentra = registrovanikorisnikRepository.save(registrovanikorisnik);
			return updateRegistrovaniKorisnikKilCentra;
		}
		
		public void deleteRegistrovaniKorisnik(Long id) {
			registrovanikorisnikRepository.deleteById(id);
		}

}
