package com.team32.AgentApp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.CommonDataDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.service.CommonDataService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class CommonDataController {
	
	@Autowired
	private CommonDataService commonDataService;
	
	@RequestMapping(method=RequestMethod.GET, value="/commonData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommonDataDTO>> getAllCommonData(){
		List<CommonData> allCommonData = commonDataService.getAllCommonData();
		List<CommonDataDTO> commonDataDTO = new ArrayList<>();
		for(CommonData c : allCommonData) {
			commonDataDTO.add(new CommonDataDTO(c));
		}
		return new ResponseEntity<>(commonDataDTO, HttpStatus.OK);
 	}

	@RequestMapping(method=RequestMethod.GET, value="/commonData/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonDataDTO> getCommonData(@PathVariable("id") Long id){
		CommonData cd = commonDataService.findOne(id);
		if(cd == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CommonDataDTO(cd), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/commonData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonDataDTO> addCommonData(@RequestBody CommonDataDTO cdDTO) throws Exception{
		if(cdDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		CommonData savedCD = new CommonData();
		
		savedCD.setId(cdDTO.getId());
		savedCD.setDatumIzmene(cdDTO.getDatumIzmene());
		savedCD.setDatumKreiranja(cdDTO.getDatumKreiranja());
		savedCD.setUserId(cdDTO.getUserId());
		
		savedCD = commonDataService.addCommonData(savedCD);//cuva adresu u bazi i ponovo je dodeljuje samoj sebi
		return new ResponseEntity<>(new CommonDataDTO(savedCD), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/commonData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonDataDTO> updateCommonData(@RequestBody CommonDataDTO commonDataDTO) throws Exception{
		
		CommonData updatedCD = commonDataService.findOne(commonDataDTO.getId());
		if(updatedCD == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedCD.setId(commonDataDTO.getId());
		updatedCD.setDatumIzmene(commonDataDTO.getDatumIzmene());
		updatedCD.setDatumKreiranja(commonDataDTO.getDatumKreiranja());
		
		updatedCD = commonDataService.updateCommonData(updatedCD.getId(),updatedCD);
		return new ResponseEntity<>(new CommonDataDTO(updatedCD), HttpStatus.OK);
	}
	
	@RequestMapping(value="/commonData/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCommonData(@PathVariable Long id){
		CommonData commonData = commonDataService.findOne(id);
		if(commonData != null) {
			commonDataService.deleteCommonData(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}