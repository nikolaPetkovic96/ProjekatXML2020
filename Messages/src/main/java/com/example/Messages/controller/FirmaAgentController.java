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

import com.example.Messages.DTO.FirmaAgentDTO;
import com.example.Messages.DTO.FirmaDTO;
import com.example.Messages.SchemaToJava2.model.user.Firma;
import com.example.Messages.service.FirmaService;
import com.example.Messages.service.KomentarService;
import com.example.Messages.service.OcenaService;
import com.example.Messages.service.PorukaService;

public class FirmaAgentController {
	@Autowired
	private FirmaService firmaService;
	
	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private OcenaService ocenaService;
	
	@Autowired
	private PorukaService porukaService;
	
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/AgentFirma", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FirmaAgentDTO>> getAllFirma() {
	
		List<Firma> allFirma = firmaService.getAllFirma();
		
		List<FirmaAgentDTO> firmaAgentDTO = new ArrayList<>();
		for (Firma f : allFirma) {
			firmaAgentDTO.add(new FirmaAgentDTO(f));
		}
		// convert pacijent to DTOs
		return new ResponseEntity<>(firmaAgentDTO, HttpStatus.OK);

	}
	
	//GET
	//@PreAuthorize("hasRole('PACIJENT')")
	@RequestMapping(method=RequestMethod.GET, value="/AgentFirma/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaAgentDTO> getFirma(@PathVariable("id") Long id){
		
		Firma firma = firmaService.findOne(id);
		//return radnikService.getRadnik(id);
		if (firma  == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new FirmaAgentDTO(firma), HttpStatus.OK);
		
	}
	
	//POST
	//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/AgentFirma",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaAgentDTO> addFirma(@RequestBody FirmaAgentDTO firmaAgentDTO)  throws Exception {
		
		Firma savedFirmaAgent = new Firma();
					
		savedFirmaAgent.setNaziv(firmaAgentDTO.getIme());			
		savedFirmaAgent.setPoslovniMaticniBroj(firmaAgentDTO.getPrezime());		
		savedFirmaAgent.setPoslovniMaticniBroj(firmaAgentDTO.getJmbg());		
		
//			List<KomentarDTO> komentarDTO = regKorisnikDTO.getKomentar();
//			ArrayList<Komentar> komentari = new ArrayList<Komentar>();
//			//prebacivanje iz DTO u model
//			for (KomentarDTO k : komentarDTO) {
//				komentari.add(komentarService.findOne(k.getId()));
//			}
//			
//			List<OcenaDTO> ocenaDTO = regKorisnikDTO.getOcena();
//			ArrayList<Ocena> ocene = new ArrayList<Ocena>();
//			//prebacivanje iz DTO u model
//			for (OcenaDTO o : ocenaDTO) {
//				ocene.add(ocenaService.findOne(o.getId()));
//			}
//			
//			List<PorukaDTO> porukaDTO = regKorisnikDTO.getPoruka();
//			ArrayList<Poruka> poruke = new ArrayList<Poruka>();
//			//prebacivanje iz DTO u model
//			for (PorukaDTO p : porukaDTO) {
//				poruke.add(porukaService.findOne(p.getId()));
//			}
		
		savedFirmaAgent = firmaService.addFirma(savedFirmaAgent);
		return new ResponseEntity<>(new FirmaAgentDTO(savedFirmaAgent), HttpStatus.CREATED);
	}
	
	//PUT
	@RequestMapping(method=RequestMethod.PUT, value="/AgentFirma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaDTO> updateFirma(@RequestBody FirmaAgentDTO firmaAgentDTO) throws Exception{
		
		System.out.println("Usao u update profile!");
		Firma updatedFirmaAgent = firmaService.findOne(firmaAgentDTO.getId());
		
		if (updatedFirmaAgent == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// we allow changing date and points for an pacijent only
		updatedFirmaAgent.setNaziv(firmaAgentDTO.getIme());			
		updatedFirmaAgent.setPoslovniMaticniBroj(firmaAgentDTO.getPrezime());		
		updatedFirmaAgent.setPoslovniMaticniBroj(firmaAgentDTO.getJmbg());		
		
		//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
		updatedFirmaAgent = firmaService.updateFirma(updatedFirmaAgent.getId(), updatedFirmaAgent);
		return new ResponseEntity<>(new FirmaDTO(updatedFirmaAgent), HttpStatus.OK);
	}
	
	//DELET	isti kao i za Firmu moze se i obrisati...
	@RequestMapping(value="/AgentFirma/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFirma(@PathVariable Long id) {
		
		Firma firma = firmaService.findOne(id);
		if (firma != null) {
			firmaService.deleteFirma(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
