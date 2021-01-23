package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.DTO.AutomobilStatisticDTO;
import com.team32.AgentApp.DTO.SlikaVozilaDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.tentitet.SlikaVozila;
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
	
	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private SlikaVozilaService slikaVozService;
	
	public List<Automobil> getAllAutomobil(){
		List<Automobil> listaAutomobila = new ArrayList<>();
		automobilRepository.findAll().forEach(listaAutomobila::add);
		return listaAutomobila;
	}
	
	public Automobil findOne(Long id) {
		return automobilRepository.findById(id).orElseGet(null);
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
	
	//DODATNE METODE:
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
	
	public SlikaVozilaDTO getSlikeVozila(Long automobilId) throws Exception {
		SlikaVozila s = slikaVozService.getSlikaVozilaByAutomobilId(automobilId);
		return new SlikaVozilaDTO(s);
	}
	
	
	/***
	 * 
	 * @param id automobila tipa Long 
	 * @return AutomobilDTO popunjen osnovnim podacima kao i nazivom marke, modela, klase, menjaca i goriva.
	 */
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
	
	/***
	 * 
	 * @param automobilId tipa Long
	 * @return AutomobilStatisticDTO koji je vec popunje sa podacima iz AutomobilDTO i brojem komentara;
	 */
	public AutomobilStatisticDTO findOneWithStat(Long autoId) {
		AutomobilDTO automobilDTO = findOneWithDetails(autoId);
		int brojKomentara  = getNumberOfCommentsByAutoId(autoId);
		
		return new AutomobilStatisticDTO(automobilDTO, brojKomentara);
	}
	

	/*
	 * 
	 * @param String category
	 * @return Listu od 3 automobila sa najvecim brojem komentara;
	 * Vec su u formatu AutomoblStatisticDTO 
	 */
	public List<AutomobilStatisticDTO> getBestAutomobilByComment(String category, List<Automobil> allAgentAut) {
		List<AutomobilStatisticDTO> listaAutStatDTO = new ArrayList<>();
		//Prebacujemo listu automobila u listu automobilStatisticDTO
		//Kako bi smo mogli da ih sortiramo po vrednosti atributa brojKomentara;
		for(Automobil a : allAgentAut) {
			listaAutStatDTO.add(findOneWithStat(a.getId()));
		}
		Collections.sort(listaAutStatDTO, new Comparator<AutomobilStatisticDTO>() {
			@Override
			public int compare(AutomobilStatisticDTO a1, AutomobilStatisticDTO  a2) {
				return Float.compare(a2.getBrojKomentara(), a1.getBrojKomentara());
			}
		});
		return listaAutStatDTO;
	}
	
	
	/*
	 * 
	 * @param String category
	 * @return Listu od 3 automobila sa najvecim brojem predjenih kilometara; 
	 */
	public List<Automobil> getBestAutomobilByKm(String category, List<Automobil> allAgentAut) {
		//Treba da ih sortiramo po broju km
		Collections.sort(allAgentAut, new Comparator<Automobil>() {
			@Override
			public int compare(Automobil a1, Automobil  a2) {
				return Float.compare(a2.getPredjenaKilometraza(), a1.getPredjenaKilometraza());
			}
		});
		return allAgentAut;
	}
	
	
	/*
	 * 
	 * @param String category
	 * @return Listu od 3 automobila sa najvecom ocenom; 
	 */
	public List<Automobil> getBestAutomobilByRating(String category, List<Automobil> allAgentAut) {
		//Treba da ih sortiramo po oceni
		Collections.sort(allAgentAut, new Comparator<Automobil>() {
			@Override
			public int compare(Automobil a1, Automobil  a2) {
				return Float.compare(a2.getUkupnaOcena(), a1.getUkupnaOcena());
			}
		});
		return allAgentAut;
	}
	

	/***
	 * 
	 * @param automobilId tipa Long
	 * @return int broj komentara za taj automobil 
	 */
	public int getNumberOfCommentsByAutoId(Long automobilId) {
		return komentarService.getAllKomentarByAutomobilId(automobilId).toArray().length;
	}
	

}
