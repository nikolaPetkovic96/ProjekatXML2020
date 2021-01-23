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

import com.team32.AgentApp.DTO.OcenaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Ocena;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.OcenaService;
import com.team32.AgentApp.service.UserService;

@RestController
public class OcenaController {

	@Autowired
	private OcenaService ocenaService;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private UserService userService;
	
	//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/ocena", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OcenaDTO>> getAllOcena() {
		
			List<Ocena> allOcena = ocenaService.getAllOcena();
			
			List<OcenaDTO> oceneDTO = new ArrayList<>();
			for (Ocena o : allOcena) {
				
				OcenaDTO ocenaDTO = new OcenaDTO();
				CommonData comData = comDataService.findOne(o.getCommonDataId());
				
				if(comData == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				User user = userService.findOne(comData.getUserid());
				ocenaDTO.setUsername(user.getKorisnickoIme());
				ocenaDTO.setId(o.getId());
				ocenaDTO.setAutomobilId(o.getAutomobilId());
				ocenaDTO.setRezervacijaId(o.getRezervacijaId());
				ocenaDTO.setCommonDataId(o.getCommonDataId());
				ocenaDTO.setVrednostOcene(o.getVrednostOcene());
				
				oceneDTO.add(ocenaDTO);
			}
			// convert komentar to DTOs
			return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
		}
	
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/ocena/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OcenaDTO> getOcena(@PathVariable("id") Long id){
			
			OcenaDTO ocenaDTO = new OcenaDTO();
			Ocena o = ocenaService.findOne(id);
			
			if (o == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			CommonData comData = comDataService.findOne(o.getCommonDataId());
			User user = userService.findOne(comData.getUserid());
			
			ocenaDTO.setUsername(user.getKorisnickoIme());
			ocenaDTO.setId(o.getId());
			ocenaDTO.setAutomobilId(o.getAutomobilId());
			ocenaDTO.setRezervacijaId(o.getRezervacijaId());
			ocenaDTO.setCommonDataId(o.getCommonDataId());
			ocenaDTO.setVrednostOcene(o.getVrednostOcene());
			
			return new ResponseEntity<>(ocenaDTO, HttpStatus.OK);
		}
	
	
	//POST
	//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/ocena",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OcenaDTO> addOcena(@RequestBody OcenaDTO ocenaDTO)  throws Exception {
		Ocena savedOcena = new Ocena();
			
		//Prilkom kreiranja novoe ocene odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = comDataService.addCommonData(commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		savedOcena.setId(ocenaDTO.getId());	
		savedOcena.setVrednostOcene(ocenaDTO.getVrednostOcene());
		savedOcena.setAutomobilId(ocenaDTO.getAutomobilId());
		savedOcena.setRezervacijaId(ocenaDTO.getRezervacijaId());
		savedOcena.setCommonDataId(commonData.getId());
		
		savedOcena  = ocenaService.addOcena(savedOcena);
		return new ResponseEntity<>(new OcenaDTO(savedOcena, user.getKorisnickoIme()), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/ocena", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OcenaDTO> updateOcena(@RequestBody OcenaDTO ocenaDTO) throws Exception{
		
		Ocena updatedOcena = ocenaService.findOne(ocenaDTO.getId());
		
		if (updatedOcena == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		

		Long comDatId = updatedOcena.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		updatedOcena.setId(ocenaDTO.getId());
		updatedOcena.setVrednostOcene(ocenaDTO.getVrednostOcene());	
//		updatedPoruka.setAutomobilId(porukaDTO.getAutomobilId());
//		updatedPoruka.setRezervacijaId(porukaDTO.getRezervacijaId());
		updatedOcena.setCommonDataId(comDatId);
		
		updatedOcena = ocenaService.updateOcena(updatedOcena.getId(), updatedOcena);
		return new ResponseEntity<>(new OcenaDTO(updatedOcena, user.getKorisnickoIme()), HttpStatus.OK);
		
	}
		 
	@RequestMapping(value="/ocena/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOcena(@PathVariable Long id) {
		
		Ocena ocena = ocenaService.findOne(id);
		if (ocena != null) {
			ocenaService.deleteOcena(id);
			comDataService.deleteCommonData(ocena.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
