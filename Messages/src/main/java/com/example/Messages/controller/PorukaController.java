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

import com.example.Messages.DTO.KomentarDTO;
import com.example.Messages.DTO.PorukaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.PorukaService;

@RestController
public class PorukaController {

	@Autowired
	private CommonDataService cds;
	@Autowired 
	private PorukaService porukaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/Poruka", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PorukaDTO>> getAllPoruka(){
		List<Poruka> allPoruka = porukaService.getAllPoruka();
		List<PorukaDTO> porukaDTO = new ArrayList();
		for(Poruka p : allPoruka) {
			porukaDTO.add(new PorukaDTO(p));
		}
		return new ResponseEntity<>(porukaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/Poruka/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorukaDTO> getPoruka(@PathVariable("id") Long id){
		
		Poruka poruka = porukaService.findOne(id);
		if (poruka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new PorukaDTO(poruka), HttpStatus.OK);
	}
	
	//POST
		@RequestMapping(method=RequestMethod.POST, value="/Poruka",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<PorukaDTO> addPoruka(@RequestBody PorukaDTO porukaDTO)  throws Exception {
			
			Poruka savedPoruka = new Poruka();
		
			savedPoruka.setId(porukaDTO.getId());
			savedPoruka.setCommonData(cds.findOne(porukaDTO.getId()));
			savedPoruka.setTekstPoruke(porukaDTO.getTekstPoruke());
			
			savedPoruka = porukaService.addPoruka(savedPoruka);
			
			return new ResponseEntity<>(new PorukaDTO(savedPoruka), HttpStatus.CREATED);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/Poruka", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<PorukaDTO> updatePoruka(@RequestBody PorukaDTO porukaDTO) throws Exception{
			
			Poruka updatedPoruka = porukaService.findOne(porukaDTO.getId());
			if(updatedPoruka == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			updatedPoruka.setId(porukaDTO.getId());
			updatedPoruka.setTekstPoruke(porukaDTO.getTekstPoruke());
			updatedPoruka.setCommonData(cds.findOne(porukaDTO.getId()));
			
			updatedPoruka = porukaService.updatePoruka(updatedPoruka.getId(), updatedPoruka);
			
			return new ResponseEntity<>(new PorukaDTO(updatedPoruka),HttpStatus.OK);
		}

		@RequestMapping(value="/Poruka/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deletePoruka(@PathVariable Long id){
			Poruka poruka = porukaService.findOne(id);
			if(poruka != null) {
				porukaService.deletePoruka(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
}
