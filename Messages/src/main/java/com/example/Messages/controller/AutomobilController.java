package com.example.Messages.controller;

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

import com.example.Messages.DTO.AutomobilDTO;
import com.example.Messages.DTO.KomentarDTO;
import com.example.Messages.DTO.OcenaDTO;
import com.example.Messages.DTO.TSlikaVozilaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
import com.example.Messages.service.AutomobilService;
import com.example.Messages.service.KomentarService;
import com.example.Messages.service.OcenaService;
import com.example.Messages.service.TKlasaAutomobilaService;
import com.example.Messages.service.TMarkaAutomobilaService;
import com.example.Messages.service.TModelAutomobilaService;
import com.example.Messages.service.TSlikaVozilaService;
import com.example.Messages.service.TTipGorivaService;
import com.example.Messages.service.TTipMenjacaService;

@RestController
public class AutomobilController {
	
	@Autowired
	private AutomobilService automobilService;
	@Autowired
	private KomentarService komentarService;
	@Autowired
	private OcenaService ocenaService;
	@Autowired 
	private TSlikaVozilaService tSlikaVozilaService;

	@Autowired
	private TMarkaAutomobilaService tMarkaAutomobilaService;
	@Autowired 
	private TModelAutomobilaService tModelAutomobilaService;
	@Autowired
	private TKlasaAutomobilaService tKlasaAutomobilaService;
	@Autowired
	private TTipGorivaService tTipGorivaService;
	@Autowired
	private TTipMenjacaService tTipMenjacaService;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/Automobil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilDTO>> getAllAutomobil(){
		List<Automobil> allAutomobil = automobilService.getAllAutomobil();
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAutomobil) {
			automobilDTO.add(new AutomobilDTO(a));
			
		}
		return new ResponseEntity<>(automobilDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/Automobil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> getAutomobil(@PathVariable("id") Long id){
		Automobil automobil = automobilService.findOne(id);
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new AutomobilDTO(automobil), HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/Automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> addAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
		if(automobilDTO.getKlasaAutomobila() == null || automobilDTO.getKomentar() == null || automobilDTO.getMarkaAutomobila() == null
			|| automobilDTO.getModelAutomobila() == null || automobilDTO.getOcena() == null || automobilDTO.getSlika() == null || automobilDTO.getTipMenjaca() == null
			|| automobilDTO.getVrstaGoriva() == null) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		TKlasaAutomobila tKlasaAutomobila = tKlasaAutomobilaService.findOne(automobilDTO.getKlasaAutomobila().getId());
		TModelAutomobila tModelAutomobila = tModelAutomobilaService.findOne(automobilDTO.getModelAutomobila().getId());
		TTipGoriva tTipGoriva = tTipGorivaService.findOne(automobilDTO.getVrstaGoriva().getId());
		TTipMenjaca tTipMenjaca = tTipMenjacaService.findOne(automobilDTO.getTipMenjaca().getId());
		TMarkaAutomobila tMarkaAutomobila = tMarkaAutomobilaService.findOne(automobilDTO.getMarkaAutomobila().getId());
		List<KomentarDTO> comments = automobilDTO.getKomentar();
		ArrayList<Komentar> komentari = new ArrayList<Komentar>();
		for(KomentarDTO k : comments) {
			komentari.add(komentarService.findOne(k.getId()));
		}
		List<OcenaDTO> rates = automobilDTO.getOcena();
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
		for(OcenaDTO o : rates) {
			ocene.add(ocenaService.findOne(o.getId()));
		}
		List<TSlikaVozilaDTO> images = automobilDTO.getSlika();
		ArrayList<TSlikaVozila> slike = new ArrayList<TSlikaVozila>();
		for(TSlikaVozilaDTO s : images) {
			slike.add(tSlikaVozilaService.findOne(s.getId()));
		}
		
		Automobil savedAutomobil = new Automobil();
		
		savedAutomobil.setKomentar(komentari);
		savedAutomobil.setOcena(ocene);
		savedAutomobil.setSlika(slike);
		savedAutomobil.setId(automobilDTO.getId());
		savedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
		savedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
		savedAutomobil.setPlaniranaKilometraza(automobilDTO.getPlaniranaKilometraza());
		savedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
		savedAutomobil.setKlasaAutomobila(tKlasaAutomobila);
		savedAutomobil.setModelAutomobila(tModelAutomobila);
		savedAutomobil.setMarkaAutomobila(tMarkaAutomobila);
		savedAutomobil.setTipMenjaca(tTipMenjaca);
		savedAutomobil.setVrstaGoriva(tTipGoriva);

		return new ResponseEntity<>(new AutomobilDTO(savedAutomobil), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> updateAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
		
		Automobil updatedAutomobil = automobilService.findOne(automobilDTO.getId());
		if(updatedAutomobil == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedAutomobil.setId(automobilDTO.getId());
		updatedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
		updatedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
		
		/*updatedAutomobil.setKlasaAutomobila(automobilDTO.getKlasaAutomobila());
		updatedAutomobil.setMarkaAutomobila(automobilDTO.getMarkaAutomobila());
		updatedAutomobil.setModelAutomobila(automobilDTO.getModelAutomobila());*/
		
		updatedAutomobil.setPlaniranaKilometraza(automobilDTO.getPlaniranaKilometraza());
		updatedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
		
		//updatedAutomobil.setTipMenjaca(automobilDTO.getTipMenjaca());
		//updatedAutomobil.setVrstaGoriva(automobilDTO.getVrstaGoriva());
		return new ResponseEntity<>(new AutomobilDTO(updatedAutomobil),HttpStatus.OK);
	}
	
	@RequestMapping(value="/Automobil/{id}", method=RequestMethod.DELETE)
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