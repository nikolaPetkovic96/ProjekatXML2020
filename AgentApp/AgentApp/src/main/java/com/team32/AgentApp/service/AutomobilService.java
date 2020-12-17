package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.repository.AutomobilRepository;

@Service
public class AutomobilService {

	@Autowired
	private AutomobilRepository automobilRepository;
	
	@Autowired
	private ModelAutomobilaService modelService;
	
	@Autowired
	private KlasaAutomobilaService klasaService;
	
	@Autowired
	private MarkaAutomobilaService markaService;
	
	@Autowired
	private TipGorivaService gorivoService;
	
	@Autowired
	private TipMenjacaService menjacService;
	
	@Autowired
	private CommonDataService comDataService;
	
	public List<Automobil> getAllAutomobil(){
		List<Automobil> listaAutomobila = new ArrayList<>();
		automobilRepository.findAll().forEach(listaAutomobila::add);
		return listaAutomobila;
	}
	
	public Automobil findOne(Long id) {
		return automobilRepository.findById(id).orElseGet(null);
	}
	
	//Pomocna metoda koja sluzi da vrati Automobil ciji su atiributi objekti.
	public AutomobilDTO findOneWithDetails(Long id) {
		Automobil auto = automobilRepository.findById(id).orElseGet(null);
		String marka = markaService.findOne(auto.getMarkaAutomobilaId()).getNazivMarke(); 
		String model = modelService.findOne(auto.getModelAutomobilaId()).getNazivModela();
		String klasa = klasaService.findOne(auto.getKlasaAutomobilaId()).getNazivKlase();
		String menjac = menjacService.findOne(auto.getTipMenjacaId()).getNazivMenjaca();
		String gorivo = gorivoService.findOne(auto.getTipGorivaId()).getNazivTipa();
		
		AutomobilDTO autoDTO = new AutomobilDTO(auto, marka, model, klasa, menjac, gorivo);
		return autoDTO;
	}
	
	public Automobil addAutomobil(Automobil automobil) throws Exception {
		if(automobil.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Automobil savedAutomobil = automobilRepository.save(automobil);
		return savedAutomobil;	
	}
	
	public Automobil updateAutomobil(Long id, Automobil automobil) throws Exception{
		Optional<Automobil> automobilToUpdate = automobilRepository.findById(id);
		if(automobilToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Automobil updateAutomobil = automobilRepository.save(automobil);
		return updateAutomobil;
	}
	
	public void deleteAutomobil(Long id) {
		automobilRepository.deleteById(id);
	}

	public List<Automobil> getAllAutomobilByAgent(Long agentId) {
		List<Automobil> automobili = new ArrayList<>();
		
		//Dobavim sve oglase iz baze
		List<Automobil> sviAutomobili = automobilRepository.findAll();
		
		//Prolazim kroz autlomobile i proveravam da li je agentId = userId u commonData automobila
		for(Automobil a : sviAutomobili){
			if(comDataService.findOne(a.getCommonDataId()).getUserid() == agentId) {
				automobili.add(a);
			}
		}
		
		return automobili;	
	}
	
}
