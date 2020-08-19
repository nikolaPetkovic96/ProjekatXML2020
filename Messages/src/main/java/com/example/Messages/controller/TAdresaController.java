package com.example.Messages.controller;

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

import com.example.Messages.DTO.TAdresaDTO;
import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;
import com.example.Messages.service.TAdresaService;


@RestController
public class TAdresaController {
	
	@Autowired
	private TAdresaService TAdresaService;
		
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/TAdresa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TAdresaDTO>> getAllTAdresa() {
		
		List<TAdresaDTO> tadresaDTO=new ArrayList<TAdresaDTO>();
		
		for(TAdresa ta : TAdresaService.getAllTAdresa()) {
			tadresaDTO.add(new TAdresaDTO(ta));
		}
		return new ResponseEntity<>(tadresaDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/TAdresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TAdresaDTO> getTAdresa(@PathVariable("id") Long id){
			
			TAdresa adresa = TAdresaService.findOne(id);
			//return radnikService.getRadnik(id);
			if (adresa == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(new TAdresaDTO(adresa), HttpStatus.OK);			
		}
		//POST
		//Ovo kaze metoda addTAdresa hendla svaki zahtev sa url '/TAdresa' koji ima http zahtev POST:
		@RequestMapping(method=RequestMethod.POST, value="/TAdresa",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TAdresaDTO> addTAdresa(@RequestBody TAdresaDTO tadresaDTO)  throws Exception {
			TAdresa savedAdr = new TAdresa();
			
			savedAdr.setId(tadresaDTO.getId());
			savedAdr.setBroj(tadresaDTO.getBroj());
			savedAdr.setMesto(tadresaDTO.getMesto());
			savedAdr.setPostanskiBroj(tadresaDTO.getPostanskiBroj());
			savedAdr.setUlica(tadresaDTO.getUlica());
			savedAdr.setLatitude(tadresaDTO.getLatitude());
			savedAdr.setLongitude(tadresaDTO.getLongitude());		
			
			savedAdr=TAdresaService.addTAdresa(savedAdr);//cuva adresu u bazi i ponovo je dodeljuje samoj sebi
			return new ResponseEntity<>(new TAdresaDTO(savedAdr), HttpStatus.CREATED);
		}
		//PUT
		@RequestMapping(method=RequestMethod.PUT, value="/TAdresa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TAdresaDTO> updateTAdresa(@RequestBody TAdresaDTO dto) throws Exception{
			TAdresa upd=TAdresaService.findOne(dto.getId());
			if(upd==null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			upd.setId(dto.getId());
			upd.setBroj(dto.getBroj());
			upd.setMesto(dto.getMesto());
			upd.setPostanskiBroj(dto.getPostanskiBroj());
			upd.setUlica(dto.getUlica());
			
		
			upd.setLatitude(dto.getLatitude());
			upd.setLongitude(dto.getLongitude());	
			
			upd=TAdresaService.updateTAdresa(upd.getId(), upd);
			return new ResponseEntity<>(new TAdresaDTO(upd), HttpStatus.OK);
		}
		//DELET	
		@RequestMapping(value="/TAdresa/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
			
			TAdresa del = TAdresaService.findOne(id);
			if (del != null) {
				TAdresaService.deleteTAdresa(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}
}
