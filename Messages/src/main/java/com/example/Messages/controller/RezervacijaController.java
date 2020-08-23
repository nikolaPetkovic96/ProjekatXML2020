package com.example.Messages.controller;

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

import com.example.Messages.DTO.RezervacijaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
import com.example.Messages.SchemaToJava2.model.user.TUser;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.RezervacijaService;
import com.example.Messages.service.TUserService;

@RestController
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService commonDataService;
	@Autowired
	private TUserService userService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/Rezervacija", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RezervacijaDTO>> getAllRezervacija(){
		
		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacija();
		
		List<RezervacijaDTO> rezervacijeDTO = new ArrayList<>();
		for(Rezervacija r : allRezervacija) {
			
			RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
			CommonData comData = commonDataService.findOne(r.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			TUser user = userService.findOne(comData.getUserid());
			rezervacijaDTO.setUsername(user.getKorisnickoIme());
			rezervacijaDTO.setId(r.getId());
			rezervacijaDTO.setUkupnaCena(r.getUkupnaCena());
			rezervacijaDTO.setOdDatuma(r.getOdDatuma());
			rezervacijaDTO.setDoDatuma(r.getDoDatuma());
			rezervacijaDTO.setBundle(r.getBundle());
			rezervacijaDTO.setStatusRezervacije(r.getStatusRezervacije());
			rezervacijaDTO.setCommonDataId(r.getCommonDataId());

			rezervacijeDTO.add(rezervacijaDTO);
			
		}
		return new ResponseEntity<>(rezervacijeDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/Rezervacija/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> getRezervacija(@PathVariable("id") Long id){
		RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CommonData comData = commonDataService.findOne(rezervacija.getCommonDataId());
		TUser user = userService.findOne(comData.getUserid());
		rezervacijaDTO.setUsername(user.getKorisnickoIme());
		rezervacijaDTO.setId(rezervacija.getId());
		rezervacijaDTO.setUkupnaCena(rezervacija.getUkupnaCena());
		rezervacijaDTO.setOdDatuma(rezervacija.getOdDatuma());
		rezervacijaDTO.setDoDatuma(rezervacija.getDoDatuma());
		rezervacijaDTO.setBundle(rezervacija.getBundle());
		rezervacijaDTO.setStatusRezervacije(rezervacija.getStatusRezervacije());
		rezervacijaDTO.setCommonDataId(rezervacija.getCommonDataId());
		
		return new ResponseEntity<>(rezervacijaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> addRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
		
		Rezervacija savedRezervacija = new Rezervacija();
		
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = commonDataService.addCommonData(commonData);
		
		savedRezervacija.setId(rezervacijaDTO.getId());
		savedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
		savedRezervacija.setOdDatuma(rezervacijaDTO.getOdDatuma());
		savedRezervacija.setDoDatuma(rezervacijaDTO.getDoDatuma());
		savedRezervacija.setBundle(rezervacijaDTO.getBundle());
		savedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
		savedRezervacija.setCommonDataId(commonData.getId());
		
		savedRezervacija = rezervacijaService.addRezervacija(savedRezervacija);

		return new ResponseEntity<>(new RezervacijaDTO(savedRezervacija), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> updateRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
		
		Rezervacija updatedRezervacija = rezervacijaService.findOne(rezervacijaDTO.getId());
		if(updatedRezervacija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Long comDatId = updatedRezervacija.getCommonDataId();
		
		CommonData commonData = commonDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = commonDataService.updateCommonData(comDatId, commonData);
		
		updatedRezervacija.setId(rezervacijaDTO.getId());
		updatedRezervacija.setOdDatuma(rezervacijaDTO.getOdDatuma());
		updatedRezervacija.setDoDatuma(rezervacijaDTO.getDoDatuma());
		updatedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
		updatedRezervacija.setBundle(rezervacijaDTO.getBundle());
		updatedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
		updatedRezervacija.setCommonDataId(comDatId);
		
		updatedRezervacija = rezervacijaService.updateRezervacija(updatedRezervacija.getId(), updatedRezervacija);
		return new ResponseEntity<>(new RezervacijaDTO(updatedRezervacija),HttpStatus.OK);
	}
	
	@RequestMapping(value="/Rezervacija/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRezervacija(@PathVariable Long id){
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		if(rezervacija != null) {
			rezervacijaService.deleteRezervacija(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
