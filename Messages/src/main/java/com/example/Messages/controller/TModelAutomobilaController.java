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

import com.example.Messages.DTO.TModelAutomobilaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
//import com.example.Messages.DTO.TTipMenjacaDTO;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TMarkaAutomobilaService;
import com.example.Messages.service.TModelAutomobilaService;

@RestController
public class TModelAutomobilaController {
	@Autowired
	private TModelAutomobilaService tModelAutoService;
	@Autowired 
	private CommonDataService comDataService;
	@Autowired 
	private TMarkaAutomobilaService mrkService;
	
	//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/TModelAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<TModelAutomobilaDTO>> getAllTTIpMenjaca() {
			List<TModelAutomobila> all = tModelAutoService.getAllTModelAutomobila();
			
			List<TModelAutomobilaDTO> dto = new ArrayList<>();
			for(TModelAutomobila tm : all )
				dto.add(new TModelAutomobilaDTO(tm));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/TModelAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<TModelAutomobilaDTO> getTModelAutomobila(@PathVariable("id") Long id){
			TModelAutomobila ttip=tModelAutoService.findOne(id);
				if(ttip==null) 
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				return new ResponseEntity<>(new TModelAutomobilaDTO(ttip), HttpStatus.OK);
		}
		
		//POST
		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="/TModelAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TModelAutomobilaDTO> addTTipMenjaca(@RequestBody TModelAutomobilaDTO dto)  throws Exception {
			TModelAutomobila savedTModelAuto = new TModelAutomobila();
		
			
			//Prilkom kreiranja novog modela automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
			commonData.setDatumKreiranja(now);
			commonData = comDataService.addCommonData(commonData);
			
			
			savedTModelAuto.setId(dto.getId());
			savedTModelAuto.setNazivModela(dto.getNazivModela());
			savedTModelAuto.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
			savedTModelAuto.setCommonDataId(commonData.getId());
			
		
			//saved.getCommonData().setKorisnik(token_korisnika););//todo	korisnik
			
			savedTModelAuto = tModelAutoService.addTModelAutomobila(savedTModelAuto);
			return new ResponseEntity<>(new TModelAutomobilaDTO(savedTModelAuto), HttpStatus.CREATED);
		}
		//PUT	
		@RequestMapping(method=RequestMethod.PUT, value="/TModelAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TModelAutomobilaDTO> updateTTipMenjaca(@RequestBody TModelAutomobilaDTO dto) throws Exception{
			
			TModelAutomobila updTModelAuto = tModelAutoService.findOne(dto.getId());
			
			if(updTModelAuto==null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			Long comDatId = updTModelAuto.getCommonDataId();
			
			CommonData commonData = comDataService.findOne(comDatId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDatId, commonData);
			
			updTModelAuto.setId(dto.getId());
			updTModelAuto.setNazivModela(dto.getNazivModela());
			updTModelAuto.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
			updTModelAuto.setCommonDataId(commonData.getId());
			
			//cmdUpd.setKorisnik(usrServ.findOne(user_id));	//dodaj korisnika
			
			updTModelAuto = tModelAutoService.updateTModelAutomobila(updTModelAuto.getId(), updTModelAuto);
			return new ResponseEntity<>(new TModelAutomobilaDTO(updTModelAuto), HttpStatus.OK);	
		}
		//DELET	
		@RequestMapping(value="/TModelAutomobila/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteTTipMenjaca(@PathVariable Long id) {
			TModelAutomobila ttip= tModelAutoService.findOne(id);
			if (ttip != null) {
				tModelAutoService.deleteTModelAutomobila(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}	
}
