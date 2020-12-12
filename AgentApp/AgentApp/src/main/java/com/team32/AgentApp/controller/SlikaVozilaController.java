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

import com.team32.AgentApp.DTO.SlikaVozilaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.SlikaVozila;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.SlikaVozilaService;

@RestController
public class SlikaVozilaController {
	
	@Autowired
	private SlikaVozilaService slikaService;	
	@Autowired
	private CommonDataService comDataService;

		//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/slikaVozila", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<SlikaVozilaDTO>> getAllSlikaVozila() {
			List<SlikaVozila> all =  slikaService.getAllSlikaVozila();
			
			List<SlikaVozilaDTO> dto = new ArrayList<>();
			for(SlikaVozila sv : all )
				dto.add(new SlikaVozilaDTO(sv));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/slikaVozila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SlikaVozilaDTO> getSlikaVozila(@PathVariable("id") Long id){
		SlikaVozila slikaVoz = slikaService.findOne(id);
			if(slikaVoz == null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new SlikaVozilaDTO(slikaVoz), HttpStatus.OK);
		}
		
		//POST
		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="/slikaVozila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SlikaVozilaDTO> addSlikaVozila(@RequestBody SlikaVozilaDTO dto)  throws Exception {
			SlikaVozila savedSlika = new SlikaVozila();
		
			//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
			commonData.setDatumKreiranja(now);
			commonData = comDataService.addCommonData(commonData);
		
			savedSlika.setId(dto.getId());
			savedSlika.setSlika(dto.getSlika());
			savedSlika.setAutomobilId(dto.getAutomobilId());
			savedSlika.setCommonDataId(commonData.getId());
			
			savedSlika = slikaService.addSlikaVozila(savedSlika);
			return new ResponseEntity<>(new SlikaVozilaDTO(savedSlika), HttpStatus.CREATED);
		}
		
		//PUT	
		@RequestMapping(method=RequestMethod.PUT, value="/slikaVozila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SlikaVozilaDTO> updateSlikaVozila(@RequestBody SlikaVozilaDTO dto) throws Exception{
			SlikaVozila updSlika = slikaService.findOne(dto.getId());
			if(updSlika==null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Long comDatId = updSlika.getCommonDataId();
			
			CommonData commonData = comDataService.findOne(comDatId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDatId, commonData);
			
			updSlika.setId(dto.getId());
			updSlika.setSlika(dto.getSlika());
			updSlika.setAutomobilId(dto.getAutomobilId());
			updSlika.setCommonDataId(comDatId);			
			
			updSlika = slikaService.updateSlikaVozila(updSlika.getId(), updSlika);
			return new ResponseEntity<>(new SlikaVozilaDTO(updSlika), HttpStatus.OK);	
		}
		
		//DELET	
		@RequestMapping(value="/slikaVozila/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteSlikaVozila(@PathVariable Long id) {
			SlikaVozila slikaVoz = slikaService.findOne(id);
			if (slikaVoz != null) {
				slikaService.deleteSlikaVozila(id);
				comDataService.deleteCommonData(slikaVoz.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}	
}
