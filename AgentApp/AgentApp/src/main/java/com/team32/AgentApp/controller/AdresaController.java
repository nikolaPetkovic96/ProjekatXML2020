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

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.service.AdresaService;
import com.team32.AgentApp.service.CommonDataService;


@RestController
public class AdresaController {
	
	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private CommonDataService comDataService;
		
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/adresa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdresaDTO>> getAllAdresa() {
		
		List<AdresaDTO> adresaDTO = new ArrayList<AdresaDTO>();
		
		for(Adresa ta : adresaService.getAllAdresa()) {
			adresaDTO.add(new AdresaDTO(ta));
		}
		return new ResponseEntity<>(adresaDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/adresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdresaDTO> getAdresa(@PathVariable("id") Long id){
			
			Adresa adresa = adresaService.findOne(id);
			//return radnikService.getRadnik(id);
			if (adresa == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(new AdresaDTO(adresa), HttpStatus.OK);			
		}
		//POST
		//Ovo kaze metoda addTAdresa hendla svaki zahtev sa url '/TAdresa' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="/adresa",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<AdresaDTO> addAdresa(@RequestBody AdresaDTO dto)  throws Exception {
			Adresa savedAdr = new Adresa();
			
			//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setUserId((long) 1);
			commonData.setDatumKreiranja(now);
			commonData = comDataService.addCommonData(commonData);
			
			savedAdr.setId(dto.getId());
			savedAdr.setBroj(dto.getBroj());
			savedAdr.setMesto(dto.getMesto());
			savedAdr.setPostanskiBroj(dto.getPostanskiBroj());
			savedAdr.setUlica(dto.getUlica());
			savedAdr.setOglasId(dto.getOglasId());
			savedAdr.setCommonDataId(commonData.getId());
			
			savedAdr = adresaService.addAdresa(savedAdr);//cuva adresu u bazi i ponovo je dodeljuje samoj sebi
			return new ResponseEntity<>(new AdresaDTO(savedAdr), HttpStatus.CREATED);
		}
		//PUT
		@RequestMapping(method=RequestMethod.PUT, value="/adresa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<AdresaDTO> updateAdresa(@RequestBody AdresaDTO dto) throws Exception{
			Adresa updAdresa = adresaService.findOne(dto.getId());
			if(updAdresa == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			Long comDatId = updAdresa.getCommonDataId();
			
			CommonData commonData = comDataService.findOne(comDatId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDatId, commonData);
			
			updAdresa.setId(dto.getId());
			updAdresa.setBroj(dto.getBroj());
			updAdresa.setMesto(dto.getMesto());
			updAdresa.setPostanskiBroj(dto.getPostanskiBroj());
			updAdresa.setUlica(dto.getUlica());
			updAdresa.setOglasId(dto.getOglasId());
			updAdresa.setCommonDataId(commonData.getId());
			
			updAdresa = adresaService.updateAdresa(updAdresa.getId(), updAdresa);
			return new ResponseEntity<>(new AdresaDTO(updAdresa), HttpStatus.OK);
		}
		//DELET	
		@RequestMapping(value="/adresa/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
			
			Adresa adr = adresaService.findOne(id);
			if (adr != null) {
				adresaService.deleteAdresa(id);
				comDataService.deleteCommonData(adr.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}
}
