package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.DTO.NarudzbenicaDTO;
import com.team32.AgentApp.DTO.OglasDTO;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.repository.NarudzbenicaRepository;

@Service
public class NarudzbenicaService {

	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	@Autowired
	private OglasService oglasService;
	
	public List<Narudzbenica> getAllNarudzbenica(){
		List<Narudzbenica> narudzbenice = new ArrayList<>();
		narudzbenicaRepository.findAll().forEach(narudzbenice::add);
		return narudzbenice;
	}
	
	public Narudzbenica findOne(Long id) {
		return narudzbenicaRepository.findById(id).orElse(null);
	}
	
	
	public Narudzbenica addNarudzbenica(Narudzbenica klasaAutomobila) throws Exception{
		if(klasaAutomobila.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Narudzbenica savedNarudzbenica = narudzbenicaRepository.save(klasaAutomobila);
		return savedNarudzbenica;
	}
	
	
	public Narudzbenica updateNarudzbenica(Long id, Narudzbenica narudzbenica) throws Exception{
		Optional<Narudzbenica> narudzbenicaToUpdate = narudzbenicaRepository.findById(id);
		if(narudzbenicaToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Narudzbenica updateNarudzbenica = narudzbenicaRepository.save(narudzbenica);
		return updateNarudzbenica;
	}
	
	public void deleteNarudzbenica(Long id) {
		narudzbenicaRepository.deleteById(id);
	}

	public List<Narudzbenica> getAllNarudzbeniceByOglasId(Long oglasId) {
		
		return narudzbenicaRepository.findAllByOglasId(oglasId);
	}

	public List<Narudzbenica> getllNarudzbeniceByAgentId(Long agentId) {
		
		return narudzbenicaRepository.findAllByAgentId(agentId);
	}
	
	//POMOCNE METODE
	public List<Narudzbenica> getAllNarudzbeniceByRezervId(Long rezervId) {
		return narudzbenicaRepository.findAllByRezervacijaId(rezervId);
	}
	
	//Pomocne metode koja vrati kompletan DTO za naruzbenicu
	//Napravljena kako bi se iz razlicitih kontrolera moglo doci do NaruzbenicaDTO
	public NarudzbenicaDTO getNarudzbFullDetails(Narudzbenica nar) {
		Oglas oglas = oglasService.findOne(nar.getOglasId());
		if(oglas == null) {
			return null;
		}
		OglasDTO oglasDTO = oglasService.getOglasFullDetails(oglas);
		
		NarudzbenicaDTO narudzbDTO = new NarudzbenicaDTO(nar, oglasDTO);
		return narudzbDTO;
	}
	
}
