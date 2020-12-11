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

import com.team32.AgentApp.DTO.MarkaAutomobilaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.MarkaAutomobila;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.MarkaAutomobilaService;


@RestController
public class MarkaAutomobilaController {
	@Autowired
	private MarkaAutomobilaService markaAutoservice;
	
	@Autowired
	private CommonDataService comDataService;
	

	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/markaAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MarkaAutomobilaDTO>> getAllMarkaAutomobila() {
		List<MarkaAutomobila> all = markaAutoservice.getAllMarkaAutomobila();
		
		List<MarkaAutomobilaDTO> dto = new ArrayList<>();
		for(MarkaAutomobila ma : all )
			dto.add(new MarkaAutomobilaDTO(ma));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/markaAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<MarkaAutomobilaDTO> getMarkaAutomobila(@PathVariable("id") Long id){
		MarkaAutomobila marka = markaAutoservice.findOne(id);
			if(marka==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new MarkaAutomobilaDTO(marka), HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/markaAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MarkaAutomobilaDTO> addMarkaAutomobila(@RequestBody MarkaAutomobilaDTO dto)  throws Exception {
		MarkaAutomobila savedMarkaAut = new MarkaAutomobila();
		
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
		
		savedMarkaAut.setId(dto.getId());
		savedMarkaAut.setNazivMarke(dto.getNazivMarke());
		savedMarkaAut.setCommonDataId(commonData.getId());
		
		savedMarkaAut = markaAutoservice.addMarkaAutomobila(savedMarkaAut);
		return new ResponseEntity<>(new MarkaAutomobilaDTO(savedMarkaAut), HttpStatus.CREATED);
	}
	
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/markaAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MarkaAutomobilaDTO> updateMarkaAutomobila(@RequestBody MarkaAutomobilaDTO dto) throws Exception{
		MarkaAutomobila updMarkaAuto = markaAutoservice.findOne(dto.getId());
		
		if(updMarkaAuto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		updMarkaAuto.setId(dto.getId());
		updMarkaAuto.setNazivMarke(dto.getNazivMarke());
		
		Long comDatId = updMarkaAuto.getCommonDataId();
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updMarkaAuto.setId(dto.getId());
		updMarkaAuto.setNazivMarke(dto.getNazivMarke());
		updMarkaAuto.setCommonDataId(updMarkaAuto.getCommonDataId());
		
		updMarkaAuto = markaAutoservice.updateMarkaAutomobila(updMarkaAuto.getId(), updMarkaAuto);
		return new ResponseEntity<>(new MarkaAutomobilaDTO(updMarkaAuto), HttpStatus.OK);	
	}
			
	//DELET	
	@RequestMapping(value="/markaAutomobila/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteMarkaAutomobila(@PathVariable Long id) {
		MarkaAutomobila markaAuta= markaAutoservice.findOne(id);
		if (markaAuta != null) {
			markaAutoservice.deleteMarkaAutomobila(id);						//brisanje objekta marka automobila
			comDataService.deleteCommonData(markaAuta.getCommonDataId());	//brisanje commonData objekata vezanog za marka autombila
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
