package com.example.Messages.controller;

import java.sql.Timestamp;
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
import com.example.Messages.DTO.TTipMenjacaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.TTipMenjacaService;

/**
 * Created by oneclicklabs.io
 */
@RestController
public class TTipMenjacaController {

	@Autowired
	private TTipMenjacaService ttMenjacaService;
	@Autowired
	private CommonDataService comDataService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/TTipMenjaca", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TTipMenjacaDTO>> getAllTTIpMenjaca() {
		List<TTipMenjaca> all = ttMenjacaService.getAllTTipMenjaca();
		
		List<TTipMenjacaDTO> dto = new ArrayList<>();
		for(TTipMenjaca tm : all )
			dto.add(new TTipMenjacaDTO(tm));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TTipMenjaca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TTipMenjacaDTO> getTipMenjaca(@PathVariable("id") Long id){
			TTipMenjaca ttip = ttMenjacaService.findOne(id);
			if(ttip==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TTipMenjacaDTO(ttip), HttpStatus.OK);
	}
	//POST
	//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/TTipMenjaca",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipMenjacaDTO> addTTipMenjaca(@RequestBody TTipMenjacaDTO dto)  throws Exception {
		TTipMenjaca savedTTipMenjaca = new TTipMenjaca();
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedTTipMenjaca.setId(dto.getId());
		savedTTipMenjaca.setNazivMenjaca(dto.getNazivMenjaca());
		savedTTipMenjaca.setCommonDataId(commonData.getId());
		
		savedTTipMenjaca = ttMenjacaService.addTTipMenjaca(savedTTipMenjaca);
		return new ResponseEntity<>(new TTipMenjacaDTO(savedTTipMenjaca), HttpStatus.CREATED);

	}
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/TTipMenjaca", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TTipMenjacaDTO> updateTTipMenjaca(@RequestBody TTipMenjacaDTO dto) throws Exception{
		
		TTipMenjaca updTTipMenajca = (TTipMenjaca) ttMenjacaService.findOne(dto.getId());
		if(updTTipMenajca == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updTTipMenajca.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updTTipMenajca.setId(dto.getId());
		updTTipMenajca.setNazivMenjaca(dto.getNazivMenjaca());
		updTTipMenajca.setCommonDataId(comDatId);
		//PROVERITI COMMON DATA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		updTTipMenajca = ttMenjacaService.updateTTipMenjaca(updTTipMenajca.getId(), updTTipMenajca);
		return new ResponseEntity<>(new TTipMenjacaDTO(updTTipMenajca), HttpStatus.OK);	
	}
	//DELET	
	@RequestMapping(value="/TTipMenjaca/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTTipMenjaca(@PathVariable Long id) {
		TTipMenjaca ttip= ttMenjacaService.findOne(id);
		if (ttip != null) {
			ttMenjacaService.deleteTTipMenjaca(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
