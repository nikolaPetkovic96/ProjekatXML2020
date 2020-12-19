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

import com.team32.AgentApp.DTO.NarudzbenicaDTO;
import com.team32.AgentApp.DTO.NarudzbenicaNewDTO;

import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Narudzbenica;

import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.NarudzbenicaService;


@RestController
public class NarudzbenicaController {
	
	@Autowired
	private NarudzbenicaService narudzbService;
	@Autowired
	private CommonDataService comDataService;

	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/narudzbenica", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NarudzbenicaDTO>> getAllNarudzbenica() {
		List<Narudzbenica> narudzbenice = narudzbService.getAllNarudzbenica();
		List<NarudzbenicaDTO> narudzbeniceDTO = new ArrayList<>();
		for(Narudzbenica nar : narudzbenice) {
			
			NarudzbenicaDTO narDTO = narudzbService.getNarudzbFullDetails(nar);
			if(narDTO == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			narudzbeniceDTO.add(narDTO);
		}
		
		return new ResponseEntity<>(narudzbeniceDTO, HttpStatus.OK);
	
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/narudzbenica/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<NarudzbenicaDTO> getNarudzbenica(@PathVariable("id") Long id){
		
		Narudzbenica nar = narudzbService.findOne(id);
		if(nar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		NarudzbenicaDTO narDTO = narudzbService.getNarudzbFullDetails(nar);
		if(narDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(narDTO, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/narudzbenica",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NarudzbenicaNewDTO> addNarudzbenica(@RequestBody NarudzbenicaNewDTO dto)  throws Exception {
		Narudzbenica savedNarudzb = new Narudzbenica();
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedNarudzb.setId(dto.getId());
		savedNarudzb.setAgentId(dto.getAgentId()); 			//Preuzeto iz oglasa kako se lakse manipulisalo objektima...
		savedNarudzb.setOglasId(dto.getOglasId());
		savedNarudzb.setRezervacijaId(dto.getRezervacijaId());
		savedNarudzb.setUserId(dto.getUserId()); 			//iz common Data videti da li i treba...
		savedNarudzb.setOdDatuma(dto.getOdDatuma());
		savedNarudzb.setDoDatuma(dto.getDoDatuma());
		savedNarudzb.setCommonDataId(commonData.getId());
		
		savedNarudzb = narudzbService.addNarudzbenica(savedNarudzb);
		return new ResponseEntity<>(new NarudzbenicaNewDTO(savedNarudzb), HttpStatus.CREATED);
	}
	
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/narudzbenica", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NarudzbenicaNewDTO> updateNarudzbenica(@RequestBody NarudzbenicaNewDTO dto) throws Exception{
		
		Narudzbenica updNarudzb = (Narudzbenica) narudzbService.findOne(dto.getId());
		if(updNarudzb ==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updNarudzb.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updNarudzb.setId(dto.getId());
		updNarudzb.setAgentId(dto.getAgentId());
		updNarudzb.setOglasId(dto.getOglasId());
		updNarudzb.setRezervacijaId(dto.getRezervacijaId());
		updNarudzb.setUserId(dto.getUserId()); 			//iz common Data videti da li i treba
		updNarudzb.setOdDatuma(dto.getOdDatuma());
		updNarudzb.setDoDatuma(dto.getDoDatuma());
		updNarudzb.setCommonDataId(comDatId);		
		
		updNarudzb = narudzbService.updateNarudzbenica(updNarudzb.getId(), updNarudzb);
		return new ResponseEntity<>(new NarudzbenicaNewDTO(updNarudzb), HttpStatus.OK);	
	}
			
	//DELET	
	@RequestMapping(value="/narudzbenica/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteNarudzbenica(@PathVariable Long id) {
		Narudzbenica narudzb = narudzbService.findOne(id);
		if (narudzb != null) {
			narudzbService.deleteNarudzbenica(id);
			comDataService.deleteCommonData(narudzb.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
	
}
