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

import com.example.Messages.DTO.TKlasaAutomobilaDTO;
import com.example.Messages.DTO.TTipGorivaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TTipGorivaService;

@RestController
public class TTipGorivaController {
	
	@Autowired
	private TTipGorivaService ttGorivaService;
	@Autowired
	private CommonDataService comDataService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/TTipGoriva", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TTipGorivaDTO>> getAllTTipGoriva() {
		
		List<TTipGorivaDTO> lista=new ArrayList<>();
		for(TTipGoriva tg: ttGorivaService.getAllTTipGoriva()) {
			lista.add(new TTipGorivaDTO(tg));
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);	
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TTipGoriva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipGorivaDTO> getTTipGoriva(@PathVariable("id") Long id){
		TTipGoriva tip = ttGorivaService.findOne(id);
		if(tip==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new TTipGorivaDTO(tip), HttpStatus.OK);	
	}
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/TTipGoriva",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipGorivaDTO> addTTipGoriva(@RequestBody TTipGorivaDTO dto)  throws Exception {
		TTipGoriva savedTTipGoriva= new TTipGoriva();

		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedTTipGoriva.setId(dto.getId());
		savedTTipGoriva.setNazivTipa(dto.getNazivTipa());
		savedTTipGoriva.setCommonDataId(commonData.getId());
		
		savedTTipGoriva =  ttGorivaService.addTTipGoriva(savedTTipGoriva);
		return new ResponseEntity<>(new TTipGorivaDTO(savedTTipGoriva), HttpStatus.CREATED);
	}
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TTipGoriva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipGorivaDTO> updateTTipMenjaca(@RequestBody TTipGorivaDTO dto) throws Exception{
		TTipGoriva updTTipGoriva  = (TTipGoriva) ttGorivaService.findOne(dto.getId());
		
		if(updTTipGoriva == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updTTipGoriva.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		 updTTipGoriva.setId(dto.getId());
		 updTTipGoriva.setNazivTipa(dto.getNazivTipa());
		 updTTipGoriva.setCommonDataId(comDatId);
		//PROVERITI COMMON DATA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		updTTipGoriva = ttGorivaService.updateTTipGoriva(updTTipGoriva.getId(), updTTipGoriva);
		return new ResponseEntity<>(new TTipGorivaDTO(updTTipGoriva), HttpStatus.OK);	
	}
	//DELET	
	@RequestMapping(value="/TTipGoriva/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTTipGoriva(@PathVariable Long id) {
		TTipGoriva ttip = ttGorivaService.findOne(id);
		if (ttip != null) {
			ttGorivaService.deleteTTipGoriva(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}			
}
