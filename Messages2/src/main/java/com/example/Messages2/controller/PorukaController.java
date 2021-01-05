package com.example.Messages2.controller;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.dto.PorukaNewDTO;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.PorukaRepository;
import com.example.Messages2.service.PorukaService;
import com.example.Messages2.service.mapper.PorukaMapper;

@RestController
@RequestMapping(value = "/messsage")
public class PorukaController {
	@Autowired
	private PorukaService porService;
	@Autowired
	private PorukaRepository porRep;

	@GetMapping(value = "")
	public ResponseEntity<List<PorukaDTO>> getPoruke(	@RequestParam(name = "rez_id", required = false) Long rezId
			){	
		List<PorukaDTO> response=Collections.emptyList();
		if(rezId!=null)
			response=porService.getAllMessages(rezId);
		else
			response=porService.getAllMessages();
		
		if(response.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<PorukaDTO> getPoruka(	@PathVariable("id") Long id
			){
		PorukaDTO poruka= porService.getPoruka(id);
		if(poruka==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(poruka, HttpStatus.OK);
	}
	
	@PostMapping(value = "")
	public ResponseEntity<PorukaNewDTO> addPoruka(@RequestBody PorukaDTO por) {
		PorukaDTO poruka= porService.createPoruka(por);
		return new ResponseEntity<>(new PorukaNewDTO(porRep.getOne(poruka.getId())),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePoruka(	@PathVariable("id") Long id) {
		 Boolean obrisana=porService.deletePoruka(id);
		 if(obrisana)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

 
	}
	
	@PutMapping(value="")
	public ResponseEntity<PorukaNewDTO> updatePoruka(@RequestBody PorukaNewDTO poruka) throws Exception {
		PorukaNewDTO updated= porService.updatePoruka(poruka.getId(), poruka);
		if(updated==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(updated,HttpStatus.OK);
	}
	
//	@GetMapping(value="/all")
//	public List<PorukaDTO> getAllPoruke(){
//		return porService.getAllMessages();
//	}
}
