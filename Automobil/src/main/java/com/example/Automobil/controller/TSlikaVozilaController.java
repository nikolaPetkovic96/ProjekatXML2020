package com.example.Automobil.controller;



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

import com.example.Automobil.dto.TSlikaVozilaDTO;
import com.example.Automobil.model.CommonData;
import com.example.Automobil.model.TSlikaVozila;
import com.example.Automobil.service.CommonDataService;
import com.example.Automobil.service.TSlikaVozilaService;


@RestController
@RequestMapping("slikaVozila")
public class TSlikaVozilaController {
	
	@Autowired
	private TSlikaVozilaService slikaService;	
	@Autowired
	private CommonDataService comDataService;

		//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<TSlikaVozilaDTO>> getAllSlikaVozila() {
			List<TSlikaVozila> all =  slikaService.getAllSlikaVozila();
			
			List<TSlikaVozilaDTO> dto = new ArrayList<>();
			for(TSlikaVozila sv : all )
				dto.add(new TSlikaVozilaDTO(sv));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TSlikaVozilaDTO> getSlikaVozila(@PathVariable("id") Long id){
		TSlikaVozila slikaVoz = slikaService.findOne(id);
			if(slikaVoz == null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TSlikaVozilaDTO(slikaVoz), HttpStatus.OK);
		}
		
		//POST
		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TSlikaVozilaDTO> addSlikaVozila(@RequestBody TSlikaVozilaDTO dto)  throws Exception {
			TSlikaVozila savedSlika = new TSlikaVozila();
		
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
			return new ResponseEntity<>(new TSlikaVozilaDTO(savedSlika), HttpStatus.CREATED);
		}
		
		//Obrisati
		//PUT	
		@RequestMapping(method=RequestMethod.PUT, value="", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TSlikaVozilaDTO> updateSlikaVozila(@RequestBody TSlikaVozilaDTO dto) throws Exception{
			TSlikaVozila updSlika = slikaService.findOne(dto.getId());
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
			return new ResponseEntity<>(new TSlikaVozilaDTO(updSlika), HttpStatus.OK);	
		}
		
		//DELET	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteSlikaVozila(@PathVariable Long id) {
			TSlikaVozila slikaVoz = slikaService.findOne(id);
			if (slikaVoz != null) {
				slikaService.deleteSlikaVozila(id);
				comDataService.deleteCommonData(slikaVoz.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}	
}
