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

import com.team32.AgentApp.DTO.KlasaAutomobilaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.KlasaAutomobila;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.KlasaAutomobilaService;


@RestController
public class KlasaAutomobilaController {
	@Autowired
	private KlasaAutomobilaService klasaAutservice;
	
	@Autowired
	private CommonDataService comDataService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/klasaAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KlasaAutomobilaDTO>> getAllKlasaAutomobila() {
		List<KlasaAutomobila> all = klasaAutservice.getAllKlasaAutomobila();
		
		List<KlasaAutomobilaDTO> dto = new ArrayList<>();
		for(KlasaAutomobila ka : all )
			dto.add(new KlasaAutomobilaDTO(ka));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/klasaAutomobila/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<KlasaAutomobilaDTO> getKlasaAutomobila(@PathVariable("id") Long id){
		KlasaAutomobila ka = klasaAutservice.findOne(id);
			if(ka ==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new KlasaAutomobilaDTO(ka), HttpStatus.OK);
	}
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/klasaAutomobila",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlasaAutomobilaDTO> addTKlasaAutomobila(@RequestBody KlasaAutomobilaDTO dto)  throws Exception {
		KlasaAutomobila savedKlasAut = new KlasaAutomobila();
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedKlasAut.setId(dto.getId());
		savedKlasAut.setNazivKlase(dto.getNazivKlase());
		savedKlasAut.setCommonDataId(commonData.getId());
		
		savedKlasAut = klasaAutservice.addKlasaAutomobila(savedKlasAut);
		return new ResponseEntity<>(new KlasaAutomobilaDTO(savedKlasAut), HttpStatus.CREATED);
	}
	
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/klasaAutomobila", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlasaAutomobilaDTO> updateTKlasaAutomoibila(@RequestBody KlasaAutomobilaDTO dto) throws Exception{
		
		KlasaAutomobila updKlasAut = (KlasaAutomobila) klasaAutservice.findOne(dto.getId());
		if(updKlasAut==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updKlasAut.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updKlasAut.setId(dto.getId());
		updKlasAut.setNazivKlase(dto.getNazivKlase());
		updKlasAut.setCommonDataId(comDatId);
		
		
		updKlasAut = klasaAutservice.updateKlasaAutomobila(updKlasAut.getId(), updKlasAut);
		return new ResponseEntity<>(new KlasaAutomobilaDTO(updKlasAut), HttpStatus.OK);	
	}
			
	//DELET	
	@RequestMapping(value="/klasaAutomobila/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKlasaAutomobila(@PathVariable Long id) {
		KlasaAutomobila klasaAuta= klasaAutservice.findOne(id);
		if (klasaAuta != null) {
			klasaAutservice.deleteKlasaAutomobila(id);
			comDataService.deleteCommonData(klasaAuta.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
