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
import com.example.Messages.DTO.AutomobilDTO;
import com.example.Messages.DTO.OglasDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
import com.example.Messages.SchemaToJava2.model.user.Administrator;
import com.example.Messages.service.OglasService;

@RestController
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/Oglas", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OglasDTO>> getAllOglas() {
		
			List<Oglas> allOglas = oglasService.getAllOglas();
			
			List<OglasDTO> oglasDTO = new ArrayList<>();
			for (Oglas o : allOglas) {
				oglasDTO.add(new OglasDTO(o));
			}
			
			return new ResponseEntity<>(oglasDTO, HttpStatus.OK);
		}
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/Oglas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDTO> getOglas(@PathVariable("id") Long id){
			
			Oglas oglas = oglasService.findOne(id);
			
			if (oglas == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(new OglasDTO(oglas), HttpStatus.OK);
		}
		
		//POST
		@RequestMapping(method=RequestMethod.POST, value="/Oglas",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDTO> addOglas(@RequestBody OglasDTO oglasDTO)  throws Exception {
			Oglas savedOglas = new Oglas();
			
			savedOglas.setId(oglasDTO.getId());	
			savedOglas.setOdDatuma(oglasDTO.getOdDatuma());
			savedOglas.setDoDatuma(oglasDTO.getDoDatuma());
			
			savedOglas = oglasService.addOglas(savedOglas);
			
			return new ResponseEntity<>(new OglasDTO(savedOglas), HttpStatus.CREATED);
		}
		//PUT
		@RequestMapping(method=RequestMethod.PUT, value="/Oglas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDTO> updateOglas(@RequestBody OglasDTO oglasDTO) throws Exception{
			
			Oglas updatedOglas = oglasService.findOne(oglasDTO.getId());
			if(updatedOglas == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			updatedOglas.setId(oglasDTO.getId());
			updatedOglas.setOdDatuma(oglasDTO.getOdDatuma());
			updatedOglas.setDoDatuma(oglasDTO.getDoDatuma());
			updatedOglas = oglasService.updateOglas(updatedOglas.getId(), updatedOglas);
			
			return new ResponseEntity<>(new OglasDTO(updatedOglas),HttpStatus.OK);
		}
		//DELETE	
		@RequestMapping(value="/Oglas/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteOglas(@PathVariable Long id) {
			
			Oglas oglas = oglasService.findOne(id);
			if (oglas != null) {
				oglasService.deleteOglas(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}
		
}
