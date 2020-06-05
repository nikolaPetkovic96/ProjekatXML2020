package com.example.Messages.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

import com.example.Messages.DTO.TMarkaAutomobilaDTO;
import com.example.Messages.DTO.TModelAutomobilaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TMarkaAutomobilaService;
import com.example.Messages.service.TModelAutomobilaService;

@RestController
public class TMarkaAutomobilaController {
	@Autowired
	private TMarkaAutomobilaService service;
	@Autowired 
	private CommonDataService cmdServ;
	@Autowired
	private TModelAutomobilaService modServ;
	

	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/TMarkaAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TMarkaAutomobilaDTO>> getAllTTIpMenjaca() {
		List<TMarkaAutomobila> all = service.getAllTMarkaAutomobila();
		
		List<TMarkaAutomobilaDTO> dto = new ArrayList<>();
		for(TMarkaAutomobila tm : all )
			dto.add(new TMarkaAutomobilaDTO(tm));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TMarkaAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TMarkaAutomobilaDTO> getTTMarkaAutomobila(@PathVariable("id") Long id){
		TMarkaAutomobila ttip=service.findOne(id);
			if(ttip==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TMarkaAutomobilaDTO(ttip), HttpStatus.OK);
	}
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/TMarkaAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TMarkaAutomobilaDTO> addTTipMenjaca(@RequestBody TMarkaAutomobila dto)  throws Exception {
		TMarkaAutomobila saved = new TMarkaAutomobila();
		saved.setId(dto.getId());
		saved.setNazivMarke(dto.getNazivMarke());
		//saved.setModelAutomobila();
		
		saved.getCommonData().setId(null);
		saved.getCommonData().setDatumKreiranja(Timestamp.valueOf(LocalDateTime.now()));
		saved.getCommonData().setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
		//saved.getCommonData().setKorisnik(token_korisnika););//todo	korisnik
		
		saved.setCommonData(cmdServ.addCommonData(saved.getCommonData()));
		
		saved=service.addTMarkaAutomobila(saved);
		return new ResponseEntity<>(new TMarkaAutomobilaDTO(saved), HttpStatus.CREATED);
	}
	
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TMarkaAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TMarkaAutomobilaDTO> updateTTipMenjaca(@RequestBody TMarkaAutomobilaDTO dto) throws Exception{
		TMarkaAutomobila upd=service.findOne(dto.getId());
		if(upd==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		upd.setId(dto.getId());
		//upd.setModelAutomobila(modServ.findOne(dto.getModelAutomobila()));	//treba updejtovati modele
		upd.setNazivMarke(dto.getNazivMarke());
		
		CommonData cmdUpd=cmdServ.findOne(dto.getCommonData().getId());
		cmdUpd.setId(dto.getCommonData().getId());
		cmdUpd.setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
		cmdUpd.setDatumKreiranja(dto.getCommonData().getDatumKreiranja());
		//cmdUpd.setKorisnik(usrServ.findOne(user_id));	//dodaj korisnika
			
		cmdUpd=cmdServ.updateCommonData(dto.getCommonData().getId(),cmdUpd);		
		upd.setCommonData(cmdUpd); 
		
		upd=service.updateTMarkaAutomobila(upd.getId(), upd);
		return new ResponseEntity<>(new TMarkaAutomobilaDTO(upd), HttpStatus.OK);	
	}
			
		//DELET	
	@RequestMapping(value="/TMarkaAutomobila/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTTipMenjaca(@PathVariable Long id) {
		TMarkaAutomobila ttip= service.findOne(id);
		if (ttip != null) {
			service.deleteTMarkaAutomobila(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
