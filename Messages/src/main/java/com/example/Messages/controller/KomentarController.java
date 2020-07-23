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

import com.example.Messages.DTO.AdministratorDTO;
import com.example.Messages.DTO.CenovnikDTO;
import com.example.Messages.DTO.CommonDataDTO;
import com.example.Messages.DTO.KomentarDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Cenovnik;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.user.Administrator;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.KomentarService;

@RestController
public class KomentarController {

	@Autowired
	private CommonDataService cds;
	@Autowired
	private KomentarService komentarService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/Komentar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KomentarDTO>> getAllKomentar() {
	
		List<Komentar> allKomentar = komentarService.getAllKomentar();
		
		List<KomentarDTO> komentarDTO = new ArrayList<>();
		for (Komentar k : allKomentar) {
			komentarDTO.add(new KomentarDTO(k));
		}
		// convert komentar to DTOs
		return new ResponseEntity<>(komentarDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/Komentar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> getKomentar(@PathVariable("id") Long id){
		
		Komentar komentar = komentarService.findOne(id);
		if (komentar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new KomentarDTO(komentar), HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/Komentar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> addKomentar(@RequestBody KomentarDTO komentarDTO)  throws Exception {
		
		Komentar savedKomentar = new Komentar();
	
		savedKomentar.setId(komentarDTO.getId());
		savedKomentar.setTekstKomentara(komentarDTO.getTekstKomentara());
		savedKomentar.setOdobren(komentarDTO.isOdobren());
		savedKomentar.setCommonData(cds.findOne(komentarDTO.getId()));
		
		savedKomentar = komentarService.addKomentar(savedKomentar);
		
		return new ResponseEntity<>(new KomentarDTO(savedKomentar), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Komentar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> updateAutomobil(@RequestBody KomentarDTO komentarDTO) throws Exception{
		
		Komentar updatedKomentar = komentarService.findOne(komentarDTO.getId());
		if(updatedKomentar == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedKomentar.setId(komentarDTO.getId());
		updatedKomentar.setTekstKomentara(komentarDTO.getTekstKomentara());
		updatedKomentar.setOdobren(komentarDTO.isOdobren());
		updatedKomentar.setCommonData(cds.findOne(komentarDTO.getId()));
		
		updatedKomentar = komentarService.updateKomentar(updatedKomentar.getId(), updatedKomentar);
		 
		return new ResponseEntity<>(new KomentarDTO(updatedKomentar),HttpStatus.OK);
	}
	
	@RequestMapping(value="/Komentar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKomentar(@PathVariable Long id){
		Komentar komentar = komentarService.findOne(id);
		if(komentar != null) {
			komentarService.deleteKomentar(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
