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

import com.team32.AgentApp.DTO.PorukaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Poruka;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.PorukaService;
import com.team32.AgentApp.service.UserService;

@RestController
public class PorukaController {
	
	@Autowired 
	private PorukaService porukaService;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private UserService userService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/poruka", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PorukaDTO>> getAllPoruka(){
		
		List<Poruka> allPoruka = porukaService.getAllPoruka();
		
		List<PorukaDTO> porukeDTO = new ArrayList<>();
		for (Poruka p : allPoruka) {
			
			PorukaDTO porukaDTO = new PorukaDTO();
			CommonData comData = comDataService.findOne(p.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			User user = userService.findOne(comData.getUserid());
			porukaDTO.setUsername(user.getKorisnickoIme());
			porukaDTO.setId(p.getId());
			porukaDTO.setAutomobilId(p.getAutomobilId());
			porukaDTO.setRezervacijaId(p.getRezervacijaId());
			porukaDTO.setCommonDataId(p.getCommonDataId());
			porukaDTO.setTekstPoruke(p.getTekstPoruke());
			
			porukeDTO.add(porukaDTO);
		}
		// convert komentar to DTOs
		return new ResponseEntity<>(porukeDTO, HttpStatus.OK);
	}
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/poruka/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorukaDTO> getPoruka(@PathVariable("id") Long id){
		PorukaDTO porukaDTO = new PorukaDTO();
		Poruka poruka = porukaService.findOne(id);
		
		if (poruka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CommonData comData = comDataService.findOne(poruka.getCommonDataId());
		
		if(comData == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		User user = userService.findOne(comData.getUserid());
		porukaDTO.setUsername(user.getKorisnickoIme());
		porukaDTO.setId(poruka.getId());
		porukaDTO.setAutomobilId(poruka.getAutomobilId());
		porukaDTO.setRezervacijaId(poruka.getRezervacijaId());
		porukaDTO.setCommonDataId(poruka.getCommonDataId());
		porukaDTO.setTekstPoruke(poruka.getTekstPoruke());
		
		return new ResponseEntity<>(porukaDTO, HttpStatus.OK);
	}

	//POST
	@RequestMapping(method=RequestMethod.POST, value="/poruka",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorukaDTO> addPoruka(@RequestBody PorukaDTO porukaDTO)  throws Exception {
		
		Poruka savedPoruka = new Poruka();
		
		//Prilkom kreiranja novog komentara odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = comDataService.addCommonData(commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		savedPoruka.setId(porukaDTO.getId());
		savedPoruka.setTekstPoruke(porukaDTO.getTekstPoruke());
		savedPoruka.setAutomobilId(porukaDTO.getAutomobilId());
		savedPoruka.setRezervacijaId(porukaDTO.getRezervacijaId());
		savedPoruka.setCommonDataId(commonData.getId());
		
		savedPoruka = porukaService.addPoruka(savedPoruka);
		
		return new ResponseEntity<>(new PorukaDTO(savedPoruka, user.getKorisnickoIme(), commonData.getDatumKreiranja()), HttpStatus.CREATED);
	}
		
	@RequestMapping(method=RequestMethod.PUT, value="/poruka", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorukaDTO> updatePoruka(@RequestBody PorukaDTO porukaDTO) throws Exception{
		
		Poruka updatedPoruka = porukaService.findOne(porukaDTO.getId());
		if(updatedPoruka == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updatedPoruka.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		updatedPoruka.setId(porukaDTO.getId());
		updatedPoruka.setTekstPoruke(porukaDTO.getTekstPoruke());
//		updatedPoruka.setAutomobilId(porukaDTO.getAutomobilId());
//		updatedPoruka.setRezervacijaId(porukaDTO.getRezervacijaId());
		updatedPoruka.setCommonDataId(commonData.getId());
		
		
		updatedPoruka = porukaService.updatePoruka(updatedPoruka.getId(), updatedPoruka);
		
		return new ResponseEntity<>(new PorukaDTO(updatedPoruka,user.getKorisnickoIme(),commonData.getDatumKreiranja()),HttpStatus.OK);
	}

	@RequestMapping(value="/poruka/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePoruka(@PathVariable Long id){
		Poruka poruka = porukaService.findOne(id);
		if(poruka != null) {
			porukaService.deletePoruka(id);
			comDataService.deleteCommonData(poruka.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
