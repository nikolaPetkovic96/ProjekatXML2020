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

import com.example.Messages.DTO.TSlikaVozilaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TSlikaVozilaService;

@RestController
public class TSlikaVozilaController {
	
	@Autowired
	private TSlikaVozilaService tSlikaService;	
	@Autowired
	private CommonDataService comDataService;

		//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/TSlikaVozila", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<TSlikaVozilaDTO>> getAllTTIpMenjaca() {
			List<TSlikaVozila> all =  tSlikaService.getAllTSlikaVozila();
			
			List<TSlikaVozilaDTO> dto = new ArrayList<>();
			for(TSlikaVozila ts : all )
				dto.add(new TSlikaVozilaDTO(ts));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/TSlikaVozila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TSlikaVozilaDTO> getTipMenjaca(@PathVariable("id") Long id){
		TSlikaVozila ttip= tSlikaService.findOne(id);
			if(ttip==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TSlikaVozilaDTO(ttip), HttpStatus.OK);
		}
		
		//POST
		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="/TSlikaVozila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TSlikaVozilaDTO> addTTipMenjaca(@RequestBody TSlikaVozilaDTO dto)  throws Exception {
			TSlikaVozila savedTSlika = new TSlikaVozila();
		
			//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
			commonData.setDatumKreiranja(now);
			commonData = comDataService.addCommonData(commonData);
		
			savedTSlika.setId(dto.getId());
			savedTSlika.setSlika(dto.getSlika());
			savedTSlika.setCommonDataId(commonData.getId());
			
			savedTSlika = tSlikaService.addTSlikaVozila(savedTSlika);
			return new ResponseEntity<>(new TSlikaVozilaDTO(savedTSlika), HttpStatus.CREATED);
		}
		
		//PUT	
		@RequestMapping(method=RequestMethod.PUT, value="/TSlikaVozila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TSlikaVozilaDTO> updateTTipMenjaca(@RequestBody TSlikaVozilaDTO dto) throws Exception{
			TSlikaVozila updTSlika = tSlikaService.findOne(dto.getId());
			if(updTSlika==null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Long comDatId = updTSlika.getCommonDataId();
			
			CommonData commonData = comDataService.findOne(comDatId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDatId, commonData);
			
			updTSlika.setId(dto.getId());
			updTSlika.setSlika(dto.getSlika());
			updTSlika.setCommonDataId(comDatId);
			//PROVERITI COMMON DATA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
			updTSlika = tSlikaService.updateTSlikaVozila(updTSlika.getId(), updTSlika);
			return new ResponseEntity<>(new TSlikaVozilaDTO(updTSlika), HttpStatus.OK);	
		}
		
		//DELET	
		@RequestMapping(value="/TSlikaVozila/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteTSlikaVozila(@PathVariable Long id) {
			TSlikaVozila ttip = tSlikaService.findOne(id);
			if (ttip != null) {
				tSlikaService.deleteTSlikaVozila(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}	
}
