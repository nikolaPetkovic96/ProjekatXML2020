//package com.example.Messages.controller;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.Messages.DTO.TModelAutomobilaDTO;
//import com.example.Messages.DTO.TTipMenjacaDTO;
//import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
//import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
//import com.example.Messages.service.CommonDataService;
//import com.example.Messages.service.TMarkaAutomobilaService;
//import com.example.Messages.service.TModelAutomobilaService;
//
//@RestController
//public class TModelAutomobilaController {
//	@Autowired
//	private TModelAutomobilaService service;
//	@Autowired 
//	CommonDataService cmdServ;
//	
//	//GET ALL	
//		@RequestMapping(method=RequestMethod.GET, value="/TModelAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<List<TModelAutomobilaDTO>> getAllTTIpMenjaca() {
//			List<TModelAutomobila> all = service.getAllTModelAutomobila();
//			
//			List<TModelAutomobilaDTO> dto = new ArrayList<>();
//			for(TModelAutomobila tm : all )
//				dto.add(new TModelAutomobilaDTO(tm));
//			return new ResponseEntity<>(dto, HttpStatus.OK);
//		}
//		//GET
//		@RequestMapping(method=RequestMethod.GET, value="/TModelAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//			public ResponseEntity<TModelAutomobilaDTO> getTModelAutomobila(@PathVariable("id") Long id){
//			TModelAutomobila ttip=service.findOne(id);
//				if(ttip==null) 
//					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//				return new ResponseEntity<>(new TModelAutomobilaDTO(ttip), HttpStatus.OK);
//		}
//		
//		//POST
//		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
//		@RequestMapping(method=RequestMethod.POST, value="/TModelAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<TModelAutomobilaDTO> addTTipMenjaca(@RequestBody TModelAutomobila dto)  throws Exception {
//			TModelAutomobila saved = new TModelAutomobila();
//			saved.setId(dto.getId());
////			saved.setMarkaAutomobila(mrkService.findOne(dto.getMarkaAutomobila().getId()));
//			saved.setNazivModela(dto.getNazivModela());
//			
//			saved.getCommonData().setId(null);
//			saved.getCommonData().setDatumKreiranja(Timestamp.valueOf(LocalDateTime.now()));
//			saved.getCommonData().setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
//			//saved.getCommonData().setKorisnik(token_korisnika););//todo	korisnik
//			
//			saved.setCommonData(cmdServ.addCommonData(saved.getCommonData()));
//			
//			saved=service.addTModelAutomobila(saved);
//			return new ResponseEntity<>(new TModelAutomobilaDTO(saved), HttpStatus.CREATED);
//		}
//		//PUT	
//		@RequestMapping(method=RequestMethod.PUT, value="/TModelAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<TModelAutomobilaDTO> updateTTipMenjaca(@RequestBody TModelAutomobilaDTO dto) throws Exception{
//			TModelAutomobila upd=service.findOne(dto.getId());
//			if(upd==null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
//			upd.setId(dto.getId());
////			upd.setMarkaAutomobila(mrkService.findOne(dto.getMarkaAutomobila().getId()));
//			upd.setNazivModela(dto.getNazivModela());
//			
//			CommonData cmdUpd=cmdServ.findOne(dto.getCommonData().getId());
//			cmdUpd.setId(dto.getCommonData().getId());
//			cmdUpd.setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
//			cmdUpd.setDatumKreiranja(dto.getCommonData().getDatumKreiranja());
//			//cmdUpd.setKorisnik(usrServ.findOne(user_id));	//dodaj korisnika
//
//			
//			cmdUpd=cmdServ.updateCommonData(dto.getCommonData().getId(),cmdUpd);		
//			upd.setCommonData(cmdUpd); 
//			
//			upd=service.updateTModelAutomobila(upd.getId(), upd);
//			return new ResponseEntity<>(new TModelAutomobilaDTO(upd), HttpStatus.OK);	
//		}
//		//DELET	
//		@RequestMapping(value="/TModelAutomobila/{id}", method=RequestMethod.DELETE)
//		public ResponseEntity<Void> deleteTTipMenjaca(@PathVariable Long id) {
//			TModelAutomobila ttip= service.findOne(id);
//			if (ttip != null) {
//				service.deleteTModelAutomobila(id);
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			} 
//		}	
//}
