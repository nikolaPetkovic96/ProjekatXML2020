package com.team32.AgentApp.controller;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.service.AutomobilService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.KlasaAutomobilaService;
import com.team32.AgentApp.service.MarkaAutomobilaService;
import com.team32.AgentApp.service.ModelAutomobilaService;
import com.team32.AgentApp.service.TipGorivaService;
import com.team32.AgentApp.service.TipMenjacaService;

@RestController
public class AutomobilController {
	
	@Autowired
	private AutomobilService automobilService;	
	
	@Autowired
	private CommonDataService comDataService;
	
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
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/automobil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilDTO>> getAllAutomobil(){
		List<Automobil> allAutomobil = automobilService.getAllAutomobil();
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAutomobil) {
			
			String marka = markaService.findOne(a.getMarkaAutomobilaId()).getNazivMarke(); 
			String model = modelService.findOne(a.getModelAutomobilaId()).getNazivModela();
			String klasa = klasaService.findOne(a.getKlasaAutomobilaId()).getNazivKlase();
			String menjac = menjacService.findOne(a.getTipMenjacaId()).getNazivMenjaca();
			String gorivo = gorivoService.findOne(a.getTipGorivaId()).getNazivTipa();
			
			automobilDTO.add(new AutomobilDTO(a, marka, model, klasa, menjac, gorivo));
			
		}
		return new ResponseEntity<>(automobilDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/automobil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> getAutomobil(@PathVariable("id") Long id){
		Automobil automobil = automobilService.findOne(id);
		
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String marka = markaService.findOne(automobil.getMarkaAutomobilaId()).getNazivMarke(); 
		String model = modelService.findOne(automobil.getModelAutomobilaId()).getNazivModela();
		String klasa = klasaService.findOne(automobil.getKlasaAutomobilaId()).getNazivKlase();
		String menjac = menjacService.findOne(automobil.getTipMenjacaId()).getNazivMenjaca();
		String gorivo = gorivoService.findOne(automobil.getTipGorivaId()).getNazivTipa();
		
		return new ResponseEntity<>(new AutomobilDTO(automobil, marka, model, klasa, menjac, gorivo), HttpStatus.OK);
	}
	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AutomobilDTO> addAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
//		Automobil savedAutomobil = new Automobil();
//		
//		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
//		CommonData commonData = new CommonData();
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
//		commonData.setDatumKreiranja(now);
//		commonData = comDataService.addCommonData(commonData);
//	
//		savedAutomobil.setId(automobilDTO.getId());
//		savedAutomobil.setMarkaAutomobilaId(automobilDTO.getMarkaAutomobilaId());
//		savedAutomobil.setModelAutomobilaId(automobilDTO.getModelAutomobilaId());
//		savedAutomobil.setKlasaAutomobilaId(automobilDTO.getKlasaAutomobilaId());
//		savedAutomobil.setTipGorivaId(automobilDTO.getTipGorivaId());
//		savedAutomobil.setTipMenjacaId(automobilDTO.getTipMenjacaId());
//		savedAutomobil.setUkupnaOcena(automobilDTO.getTipMenjacaId());
//		savedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
//		savedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
//		savedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
//		
//		savedAutomobil.setCommonDataId(commonData.getId());
//		
//		savedAutomobil = automobilService.addAutomobil(savedAutomobil);
//		return new ResponseEntity<>(new AutomobilDTO(savedAutomobil), HttpStatus.CREATED);
//	}
//	
//	@RequestMapping(method=RequestMethod.PUT, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AutomobilDTO> updateAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
//		
//		Automobil updatedAutomobil = automobilService.findOne(automobilDTO.getId());
//		if(updatedAutomobil == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		Long comDatId = updatedAutomobil.getCommonDataId();
//		
//		CommonData commonData = comDataService.findOne(comDatId);
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setDatumIzmene(now);
//		commonData = comDataService.updateCommonData(comDatId, commonData);
//		
//		updatedAutomobil.setId(automobilDTO.getId());
//		updatedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
//		updatedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
//		updatedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
//		
//		updatedAutomobil.setMarkaAutomobilaId(automobilDTO.getMarkaAutomobilaId());
//		updatedAutomobil.setModelAutomobilaId(automobilDTO.getModelAutomobilaId());
//		updatedAutomobil.setKlasaAutomobilaId(automobilDTO.getKlasaAutomobilaId());
//		updatedAutomobil.setTipGorivaId(automobilDTO.getTipGorivaId());
//		updatedAutomobil.setTipMenjacaId(automobilDTO.getTipMenjacaId());
//		updatedAutomobil.setUkupnaOcena(automobilDTO.getTipMenjacaId());
//		
//		updatedAutomobil.setCommonDataId(comDatId);
//	
//		updatedAutomobil = automobilService.updateAutomobil(updatedAutomobil.getId(), updatedAutomobil);
//		return new ResponseEntity<>(new AutomobilDTO(updatedAutomobil),HttpStatus.OK);
//	}
//	
	@RequestMapping(value="/automobil/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAutomobil(@PathVariable Long id){
		Automobil automobil = automobilService.findOne(id);
		if(automobil != null) {
			automobilService.deleteAutomobil(id);
			comDataService.deleteCommonData(automobil.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}