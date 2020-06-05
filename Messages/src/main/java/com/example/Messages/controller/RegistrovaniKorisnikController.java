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

import com.example.Messages.DTO.KomentarDTO;
import com.example.Messages.DTO.OcenaDTO;
import com.example.Messages.DTO.PorukaDTO;
import com.example.Messages.DTO.RegistrovaniKorisnikDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;
import com.example.Messages.service.KomentarService;
import com.example.Messages.service.OcenaService;
import com.example.Messages.service.PorukaService;
import com.example.Messages.service.RegistrovaniKorisnikService;

@RestController
public class RegistrovaniKorisnikController {

	@Autowired
	private RegistrovaniKorisnikService regKorisnikService;
	
	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private OcenaService ocenaService;
	
	@Autowired
	private PorukaService porukaService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/RegistrovaniKorisnik", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegistrovaniKorisnikDTO>> getAllRegistrovaniKorisnik() {
	
		List<RegistrovaniKorisnik> allRegKorisnik = regKorisnikService.getAllRegistrovaniKorisnik();
		
		List<RegistrovaniKorisnikDTO> regKorisnikDTO = new ArrayList<>();
		for (RegistrovaniKorisnik rk : allRegKorisnik) {
			regKorisnikDTO.add(new RegistrovaniKorisnikDTO(rk));
		}
		// convert pacijent to DTOs
		return new ResponseEntity<>(regKorisnikDTO, HttpStatus.OK);

	}
	
	//GET
	//@PreAuthorize("hasRole('PACIJENT')")
	@RequestMapping(method=RequestMethod.GET, value="/RegistrovaniKorisnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrovaniKorisnikDTO> getRegistrovaniKorisnik(@PathVariable("id") Long id){
		
		RegistrovaniKorisnik regKorisnik = regKorisnikService.findOne(id);
		//return radnikService.getRadnik(id);
		if (regKorisnik  == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RegistrovaniKorisnikDTO(regKorisnik), HttpStatus.OK);
		
	}
	
	//POST
	//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
	@RequestMapping(method=RequestMethod.POST, value="/RegistrovaniKorisnik",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrovaniKorisnikDTO> addRegistrovaniKorisnik(@RequestBody RegistrovaniKorisnikDTO regKorisnikDTO)  throws Exception {
		
		RegistrovaniKorisnik savedRegKorisnik = new RegistrovaniKorisnik();
					
		savedRegKorisnik.setIme(regKorisnikDTO.getIme());			
		savedRegKorisnik.setPrezime(regKorisnikDTO.getPrezime());		
		savedRegKorisnik.setJMBG(regKorisnikDTO.getJmbg());			
		
//		List<KomentarDTO> komentarDTO = regKorisnikDTO.getKomentar();
//		ArrayList<Komentar> komentari = new ArrayList<Komentar>();
//		//prebacivanje iz DTO u model
//		for (KomentarDTO k : komentarDTO) {
//			komentari.add(komentarService.findOne(k.getId()));
//		}
//		
//		List<OcenaDTO> ocenaDTO = regKorisnikDTO.getOcena();
//		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
//		//prebacivanje iz DTO u model
//		for (OcenaDTO o : ocenaDTO) {
//			ocene.add(ocenaService.findOne(o.getId()));
//		}
//		
//		List<PorukaDTO> porukaDTO = regKorisnikDTO.getPoruka();
//		ArrayList<Poruka> poruke = new ArrayList<Poruka>();
//		//prebacivanje iz DTO u model
//		for (PorukaDTO p : porukaDTO) {
//			poruke.add(porukaService.findOne(p.getId()));
//		}
		
		savedRegKorisnik = regKorisnikService.addRegistrovaniKorisnik(savedRegKorisnik);
		return new ResponseEntity<>(new RegistrovaniKorisnikDTO(savedRegKorisnik), HttpStatus.CREATED);
	}
	
	//PUT
	@RequestMapping(method=RequestMethod.PUT, value="/RegistrovaniKorisnik", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrovaniKorisnikDTO> updateRegistrovaniKorisnik(@RequestBody RegistrovaniKorisnikDTO RegKorisnikDTO) throws Exception{
		
		System.out.println("Usao u update profile!");
		RegistrovaniKorisnik updatedRegKorisnik = regKorisnikService.findOne(RegKorisnikDTO.getId());
		
		if (updatedRegKorisnik == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// we allow changing date and points for an pacijent only
		updatedRegKorisnik.setIme(RegKorisnikDTO.getIme());
		updatedRegKorisnik.setPrezime(RegKorisnikDTO.getPrezime());
		updatedRegKorisnik.setJMBG(RegKorisnikDTO.getJmbg());
		
		
		//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
		updatedRegKorisnik = regKorisnikService.updateRegistrovaniKorisnik(updatedRegKorisnik.getId(), updatedRegKorisnik);
		return new ResponseEntity<>(new RegistrovaniKorisnikDTO(updatedRegKorisnik), HttpStatus.OK);
	}
	
	//DELET	
	@RequestMapping(value="/RegistrovaniKorisnik/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRegistrovaniKorisnik(@PathVariable Long id) {
		
		RegistrovaniKorisnik regKorisnik = regKorisnikService.findOne(id);
		if (regKorisnik != null) {
			regKorisnikService.deleteRegistrovaniKorisnik(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
