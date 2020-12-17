package com.team32.AgentApp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.repository.RezervacijaRepository;


@Service
public class RezervacijaService {
	@Autowired
	private  RezervacijaRepository  rezervacijaRepository;
	
	@Autowired
	private  NarudzbenicaService narudzbenicaService;
	
		public List< Rezervacija> getAllRezervacija(){
			List< Rezervacija>  rezervacije = new ArrayList<>();
			rezervacijaRepository.findAll().forEach(rezervacije::add);
			return rezervacije;
		}
		
		public List< Rezervacija> getAllRezervacijaByIdAgenta(Long agentId){
			List<Rezervacija>  rezervacije = new ArrayList<>();
			
			List<Rezervacija> sveRezervacije = rezervacijaRepository.findAll();
			List<Narudzbenica> agentNarudzb = narudzbenicaService.getllNarudzbeniceByAgentId(agentId);
			
			for( Narudzbenica n : agentNarudzb){
				for(Rezervacija r : sveRezervacije){
					if(r.getId().toString().equals(n.getRezervacijaId().toString())) {
						if(!rezervacije.contains(r)) {
							rezervacije.add(r);
						}
					}
				}
			}
			return rezervacije;
		}

		public Rezervacija findOne(Long id) {
			return rezervacijaRepository.findById(id).orElseGet(null);
		}
		
		public Rezervacija addRezervacija(Rezervacija rezervacija)throws Exception{
			  if (rezervacija.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Rezervacija savedRezervacija = rezervacijaRepository.save(rezervacija);
		        return savedRezervacija;
		}
		
		public Rezervacija updateRezervacija(Long id, Rezervacija rezervacija) throws Exception {
			Optional<Rezervacija> rezervacijaToUpdate = rezervacijaRepository.findById(id);
			if (rezervacijaToUpdate == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Rezervacija updateRezervacija = rezervacijaRepository.save(rezervacija);
			return updateRezervacija;
		}
		
		public void deleteRezervacija(Long id) {
			rezervacijaRepository.deleteById(id);
		}
}
