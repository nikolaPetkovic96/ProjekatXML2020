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
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TKlasaAutomobilaService;

@RestController
public class TKlasaAutomobilaController {
	@Autowired
	private TKlasaAutomobilaService tKlasAutservice;
	
	@Autowired
	private CommonDataService comDataService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/TKlasaAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TKlasaAutomobilaDTO>> getAllKlasaAutomobila() {
		List<TKlasaAutomobila> all = tKlasAutservice.getAllTKlasaAutomobila();
		
		List<TKlasaAutomobilaDTO> dto = new ArrayList<>();
		for(TKlasaAutomobila tm : all )
			dto.add(new TKlasaAutomobilaDTO(tm));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TKlasaAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TKlasaAutomobilaDTO> getTKlasaAutomobila(@PathVariable("id") Long id){
		TKlasaAutomobila tka = tKlasAutservice.findOne(id);
			if(tka ==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TKlasaAutomobilaDTO(tka), HttpStatus.OK);
	}
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/TKlasaAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TKlasaAutomobilaDTO> addTKlasaAutomoibila(@RequestBody TKlasaAutomobilaDTO dto)  throws Exception {
		TKlasaAutomobila savedTKlasAut = new TKlasaAutomobila();
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedTKlasAut.setId(dto.getId());
		savedTKlasAut.setNazivKlase(dto.getNazivKlase());
		savedTKlasAut.setCommonDataId(commonData.getId());
		
		savedTKlasAut = tKlasAutservice.addTKlasaAutomobila(savedTKlasAut );
		return new ResponseEntity<>(new TKlasaAutomobilaDTO(savedTKlasAut ), HttpStatus.CREATED);
	}
	
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TKlasaAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TKlasaAutomobilaDTO> updateTKlasaAutomoibila(@RequestBody TKlasaAutomobilaDTO dto) throws Exception{
		
		TKlasaAutomobila updTKlasAut = (TKlasaAutomobila) tKlasAutservice.findOne(dto.getId());
		if(updTKlasAut==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updTKlasAut.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updTKlasAut.setId(dto.getId());
		updTKlasAut.setNazivKlase(dto.getNazivKlase());
		updTKlasAut.setCommonDataId(comDatId);
		//PROVERITI COMMON DATA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		updTKlasAut = tKlasAutservice.updateTKlasaAutomobila(updTKlasAut.getId(), updTKlasAut);
		return new ResponseEntity<>(new TKlasaAutomobilaDTO(updTKlasAut), HttpStatus.OK);	
	}
			
	//DELET	
	@RequestMapping(value="/TKlasaAutomobila/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTKlasaAutomobila(@PathVariable Long id) {
		TKlasaAutomobila tka= tKlasAutservice.findOne(id);
		if (tka != null) {
			tKlasAutservice.deleteTKlasaAutomobila(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
