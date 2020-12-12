package com.team32.AgentApp.controller;

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

import com.team32.AgentApp.DTO.RezervacijaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.RezervacijaService;
import com.team32.AgentApp.service.UserService;

@RestController
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private UserService userService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/rezervacija", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RezervacijaDTO>> getAllRezervacija(){
		
		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacija();
		
		List<RezervacijaDTO> rezervacijeDTO = new ArrayList<>();
		for(Rezervacija r : allRezervacija) {
			
			RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
			CommonData comData = comDataService.findOne(r.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			User user = userService.findOne(comData.getUserid());
			rezervacijaDTO.setUsername(user.getKorisnickoIme());
			rezervacijaDTO.setId(r.getId());
			rezervacijaDTO.setUkupnaCena(r.getUkupnaCena());
			rezervacijaDTO.setBundle(r.getBundle());
			rezervacijaDTO.setStatusRezervacije(r.getStatusRezervacije());
			rezervacijaDTO.setCommonDataId(r.getCommonDataId());

			rezervacijeDTO.add(rezervacijaDTO);
			
		}
		return new ResponseEntity<>(rezervacijeDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/rezervacija/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> getRezervacija(@PathVariable("id") Long id){
		RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CommonData comData = comDataService.findOne(rezervacija.getCommonDataId());
		User user = userService.findOne(comData.getUserid());
		rezervacijaDTO.setUsername(user.getKorisnickoIme());
		rezervacijaDTO.setId(rezervacija.getId());
		rezervacijaDTO.setUkupnaCena(rezervacija.getUkupnaCena());

		rezervacijaDTO.setBundle(rezervacija.getBundle());
		rezervacijaDTO.setStatusRezervacije(rezervacija.getStatusRezervacije());
		rezervacijaDTO.setCommonDataId(rezervacija.getCommonDataId());
		
		return new ResponseEntity<>(rezervacijaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> addRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
		
		Rezervacija savedRezervacija = new Rezervacija();
		
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = comDataService.addCommonData(commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		savedRezervacija.setId(rezervacijaDTO.getId());
		savedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
		savedRezervacija.setBundle(rezervacijaDTO.getBundle());
		savedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
		savedRezervacija.setCommonDataId(commonData.getId());
		
		savedRezervacija = rezervacijaService.addRezervacija(savedRezervacija);

		return new ResponseEntity<>(new RezervacijaDTO(savedRezervacija, user.getKorisnickoIme()), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> updateRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
		
		Rezervacija updatedRezervacija = rezervacijaService.findOne(rezervacijaDTO.getId());
		if(updatedRezervacija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Long comDatId = updatedRezervacija.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		updatedRezervacija.setId(rezervacijaDTO.getId());
		updatedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
		updatedRezervacija.setBundle(rezervacijaDTO.getBundle());
		updatedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
		updatedRezervacija.setCommonDataId(comDatId);
		
		updatedRezervacija = rezervacijaService.updateRezervacija(updatedRezervacija.getId(), updatedRezervacija);
		return new ResponseEntity<>(new RezervacijaDTO(updatedRezervacija,user.getKorisnickoIme()),HttpStatus.OK);
	}
	
	@RequestMapping(value="/rezervacija/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRezervacija(@PathVariable Long id){
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		if(rezervacija != null) {
			rezervacijaService.deleteRezervacija(id);
			comDataService.deleteCommonData(rezervacija.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
