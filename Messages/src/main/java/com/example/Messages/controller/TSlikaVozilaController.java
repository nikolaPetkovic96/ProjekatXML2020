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
//import com.example.Messages.DTO.TTipMenjacaDTO;
//import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
//import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
//import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
//import com.example.Messages.service.AutomobilService;
//import com.example.Messages.service.CommonDataService;
//import com.example.Messages.service.TSlikaVozilaService;
//
//@RestController
//public class TSlikaVozilaController {
//	
//	@Autowired
//	private TSlikaVozilaService service;	
//	@Autowired
//	private CommonDataService cmdServ;
//	@Autowired
//	private AutomobilService autoServ;
//	
//	//GET ALL	
//		@RequestMapping(method=RequestMethod.GET, value="/TSlikaVozila", produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<List<TSlikaVozilaDTO>> getAllTTIpMenjaca() {
//			List<TSlikaVozila> all = service.getAllTSlikaVozila();
//			
//			List<TSlikaVozilaDTO> dto = new ArrayList<>();
//			for(TSlikaVozila ts : all )
//				dto.add(new TSlikaVozilaDTO(ts));
//			return new ResponseEntity<>(dto, HttpStatus.OK);
//		}
//		//GET
//		@RequestMapping(method=RequestMethod.GET, value="/TSlikaVozila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//			public ResponseEntity<TSlikaVozilaDTO> getTipMenjaca(@PathVariable("id") Long id){
//			TSlikaVozila ttip=service.findOne(id);
//				if(ttip==null) 
//					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//				return new ResponseEntity<>(new TSlikaVozilaDTO(ttip), HttpStatus.OK);
//		}
//		
//		//POST
//		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
//		@RequestMapping(method=RequestMethod.POST, value="/TSlikaVozila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<TSlikaVozilaDTO> addTTipMenjaca(@RequestBody TSlikaVozila ts)  throws Exception {
//			TSlikaVozila saved = new TSlikaVozila();
//			saved.setId(ts.getId());
//			saved.setSlika(ts.getSlika());
//			saved.setAutomobil(autoServ.findOne(ts.getAutomobil().getId())); // kad ubacujemo sliku automobil je vec kreiran u bazi?
//			
//			saved.getCommonData().setId(null);
//			saved.getCommonData().setDatumKreiranja(Timestamp.valueOf(LocalDateTime.now()));
//			saved.getCommonData().setDatumIzmene(Timestamp.valueOf(LocalDateTime.now()));
//			//saved.getCommonData().setKorisnik(token_korisnika););//todo
//			
//			saved.setCommonData(cmdServ.addCommonData(saved.getCommonData()));
//			
//			saved=service.addTSlikaVozila(saved);
//			return new ResponseEntity<>(new TSlikaVozilaDTO(saved), HttpStatus.CREATED);
//		}
//		//PUT	
//		@RequestMapping(method=RequestMethod.PUT, value="/TSlikaVozila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<TSlikaVozilaDTO> updateTTipMenjaca(@RequestBody TSlikaVozilaDTO dto) throws Exception{
//			TSlikaVozila upd=service.findOne(dto.getId());
//			if(upd==null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
//			upd.setId(dto.getId());
//			upd.setSlika(dto.getSlika());
//			upd.setAutomobil(autoServ.findOne(dto.getAutomobil().getId()));
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
//			upd=service.updateTSlikaVozila(upd.getId(), upd);
//			return new ResponseEntity<>(new TSlikaVozilaDTO(upd), HttpStatus.OK);	
//		}
//		//DELET	
//		@RequestMapping(value="/TSlikaVozila/{id}", method=RequestMethod.DELETE)
//		public ResponseEntity<Void> deleteTSlikaVozila(@PathVariable Long id) {
//			TSlikaVozila ttip= service.findOne(id);
//			if (ttip != null) {
//				service.deleteTSlikaVozila(id);
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			} 
//		}	
//}
