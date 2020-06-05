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

import com.example.Messages.DTO.TTipMenjacaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TTipMenjacaService;

/**
 * Created by oneclicklabs.io
 */
@RestController
public class TTipMenjacaController {

	@Autowired
	private TTipMenjacaService service;
	@Autowired
	private CommonDataService cmdServ;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/TTipMenjaca", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TTipMenjacaDTO>> getAllTTIpMenjaca() {
		List<TTipMenjaca> all = service.getAllTTipMenjaca();
		
		List<TTipMenjacaDTO> dto = new ArrayList<>();
		for(TTipMenjaca tm : all )
			dto.add(new TTipMenjacaDTO(tm));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TTipMenjaca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TTipMenjacaDTO> getTipMenjaca(@PathVariable("id") Long id){
			TTipMenjaca ttip=service.findOne(id);
			if(ttip==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TTipMenjacaDTO(ttip), HttpStatus.OK);
	}
	//POST
	//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/TTIpMenjaca",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipMenjacaDTO> addTTipMenjaca(@RequestBody TTipMenjaca dto)  throws Exception {
		TTipMenjaca saved = new TTipMenjaca();
		saved.setId(dto.getId());
		saved.setNazivMenjaca(dto.getNazivMenjaca());
		
		saved.getCommonData().setId(null);
		saved.getCommonData().setDatumKreiranja(Timestamp.valueOf(LocalDateTime.now()));
		saved.getCommonData().setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
		//saved.getCommonData().setKorisnik(token_korisnika););//todo
		
		saved.setCommonData(cmdServ.addCommonData(saved.getCommonData()));
		
		saved=service.addTTipMenjaca(saved);
		return new ResponseEntity<>(new TTipMenjacaDTO(saved), HttpStatus.CREATED);

	}
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TTipMenjaca", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipMenjacaDTO> updateTTipMenjaca(@RequestBody TTipMenjacaDTO dto) throws Exception{
		TTipMenjaca upd=service.findOne(dto.getId());
		if(upd==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		upd.setId(dto.getId());
		upd.setNazivMenjaca(dto.getNazivMenjaca());
		
		CommonData cmdUpd=cmdServ.findOne(dto.getCommonData().getId());
		cmdUpd.setId(dto.getCommonData().getId());
		cmdUpd.setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
		cmdUpd.setDatumKreiranja(dto.getCommonData().getDatumKreiranja());
		//cmdUpd.setKorisnik(usrServ.findOne(user_id));	//dodaj korisnika

		
		cmdUpd=cmdServ.updateCommonData(dto.getCommonData().getId(),cmdUpd);		
		upd.setCommonData(cmdUpd); 
		
		upd=service.updateTTipMenjaca(upd.getId(), upd);
		return new ResponseEntity<>(new TTipMenjacaDTO(upd), HttpStatus.OK);	
	}
	//DELET	
	@RequestMapping(value="/TTipMenjaca/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTTipMenjaca(@PathVariable Long id) {
		TTipMenjaca ttip= service.findOne(id);
		if (ttip != null) {
			service.deleteTTipMenjaca(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
