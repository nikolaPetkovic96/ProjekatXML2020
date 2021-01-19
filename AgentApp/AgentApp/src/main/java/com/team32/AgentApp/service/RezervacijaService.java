package com.team32.AgentApp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.repository.NarudzbenicaRepository;
import com.team32.AgentApp.repository.RezervacijaRepository;


@Service
public class RezervacijaService {
	@Autowired
	private  RezervacijaRepository  rezervacijaRepository;
	
	@Autowired
	private  NarudzbenicaService narudzbenicaService;
	
	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
		public List< Rezervacija> getAllRezervacija(){
			List< Rezervacija>  rezervacije = new ArrayList<>();
			rezervacijaRepository.findAll().forEach(rezervacije::add);
			return rezervacije;
		}
		/**
		 * 
		 * @param agentId id agenta koji je napravio oglas
		 * @return listu rezervacija napravljenih nad oglasima agenta ciji id prosledjujemo
		 */
		public List< Rezervacija> getAllRezervacijaByIdAgenta(Long agentId){
			List<Rezervacija>  rezervacije = new ArrayList<>();
			
			List<Rezervacija> sveRezervacije = rezervacijaRepository.findAll();
			//Da ne vadimo iz oglasa agentId gledamo u narudzbenici
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

		//POMOCNE METODE
		
		/***
		 * 
		 * @param Listu rezervacija (List<Rezervacija>)
		 * @return  Filtriranu listu rezervacija sa stausom PAID (List<Rezervacija>)
		 *   
		 */
		public List<Rezervacija> getAllPaidRezervacije(List<Rezervacija> allRezervacija) {
			List<Rezervacija> onlyPaidRezervacije = new ArrayList<>();
			
			for(Rezervacija r:allRezervacija) {
				if(r.getStatusRezervacije().equals("PAID")) {
					onlyPaidRezervacije.add(r);
				}
			}
			
			return onlyPaidRezervacije;
		}
		
		/***
		 * 
		 * @param Listu rezervacija (List<Rezervacija>)
		 * @return  Filtriranu listu rezervacija sa stausom PENDING (List<Rezervacija>)
		 *   
		 */
		public List<Rezervacija> getAllPendingRezervacije(List<Rezervacija> allRezervacija) {
			List<Rezervacija> onlyPendingRezervacije = new ArrayList<>();
			
			for(Rezervacija r:allRezervacija) {
				if(r.getStatusRezervacije().equals("PENDING")) {
					onlyPendingRezervacije.add(r);
				}
			}
			
			return onlyPendingRezervacije;
		}
			
		//TODO Dodato
		public void otkaziOstale(Rezervacija savedRezervcaija, Narudzbenica narudzbenica ) {
			//nadji sve narudzbenice koje nisu iz ove rezervacije, a odnose se na oglas za koji je vezana ova narudzbenica
			List<Narudzbenica> ostaleNarudzbeniceUBazi = narudzbenicaRepository.findAll().stream()
																			.filter(x->x.getRezervacijaId()!=narudzbenica.getRezervacijaId() && x.getOglasId()==narudzbenica.getOglasId()) 
																			.collect(Collectors.toList());
			for(Narudzbenica n : ostaleNarudzbeniceUBazi) {
				//nema preklapanja ako se jenda zavrsava pre nego sto druga pocne ili jedna pocinje nakon sto se druga zavrsi
				boolean nemaPreklapanja = n.getDoDatuma().isBefore(narudzbenica.getOdDatuma()) || n.getOdDatuma().isAfter(narudzbenica.getDoDatuma());
				if(!nemaPreklapanja) {
					//ovo je rezervacija iz baze koja se preklapa sa rezervacijom koju smo napravili
					Rezervacija r = rezervacijaRepository.findById(n.getRezervacijaId()).orElse(null);
					if(r.getStatusRezervacije().equals("PENDING")) {
						r.setStatusRezervacije("CANCELED");
					}
				
				}
			}
		}
}
