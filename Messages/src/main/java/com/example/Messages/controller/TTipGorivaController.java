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

import com.example.Messages.DTO.TTipGorivaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TTipGorivaService;
import com.example.Messages.service.TUserService;

public class TTipGorivaController {
	
	@Autowired
	private TTipGorivaService service;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private TUserService usrServ;
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/TTipGoriva", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TTipGorivaDTO>> getAllTTipGoriva() {
		
		List<TTipGorivaDTO> lista=new ArrayList<>();
		for(TTipGoriva tg: service.getAllTTipGoriva()) {
			lista.add(new TTipGorivaDTO(tg));
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);	
	}
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TTipGoriva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipGorivaDTO> getTTipGoriva(@PathVariable("id") Long id){
		TTipGoriva tip=service.findOne(id);
		if(tip==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new TTipGorivaDTO(tip), HttpStatus.OK);	
	}
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/TTipGoriva",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipGorivaDTO> addTTipGoriva(@RequestBody TTipGoriva tipDTO)  throws Exception {
		TTipGoriva novi= new TTipGoriva();
		
		novi.setId(tipDTO.getId());
		novi.setNazivTipa(tipDTO.getNazivTipa());
		
		novi.getCommonData().setId(null);
		novi.getCommonData().setDatumKreiranja(Timestamp.valueOf(LocalDateTime.now()));
		novi.getCommonData().setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
		//saved.getCommonData().setKorisnik(token_korisnika););//todo
		
		novi.setCommonData(cmdServ.addCommonData(novi.getCommonData()));
		novi=service.addTTipGoriva(novi);
		return new ResponseEntity<>(new TTipGorivaDTO(novi), HttpStatus.CREATED);		
	}
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TTipGoriva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipGorivaDTO> updateTTipMenjaca(@RequestBody TTipGorivaDTO dto) throws Exception{
		TTipGoriva upd=service.findOne(dto.getId());
		if(upd==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		upd.setId(dto.getId());
		upd.setNazivTipa(dto.getNazivTipa());
		
		CommonData cmdUpd=cmdServ.findOne(dto.getCommonData().getId());
		cmdUpd.setId(dto.getCommonData().getId());
		cmdUpd.setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
		cmdUpd.setDatumKreiranja(dto.getCommonData().getDatumKreiranja());		
		
		cmdUpd=cmdServ.updateCommonData(dto.getCommonData().getId(),cmdUpd);		
		upd.setCommonData(cmdUpd); 
		
		upd=service.updateTTipGoriva(upd.getId(), upd);
		return new ResponseEntity<>(new TTipGorivaDTO(upd), HttpStatus.OK);	
	}
	//DELET	
	@RequestMapping(value="/TTipGoriva/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTTipGoriva(@PathVariable Long id) {
		TTipGoriva ttip= service.findOne(id);
		if (ttip != null) {
			service.deleteTTipGoriva(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}			
}
