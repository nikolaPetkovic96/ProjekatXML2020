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

import com.team32.AgentApp.DTO.ModelAutomobilaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.ModelAutomobila;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.ModelAutomobilaService;


@RestController
public class ModelAutomobilaController {
	
	@Autowired
	private ModelAutomobilaService modelAutoService;
	@Autowired 
	private CommonDataService comDataService;
	
	//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/modelAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ModelAutomobilaDTO>> getAllModelAutomobila() {
			List<ModelAutomobila> all = modelAutoService.getAllModelAutomobila();
			
			List<ModelAutomobilaDTO> dto = new ArrayList<>();
			for(ModelAutomobila ma : all )
				dto.add(new ModelAutomobilaDTO(ma));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/modelAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ModelAutomobilaDTO> getModelAutomobila(@PathVariable("id") Long id){
			ModelAutomobila ttip=modelAutoService.findOne(id);
				if(ttip==null) 
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				return new ResponseEntity<>(new ModelAutomobilaDTO(ttip), HttpStatus.OK);
		}
		
		//POST
		//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="/modelAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ModelAutomobilaDTO> addTTipMenjaca(@RequestBody ModelAutomobilaDTO dto)  throws Exception {
			ModelAutomobila savedModelAuto = new ModelAutomobila();
			
			//Prilkom kreiranja novog modela automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
			commonData.setDatumKreiranja(now);
			commonData = comDataService.addCommonData(commonData);
			
			savedModelAuto.setId(dto.getId());
			savedModelAuto.setNazivModela(dto.getNazivModela());
			savedModelAuto.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
			savedModelAuto.setCommonDataId(commonData.getId());
			
//			a = accommodationClient.createNewAccommodation(a);
//			if (a != null) {
//				accommodationRepository.saveAndFlush(a);
//				return a.getId();
//			}
			
			savedModelAuto = modelAutoService.addModelAutomobila(savedModelAuto);
			return new ResponseEntity<>(new ModelAutomobilaDTO(savedModelAuto), HttpStatus.CREATED);
		}
		//PUT	
		@RequestMapping(method=RequestMethod.PUT, value="/modelAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ModelAutomobilaDTO> updateTTipMenjaca(@RequestBody ModelAutomobilaDTO dto) throws Exception{
			
			ModelAutomobila updModelAuto = modelAutoService.findOne(dto.getId());
			
			if(updModelAuto==null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			Long comDatId = updModelAuto.getCommonDataId();
			
			CommonData commonData = comDataService.findOne(comDatId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDatId, commonData);
			
			updModelAuto.setId(dto.getId());
			updModelAuto.setNazivModela(dto.getNazivModela());
			updModelAuto.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
			updModelAuto.setCommonDataId(commonData.getId());
			
			//cmdUpd.setKorisnik(usrServ.findOne(user_id));	//dodaj korisnika
			
			updModelAuto = modelAutoService.updateModelAutomobila(updModelAuto.getId(), updModelAuto);
			return new ResponseEntity<>(new ModelAutomobilaDTO(updModelAuto), HttpStatus.OK);	
		}
		//DELET	
		@RequestMapping(value="/modelAutomobila/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteModelAutomobila(@PathVariable Long id) {
			ModelAutomobila modelAuta= modelAutoService.findOne(id);
			if (modelAuta != null) {
				modelAutoService.deleteModelAutomobila(id);
				comDataService.deleteCommonData(modelAuta.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}	
}
