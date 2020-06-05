package com.example.Messages.controller;

import com.example.Messages.service.CenovnikService;
import com.example.Messages.service.OglasService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.Messages.DTO.CenovnikDTO;
import com.example.Messages.DTO.OglasDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Cenovnik;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;
	@Autowired
	private OglasService oglasService;
	
	@RequestMapping(method=RequestMethod.GET, value="/Cenovnik", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenovnikDTO>> getAllCenovnik(){
		List<Cenovnik> allCenovnik = cenovnikService.getAllCenovnik();
		List<CenovnikDTO> cenovnikDTO = new ArrayList<>();
		for(Cenovnik c : allCenovnik) {
			cenovnikDTO.add(new CenovnikDTO(c));
		}
		return new ResponseEntity<>(cenovnikDTO, HttpStatus.OK);
 	}

	@RequestMapping(method=RequestMethod.GET, value="/Cenovnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikDTO> getCenovnik(@PathVariable("id") Long id){
		Cenovnik cenovnik = cenovnikService.findOne(id);
		if(cenovnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CenovnikDTO(cenovnik), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Cenovnik", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikDTO> addCenovnik(@RequestBody CenovnikDTO cenovnikDTO) throws Exception{
		if(cenovnikDTO.getOglasi() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		List<OglasDTO> ads = cenovnikDTO.getOglasi();
		ArrayList<Oglas> oglasi = new ArrayList<Oglas>();
		for(OglasDTO o : ads) {
			oglasi.add(oglasService.findOne(o.getId()));
		}
		
		Cenovnik savedCenovnik = new Cenovnik();
		
		savedCenovnik.setId(cenovnikDTO.getId());
		savedCenovnik.setCenaCollisionDamageWaiver(cenovnikDTO.getCenaCollisionDamageWaiver());
		savedCenovnik.setCenaPoDanu(cenovnikDTO.getCenaPoDanu());
		savedCenovnik.setCenaPoKilometru(cenovnikDTO.getCenaPoKilometru());
		savedCenovnik.setNazivCenovnika(cenovnikDTO.getNazivCenovnika());
		savedCenovnik.setPopustZaPreko30Dana(cenovnikDTO.getPopustZaPreko30Dana());
		savedCenovnik.setOglasi(oglasi);
		
		return new ResponseEntity<>(new CenovnikDTO(savedCenovnik), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Cenovnik", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikDTO> updateAutomobil(@RequestBody CenovnikDTO cenovnikDTO) throws Exception{
		
		Cenovnik updatedCenovnik = cenovnikService.findOne(cenovnikDTO.getId());
		if(updatedCenovnik == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedCenovnik.setId(cenovnikDTO.getId());
		updatedCenovnik.setCenaCollisionDamageWaiver(cenovnikDTO.getCenaCollisionDamageWaiver());
		updatedCenovnik.setCenaPoDanu(cenovnikDTO.getCenaPoDanu());
		updatedCenovnik.setCenaPoKilometru(cenovnikDTO.getCenaPoKilometru());
		updatedCenovnik.setNazivCenovnika(cenovnikDTO.getNazivCenovnika());
		updatedCenovnik.setPopustZaPreko30Dana(cenovnikDTO.getPopustZaPreko30Dana());
		//updatedCenovnik.setOglasi(cenovnikDTO.getOglasi());
		
		return new ResponseEntity<>(new CenovnikDTO(updatedCenovnik),HttpStatus.OK);
	}
	
	@RequestMapping(value="/Cenovnik/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCenovnik(@PathVariable Long id){
		Cenovnik cenovnik = cenovnikService.findOne(id);
		if(cenovnik != null) {
			cenovnikService.deleteCenovnik(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
