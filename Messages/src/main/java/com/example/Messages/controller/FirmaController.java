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

import com.example.Messages.DTO.FirmaDTO;

import com.example.Messages.SchemaToJava2.model.user.Firma;
import com.example.Messages.service.FirmaService;

@RestController
public class FirmaController {
	
	@Autowired
	private FirmaService firmaService;

	
	@RequestMapping(method=RequestMethod.GET, value="/FirmaTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTest() {
		return "Test";
	}
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/Firma", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FirmaDTO>> getAllFirma() {
	
		//Da vrati samo firme, a ne i agente;
		List<Firma> sviFirmaIAgent = firmaService.getAllFirma();
		List<Firma> samoFirma = new ArrayList<Firma>();
		for (Firma f : sviFirmaIAgent) {
			if(f.getPoslovniMaticniBroj() == null) {
				continue;
			}
			else {
				samoFirma.add(f);
			}
		}
	
		List<FirmaDTO> firmaDTO = new ArrayList<>();
		for (Firma f : samoFirma) {
			firmaDTO.add(new FirmaDTO(f));
		}
		// convert firme to DTOs
		return new ResponseEntity<>(firmaDTO, HttpStatus.OK);

	}
	
	//GET
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET, value="/Firma/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaDTO> getFirma(@PathVariable("id") Long id){
		
		Firma firma = firmaService.findOne(id);
		//return radnikService.getRadnik(id);
		if (firma  == null || firma.getPoslovniMaticniBroj() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new FirmaDTO(firma), HttpStatus.OK);
		
	}
	
	//POST
	//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/Firma",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaDTO> addFirma(@RequestBody FirmaDTO firmaDTO)  throws Exception {
		
		if (firmaDTO.getPoslovniMaticniBroj() == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Firma savedFirma = new Firma();
					
		savedFirma.setNaziv(firmaDTO.getNaziv());			
		savedFirma.setPoslovniMaticniBroj(firmaDTO.getPoslovniMaticniBroj());					
		
		savedFirma = firmaService.addFirma(savedFirma);
		return new ResponseEntity<>(new FirmaDTO(savedFirma), HttpStatus.CREATED);
	}
	
	//PUT
	@RequestMapping(method=RequestMethod.PUT, value="/Firma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaDTO> updateFirma(@RequestBody FirmaDTO firmaDTO) throws Exception{
		
		System.out.println("Usao u update profile!");
		Firma updatedFirma = firmaService.findOne(firmaDTO.getId());
		
		if (updatedFirma == null || updatedFirma.getPoslovniMaticniBroj() == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// we allow changing date and points for an pacijent only
		updatedFirma.setNaziv(firmaDTO.getNaziv());
		updatedFirma.setPoslovniMaticniBroj(firmaDTO.getPoslovniMaticniBroj());			
		
		//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
		updatedFirma = firmaService.updateFirma(updatedFirma.getId(), updatedFirma);
		return new ResponseEntity<>(new FirmaDTO(updatedFirma), HttpStatus.OK);
	}
	
	//DELET	
	@RequestMapping(value="/Firma/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFirma(@PathVariable Long id) {
		
		Firma firma = firmaService.findOne(id);
		if (firma != null && firma.getPoslovniMaticniBroj() != null) {
			firmaService.deleteFirma(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	
}