package com.team32.AgentApp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.CenovnikDTO;
import com.team32.AgentApp.model.entitet.Cenovnik;
import com.team32.AgentApp.service.CenovnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;

	@RequestMapping(method=RequestMethod.GET, value="/cenovnik", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenovnikDTO>> getAllCenovnik(){
		List<Cenovnik> allCenovnik = cenovnikService.getAllCenovnik();
		List<CenovnikDTO> cenovnikDTO = new ArrayList<>();
		for(Cenovnik c : allCenovnik) {
			cenovnikDTO.add(new CenovnikDTO(c));
		}
		return new ResponseEntity<>(cenovnikDTO, HttpStatus.OK);
 	}

	@RequestMapping(method=RequestMethod.GET, value="/cenovnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikDTO> getCenovnik(@PathVariable("id") Long id){
		Cenovnik cenovnik = cenovnikService.findOne(id);
		if(cenovnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CenovnikDTO(cenovnik), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cenovnik", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikDTO> addCenovnik(@RequestBody CenovnikDTO cenovnikDTO) throws Exception{

		Cenovnik savedCenovnik = new Cenovnik();
		
		savedCenovnik.setId(cenovnikDTO.getId());
		savedCenovnik.setCenaCollisionDamageWaiver(cenovnikDTO.getCenaCollisionDamageWaiver());
		savedCenovnik.setCenaPoDanu(cenovnikDTO.getCenaPoDanu());
		savedCenovnik.setCenaPoKilometru(cenovnikDTO.getCenaPoKilometru());
		savedCenovnik.setNazivCenovnika(cenovnikDTO.getNazivCenovnika());
		savedCenovnik.setPopustZaPreko30Dana(cenovnikDTO.getPopustZaPreko30Dana());
		
		savedCenovnik.setCommonDataId(cenovnikDTO.getCommonDataId()); //kreirati novi objekat klase commonId;
		
		savedCenovnik = cenovnikService.addCenovnik(savedCenovnik);
		return new ResponseEntity<>(new CenovnikDTO(savedCenovnik), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/cenovnik", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
		
		updatedCenovnik.setCommonDataId(cenovnikDTO.getCommonDataId()); //kreirati novi objekat klase commonId;
		
		
		updatedCenovnik = cenovnikService.updateCenovnik(updatedCenovnik.getId(), updatedCenovnik);
		return new ResponseEntity<>(new CenovnikDTO(updatedCenovnik),HttpStatus.OK);
	}
	
	@RequestMapping(value="/cenovnik/{id}", method=RequestMethod.DELETE)
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
