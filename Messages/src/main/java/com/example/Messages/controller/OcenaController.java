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

import com.example.Messages.DTO.AdministratorDTO;
import com.example.Messages.DTO.OcenaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.SchemaToJava2.model.user.Administrator;
import com.example.Messages.service.OcenaService;

@RestController
public class OcenaController {

	@Autowired
	private OcenaService ocenaService;
	
	//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/Ocena", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OcenaDTO>> getAllOcena() {
		
			List<Ocena> allOcena = ocenaService.getAllOcena();
			List<OcenaDTO> ocenaDTO = new ArrayList();
			for(Ocena o : allOcena) {
				ocenaDTO.add(new OcenaDTO(o));
			}
			
			return new ResponseEntity<>(ocenaDTO, HttpStatus.OK);
		}
	
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/Ocena/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OcenaDTO> getOcena(@PathVariable("id") Long id){
			
			Ocena ocena = ocenaService.findOne(id);
			//return radnikService.getRadnik(id);
			if (ocena == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(new OcenaDTO(ocena), HttpStatus.OK);
		}
	
	
	//POST
	//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/Ocena",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OcenaDTO> addOcena(@RequestBody OcenaDTO ocenaDTO)  throws Exception {
		Ocena savedOcena = new Ocena();
			
		savedOcena.setId(ocenaDTO.getId());	
		savedOcena.setVrednostOcene(ocenaDTO.getVrednostOcene());
		savedOcena  = ocenaService.addOcena(savedOcena);
		
		return new ResponseEntity<>(new OcenaDTO(savedOcena), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/Ocena", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OcenaDTO> updateOcena(@RequestBody OcenaDTO ocenaDTO) throws Exception{
		
		Ocena updatedOcena = ocenaService.findOne(ocenaDTO.getId());
		
		if (updatedOcena == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedOcena.setId(ocenaDTO.getId());
		updatedOcena.setVrednostOcene(ocenaDTO.getVrednostOcene());	
		
		updatedOcena = ocenaService.updateOcena(updatedOcena.getId(), updatedOcena);
		return new ResponseEntity<>(new OcenaDTO(updatedOcena), HttpStatus.OK);
	}
	@RequestMapping(value="/Ocena/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOcena(@PathVariable Long id) {
		
		Ocena ocena = ocenaService.findOne(id);
		if (ocena != null) {
			ocenaService.deleteOcena(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
