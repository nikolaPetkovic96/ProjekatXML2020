//package com.example.Messages.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.Messages.service.RegistrovaniKorisnikService;
//
//@RestController
//public class RegistrovaniKorisnikController {
//
//	@Autowired
//	private RegistrovaniKorisnikService regKorisnikService;
//	
//	//GET ALL	
//		@RequestMapping(method=RequestMethod.GET, value="/pacijent", produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<List<PacijentDTO>> getAllPacijent() {
//		
//			List<Pacijent> allPacijent = pacijentService.getAllPacijent();
//			
//			List<PacijentDTO> pacijentDTO = new ArrayList<>();
//			for (Pacijent p : allPacijent) {
//				pacijentDTO.add(new PacijentDTO(p));
//			}
//			// convert pacijent to DTOs
//			return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
//
//		}
//		
//		//GET
//		//@PreAuthorize("hasRole('PACIJENT')")
//		@RequestMapping(method=RequestMethod.GET, value="/pacijent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<PacijentDTO> getPacijent(@PathVariable("id") Long id){
//			
//			Pacijent pacijent = pacijentService.findOne(id);
//			//return radnikService.getRadnik(id);
//			if (pacijent == null) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity<>(new PacijentDTO(pacijent), HttpStatus.OK);
//			
//		}
//		
//		//POST
//		//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
//		@RequestMapping(method=RequestMethod.POST, value="/pacijent",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<PacijentDTO> addPacijent(@RequestBody PacijentDTO pacijentDTO)  throws Exception {
//			
//			// a new exam must can't have zdravstveniKarton defined
//			if (pacijentDTO.getZdravstveniKarton() == null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
//					
//			//Dok kreiram pacijenta kreira se automatski i novi prazan zdravstveni karton za njega:
//
//			ZdravstveniKartonDTO savedZdrKarton = pacijentDTO.getZdravstveniKarton();
//			ZdravstveniKarton zdrKarton = new ZdravstveniKarton();
//			zdrKarton = zdrKartonService.addZdravstveniKarton(zdrKarton);
//			
//			Pacijent savedPacijent = new Pacijent();
//			savedPacijent.setIme(pacijentDTO.getIme());
//			savedPacijent.setPrezime(pacijentDTO.getPrezime());
//			savedPacijent.setAdresa(pacijentDTO.getAdresa());
//			savedPacijent.setGrad(pacijentDTO.getGrad());
//			savedPacijent.setDrzava(pacijentDTO.getDrzava());
//			savedPacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
//			savedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
//		
//			savedPacijent.setZdravstveniKarton(zdrKarton);
//			
//			savedPacijent = pacijentService.addPacijent(savedPacijent);
//			return new ResponseEntity<>(new PacijentDTO(savedPacijent), HttpStatus.CREATED);
//		}
//		
//		
//		//PUT
//		
//		@RequestMapping(method=RequestMethod.PUT, value="/updatePacijent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<PacijentDTO> updatePacijent(@Valid @RequestBody RegistrovanjeDTO pacijentDTO) throws Exception{
//			
//			System.out.println("Usao u update profile!");
//			Pacijent updatedPacijent = pacijentService.findOne(pacijentDTO.getId());
//			
//			if (updatedPacijent == null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
//			
//			// we allow changing date and points for an pacijent only
//			updatedPacijent.setId(pacijentDTO.getId());
//			updatedPacijent.setIme(pacijentDTO.getIme());
//			updatedPacijent.setPrezime(pacijentDTO.getPrezime());
//			updatedPacijent.setAdresa(pacijentDTO.getAdresa());
//			updatedPacijent.setGrad(pacijentDTO.getGrad());
//			updatedPacijent.setDrzava(pacijentDTO.getDrzava());
//			updatedPacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
//			//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
//			
//			System.out.println("Izlazim iz update profile!");
//			updatedPacijent = pacijentService.updatePacijent(updatedPacijent.getId(), updatedPacijent);
//			return new ResponseEntity<>(new PacijentDTO(updatedPacijent), HttpStatus.OK);
//		}
//		
//		//DELET	
//		@RequestMapping(value="/pacijent/{id}", method=RequestMethod.DELETE)
//		public ResponseEntity<Void> deletePacijent(@PathVariable Long id) {
//			
//			Pacijent pacijent = pacijentService.findOne(id);
//			if (pacijent != null) {
//				pacijentService.deletePacijent(id);
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			} 
//		}
//}
