package com.team32.AgentApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.service.AutomobilService;


@RestController
public class AutomobilController {
	
	@Autowired
	private AutomobilService automobilService;	
	
	@RequestMapping(method=RequestMethod.GET, value="/automobil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilDTO>> getAllAutomobil(){
		List<Automobil> allAutomobil = automobilService.getAllAutomobil();
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAutomobil) {
			automobilDTO.add(new AutomobilDTO(a));
			
		}
		return new ResponseEntity<>(automobilDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/automobil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> getAutomobil(@PathVariable("id") Long id){
		Automobil automobil = automobilService.findOne(id);
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new AutomobilDTO(automobil), HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> addAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
		Automobil savedAutomobil = new Automobil();
	
		savedAutomobil.setId(automobilDTO.getId());
		savedAutomobil.setMarkaAutomobilaId(automobilDTO.getMarkaAutomobilaId());
		savedAutomobil.setModelAutomobilaId(automobilDTO.getModelAutomobilaId());
		savedAutomobil.setKlasaAutomobilaId(automobilDTO.getKlasaAutomobilaId());
		savedAutomobil.setTipGorivaId(automobilDTO.getTipGorivaId());
		savedAutomobil.setTipMenjacaId(automobilDTO.getTipMenjacaId());
		savedAutomobil.setUkupnaOcena(automobilDTO.getTipMenjacaId());
		savedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
		savedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
		savedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
		
		savedAutomobil.setCommonDataId(automobilDTO.getCommonDataId()); //kreirati novi objekat klase commonId;
		
		savedAutomobil = automobilService.addAutomobil(savedAutomobil);
		return new ResponseEntity<>(new AutomobilDTO(savedAutomobil), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> updateAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
		
		Automobil updatedAutomobil = automobilService.findOne(automobilDTO.getId());
		if(updatedAutomobil == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedAutomobil.setId(automobilDTO.getId());
		updatedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
		updatedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
		updatedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
		
		
		updatedAutomobil.setMarkaAutomobilaId(automobilDTO.getMarkaAutomobilaId());
		updatedAutomobil.setModelAutomobilaId(automobilDTO.getModelAutomobilaId());
		updatedAutomobil.setKlasaAutomobilaId(automobilDTO.getKlasaAutomobilaId());
		updatedAutomobil.setTipGorivaId(automobilDTO.getTipGorivaId());
		updatedAutomobil.setTipMenjacaId(automobilDTO.getTipMenjacaId());
		updatedAutomobil.setUkupnaOcena(automobilDTO.getTipMenjacaId());
		
		updatedAutomobil.setCommonDataId(automobilDTO.getCommonDataId()); //izmeniti datum izmene u objekatu klase commonId;
	
		updatedAutomobil = automobilService.updateAutomobil(updatedAutomobil.getId(), updatedAutomobil);
		return new ResponseEntity<>(new AutomobilDTO(updatedAutomobil),HttpStatus.OK);
	}
	
	@RequestMapping(value="/automobil/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAutomobil(@PathVariable Long id){
		Automobil automobil = automobilService.findOne(id);
		if(automobil != null) {
			automobilService.deleteAutomobil(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}