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

import com.team32.AgentApp.DTO.TipMenjacaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.TipMenjaca;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.TipMenjacaService;


/**
 * Created by oneclicklabs.io
 */
@RestController
public class TipMenjacaController {

	@Autowired
	private TipMenjacaService menjacaService;
	@Autowired
	private CommonDataService comDataService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/tipMenjaca", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipMenjacaDTO>> getAllTipMenjaca() {
		List<TipMenjaca> all = menjacaService.getAllTipMenjaca();
		
		List<TipMenjacaDTO> dto = new ArrayList<>();
		for(TipMenjaca tm : all )
			dto.add(new TipMenjacaDTO(tm));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/tipMenjaca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TipMenjacaDTO> getTipMenjaca(@PathVariable("id") Long id){
			TipMenjaca ttip = menjacaService.findOne(id);
			if(ttip==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new TipMenjacaDTO(ttip), HttpStatus.OK);
	}
	//POST
	//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/tipMenjaca",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipMenjacaDTO> addTipMenjaca(@RequestBody TipMenjacaDTO dto)  throws Exception {
		TipMenjaca savedTipMenjaca = new TipMenjaca();
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedTipMenjaca.setId(dto.getId());
		savedTipMenjaca.setNazivMenjaca(dto.getNazivMenjaca());
		savedTipMenjaca.setCommonDataId(commonData.getId());
		
		savedTipMenjaca = menjacaService.addTipMenjaca(savedTipMenjaca);
		return new ResponseEntity<>(new TipMenjacaDTO(savedTipMenjaca), HttpStatus.CREATED);

	}
	//PUT	
	@RequestMapping(method=RequestMethod.PUT, value="/tipMenjaca", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipMenjacaDTO> updateTipMenjaca(@RequestBody TipMenjacaDTO dto) throws Exception{
		
		TipMenjaca updTipMenajca = (TipMenjaca) menjacaService.findOne(dto.getId());
		if(updTipMenajca == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updTipMenajca.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updTipMenajca.setId(dto.getId());
		updTipMenajca.setNazivMenjaca(dto.getNazivMenjaca());
		updTipMenajca.setCommonDataId(comDatId);		
		
		updTipMenajca = menjacaService.updateTipMenjaca(updTipMenajca.getId(), updTipMenajca);
		return new ResponseEntity<>(new TipMenjacaDTO(updTipMenajca), HttpStatus.OK);	
	}
	//DELET	
	@RequestMapping(value="/tipMenjaca/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTipMenjaca(@PathVariable Long id) {
		TipMenjaca tipMenjaca = menjacaService.findOne(id);
		if (tipMenjaca != null) {
			menjacaService.deleteTipMenjaca(id);
			comDataService.deleteCommonData(tipMenjaca.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
}
