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

import com.example.Messages.DTO.FirmaDTO;
import com.example.Messages.DTO.RegistrovaniKorisnikDTO;
import com.example.Messages.SchemaToJava2.model.user.Firma;
import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;
import com.example.Messages.service.FirmaService;
import com.example.Messages.service.RegistrovaniKorisnikService;

public class FirmaController {
	
	@Autowired
	private FirmaService firmaService;
	
	//GET ALL	
	@RequestMapping(method=RequestMethod.GET, value="/Firma", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FirmaDTO>> getAllFirma() {
	
		List<Firma> allFirma = firmaService.getAllFirma();
		
		List<FirmaDTO> firmaDTO = new ArrayList<>();
		for (Firma f : allFirma) {
			firmaDTO.add(new FirmaDTO(f));
		}
		// convert pacijent to DTOs
		return new ResponseEntity<>(firmaDTO, HttpStatus.OK);

	}
	
	//GET
	//@PreAuthorize("hasRole('PACIJENT')")
	@RequestMapping(method=RequestMethod.GET, value="/RegistrovaniKorisnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FirmaDTO> getFirma(@PathVariable("id") Long id){
		
		Firma firma = firmaService.findOne(id);
		//return radnikService.getRadnik(id);
		if (firma  == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new FirmaDTO(firma), HttpStatus.OK);
		
	}
	
//	//POST
//	//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
//	@RequestMapping(method=RequestMethod.POST, value="/RegistrovaniKorisnik",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<RegistrovaniKorisnikDTO> addFirma(@RequestBody RegistrovaniKorisnikDTO regKorisnikDTO)  throws Exception {
//		
//		RegistrovaniKorisnik savedRegKorisnik = new RegistrovaniKorisnik();
//					
//		savedRegKorisnik.setIme(regKorisnikDTO.getIme());			
//		savedRegKorisnik.setPrezime(regKorisnikDTO.getPrezime());		
//		savedRegKorisnik.setJMBG(regKorisnikDTO.getJmbg());			
//		
////			List<KomentarDTO> komentarDTO = regKorisnikDTO.getKomentar();
////			ArrayList<Komentar> komentari = new ArrayList<Komentar>();
////			//prebacivanje iz DTO u model
////			for (KomentarDTO k : komentarDTO) {
////				komentari.add(komentarService.findOne(k.getId()));
////			}
////			
////			List<OcenaDTO> ocenaDTO = regKorisnikDTO.getOcena();
////			ArrayList<Ocena> ocene = new ArrayList<Ocena>();
////			//prebacivanje iz DTO u model
////			for (OcenaDTO o : ocenaDTO) {
////				ocene.add(ocenaService.findOne(o.getId()));
////			}
////			
////			List<PorukaDTO> porukaDTO = regKorisnikDTO.getPoruka();
////			ArrayList<Poruka> poruke = new ArrayList<Poruka>();
////			//prebacivanje iz DTO u model
////			for (PorukaDTO p : porukaDTO) {
////				poruke.add(porukaService.findOne(p.getId()));
////			}
//		
//		savedRegKorisnik = firmaService.addFirma(savedRegKorisnik);
//		return new ResponseEntity<>(new RegistrovaniKorisnikDTO(savedRegKorisnik), HttpStatus.CREATED);
//	}
//	
//	//PUT
//	@RequestMapping(method=RequestMethod.PUT, value="/RegistrovaniKorisnik", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<RegistrovaniKorisnikDTO> updateFirma(@RequestBody FirmaDTO RegKorisnikDTO) throws Exception{
//		
//		System.out.println("Usao u update profile!");
//		RegistrovaniKorisnik updatedRegKorisnik = firmaService.findOne(RegKorisnikDTO.getId());
//		
//		if (updatedRegKorisnik == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		// we allow changing date and points for an pacijent only
//		updatedRegKorisnik.setIme(RegKorisnikDTO.getIme());
//		updatedRegKorisnik.setPrezime(RegKorisnikDTO.getPrezime());
//		updatedRegKorisnik.setJMBG(RegKorisnikDTO.getJmbg());
//		
//		
//		//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
//		updatedRegKorisnik = firmService.updateRegistrovaniKorisnik(updatedRegKorisnik.getId(), updatedRegKorisnik);
//		return new ResponseEntity<>(new RegistrovaniKorisnikDTO(updatedRegKorisnik), HttpStatus.OK);
//	}
	
	//DELET	
	@RequestMapping(value="/RegistrovaniKorisnik/{id}", method=RequestMethod.DELETE)
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