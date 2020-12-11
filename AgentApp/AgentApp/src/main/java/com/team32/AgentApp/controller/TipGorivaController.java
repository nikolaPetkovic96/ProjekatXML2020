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

import com.team32.AgentApp.DTO.TipGorivaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.TipGoriva;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.TipGorivaService;

@RestController
public class TipGorivaController {
	
	@Autowired
	private TipGorivaService gorivaService;
	
	@Autowired
	private CommonDataService comDataService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/tipGoriva", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipGorivaDTO>> getAllTipGoriva() {
		
		List<TipGorivaDTO> lista=new ArrayList<>();
		for(TipGoriva tg: gorivaService.getAllTipGoriva()) {
			lista.add(new TipGorivaDTO(tg));
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);	
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/tipGoriva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipGorivaDTO> getTipGoriva(@PathVariable("id") Long id){
		TipGoriva tip = gorivaService.findOne(id);
		if(tip==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new TipGorivaDTO(tip), HttpStatus.OK);	
	}
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/tipGoriva",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipGorivaDTO> addTipGoriva(@RequestBody TipGorivaDTO dto)  throws Exception {
		TipGoriva savedTipGoriva = new TipGoriva();

		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedTipGoriva.setId(dto.getId());
		savedTipGoriva.setNazivTipa(dto.getNazivTipa());
		savedTipGoriva.setCommonDataId(commonData.getId());
		
		savedTipGoriva = gorivaService.addTipGoriva(savedTipGoriva);
		return new ResponseEntity<>(new TipGorivaDTO(savedTipGoriva), HttpStatus.CREATED);
	}
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/tipGoriva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipGorivaDTO> updateTipGoriva(@RequestBody TipGorivaDTO dto) throws Exception{
		TipGoriva updTipGoriva  = (TipGoriva) gorivaService.findOne(dto.getId());
		
		if(updTipGoriva == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updTipGoriva.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updTipGoriva.setId(dto.getId());
		updTipGoriva.setNazivTipa(dto.getNazivTipa());
		updTipGoriva.setCommonDataId(comDatId);
		
		updTipGoriva = gorivaService.updateTipGoriva(updTipGoriva.getId(), updTipGoriva);
		return new ResponseEntity<>(new TipGorivaDTO(updTipGoriva), HttpStatus.OK);	
	}
	//DELET	
	@RequestMapping(value="/tipGoriva/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTipGoriva(@PathVariable Long id) {
		TipGoriva tipGoriva = gorivaService.findOne(id);
		if (tipGoriva != null) {
			gorivaService.deleteTipGoriva(id);
			comDataService.deleteCommonData(tipGoriva.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}			
}
