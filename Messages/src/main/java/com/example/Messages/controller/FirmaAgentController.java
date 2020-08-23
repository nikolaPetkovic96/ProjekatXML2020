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

import com.example.Messages.DTO.FirmaAgentDTO;
import com.example.Messages.DTO.FirmaDTO;
import com.example.Messages.SchemaToJava2.model.user.Firma;
import com.example.Messages.service.FirmaService;

@RestController
public class FirmaAgentController {
	@Autowired
	private FirmaService firmaService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/AgentFirma", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FirmaAgentDTO>> getAllFirma() {
	
		List<Firma> sviFirmaIAgent = firmaService.getAllFirma();
		List<Firma> samoAgent = new ArrayList<Firma>();
		for (Firma f : sviFirmaIAgent) {
			if(f.getJmbg() == null) {
				continue;
			}
			else {
				samoAgent.add(f);
			}
		}
	
		List<FirmaAgentDTO> agentDTO = new ArrayList<>();
		for (Firma f : samoAgent) {
			agentDTO.add(new FirmaAgentDTO(f));
		}
		// convert firme to DTOs
		return new ResponseEntity<>(agentDTO, HttpStatus.OK);

	}
	
	//GET
	//@PreAuthorize("hasRole('PACIJENT')")
	@RequestMapping(method=RequestMethod.GET, value="/AgentFirma/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaAgentDTO> getFirma(@PathVariable("id") Long id){
		
		Firma firma = firmaService.findOne(id);
		//return radnikService.getRadnik(id);
		if (firma  == null || firma.getJmbg() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new FirmaAgentDTO(firma), HttpStatus.OK);
		
	}
	
	//POST
	//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/AgentFirma",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaAgentDTO> addFirma(@RequestBody FirmaAgentDTO firmaAgentDTO)  throws Exception {
		
		if (firmaAgentDTO .getJmbg() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Firma savedFirmaAgent = new Firma();
					
		savedFirmaAgent.setIme(firmaAgentDTO.getIme());			
		savedFirmaAgent.setPrezime(firmaAgentDTO.getPrezime());		
		savedFirmaAgent.setJmbg(firmaAgentDTO.getJmbg());		
		
		savedFirmaAgent = firmaService.addFirma(savedFirmaAgent);
		return new ResponseEntity<>(new FirmaAgentDTO(savedFirmaAgent), HttpStatus.CREATED);
	}
	
	//PUT
	@RequestMapping(method=RequestMethod.PUT, value="/AgentFirma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaAgentDTO> updateFirma(@RequestBody FirmaAgentDTO firmaAgentDTO) throws Exception{
		
		System.out.println("Usao u update profile!");
		Firma updatedFirmaAgent = firmaService.findOne(firmaAgentDTO.getId());
		
		if (updatedFirmaAgent == null || updatedFirmaAgent.getJmbg() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// we allow changing date and points for an pacijent only
		updatedFirmaAgent.setIme(firmaAgentDTO.getIme());			
		updatedFirmaAgent.setPrezime(firmaAgentDTO.getPrezime());		
		updatedFirmaAgent.setJmbg(firmaAgentDTO.getJmbg());		
		
		//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
		updatedFirmaAgent = firmaService.updateFirma(updatedFirmaAgent.getId(), updatedFirmaAgent);
		return new ResponseEntity<>(new FirmaAgentDTO(updatedFirmaAgent), HttpStatus.OK);
	}
	
	//DELET	isti kao i za Firmu moze se i obrisati...
	@RequestMapping(value="/AgentFirma/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFirma(@PathVariable Long id) {
		
		Firma firma = firmaService.findOne(id);
		if (firma != null && firma.getJmbg() != null) {
			firmaService.deleteFirma(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
