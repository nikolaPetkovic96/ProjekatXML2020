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

import com.example.Messages.DTO.TMarkaAutomobilaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TMarkaAutomobilaService;
//import com.example.Messages.service.TModelAutomobilaService;

@RestController
public class TMarkaAutomobilaController {
	@Autowired
	private TMarkaAutomobilaService tMarkaAutoservice;
	@Autowired 
	private CommonDataService cmdServ;
	

	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/TMarkaAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TMarkaAutomobilaDTO>> getAllTMarkaAutomobila() {
		List<TMarkaAutomobila> all = tMarkaAutoservice.getAllTMarkaAutomobila();
		
		List<TMarkaAutomobilaDTO> dto = new ArrayList<>();
		for(TMarkaAutomobila tm : all )
			dto.add(new TMarkaAutomobilaDTO(tm));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TMarkaAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TMarkaAutomobilaDTO> getTTMarkaAutomobila(@PathVariable("id") Long id){
		TMarkaAutomobila ttip = tMarkaAutoservice.findOne(id);
			if(ttip==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TMarkaAutomobilaDTO(ttip), HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/TMarkaAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TMarkaAutomobilaDTO> addTMarkaAutomobila(@RequestBody TMarkaAutomobilaDTO dto)  throws Exception {
		TMarkaAutomobila savedTMarkaAut = new TMarkaAutomobila();
		
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData = cmdServ.addCommonData(commonData);
		
		savedTMarkaAut.setId(dto.getId());
		savedTMarkaAut.setNazivMarke(dto.getNazivMarke());
		savedTMarkaAut.setCommonDataId(commonData.getId());

		//saved.getCommonData().setDatumKreiranja(Timestamp.valueOf(LocalDateTime.now()));
		//saved.getCommonData().setKorisnik(token_korisnika););//todo	korisnik
		
		savedTMarkaAut = tMarkaAutoservice.addTMarkaAutomobila(savedTMarkaAut);
		return new ResponseEntity<>(new TMarkaAutomobilaDTO(savedTMarkaAut), HttpStatus.CREATED);
	}
	
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TMarkaAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TMarkaAutomobilaDTO> updateTMarkaAutomobila(@RequestBody TMarkaAutomobilaDTO dto) throws Exception{
		TMarkaAutomobila updTMarkaAuto = tMarkaAutoservice.findOne(dto.getId());
		
		if(updTMarkaAuto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		updTMarkaAuto.setId(dto.getId());
		//upd.setModelAutomobila(modServ.findOne(dto.getModelAutomobila()));	//treba updejtovati modele
		updTMarkaAuto.setNazivMarke(dto.getNazivMarke());
		
		Long comDatId = updTMarkaAuto.getCommonDataId();
		CommonData commonData = cmdServ.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = cmdServ.updateCommonData(comDatId, commonData);
		
		updTMarkaAuto.setId(dto.getId());
		updTMarkaAuto.setNazivMarke(dto.getNazivMarke());
		updTMarkaAuto.setCommonDataId(updTMarkaAuto.getCommonDataId());
		//PROVERITI COMMON DATA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		updTMarkaAuto = tMarkaAutoservice.updateTMarkaAutomobila(updTMarkaAuto.getId(), updTMarkaAuto);
		return new ResponseEntity<>(new TMarkaAutomobilaDTO(updTMarkaAuto), HttpStatus.OK);	
	}
			
	//DELET	
	@RequestMapping(value="/TMarkaAutomobila/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTMarkaAutomobila(@PathVariable Long id) {
		TMarkaAutomobila ttip= tMarkaAutoservice.findOne(id);
		if (ttip != null) {
			tMarkaAutoservice.deleteTMarkaAutomobila(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
