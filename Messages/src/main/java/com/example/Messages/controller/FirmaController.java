//package com.example.Messages.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.example.Messages.DTO.FirmaDTO;
//import com.example.Messages.DTO.KomentarDTO;
//import com.example.Messages.DTO.OglasDTO;
//import com.example.Messages.DTO.PorukaDTO;
//import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
//import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
//import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
//import com.example.Messages.SchemaToJava2.model.user.Firma;
//import com.example.Messages.service.FirmaService;
//import com.example.Messages.service.KomentarService;
//import com.example.Messages.service.OglasService;
//import com.example.Messages.service.PorukaService;
//
//public class FirmaController {
//	
//	@Autowired
//	private FirmaService firmaService;
//	
//	@Autowired
//	private KomentarService komentarService;
//	
//	@Autowired
//	private OglasService oglasService;
//	
//	@Autowired
//	private PorukaService porukaService;
//	
//	@RequestMapping(method=RequestMethod.GET, value="/FirmaTest", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String getTest() {
//		return "Test";
//	}
//	
//	//GET ALL	
//	@RequestMapping(method=RequestMethod.GET, value="/Firma", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<FirmaDTO>> getAllFirma() {
//	
//		List<Firma> allFirma = firmaService.getAllFirma();
//		
//		List<FirmaDTO> firmaDTO = new ArrayList<>();
//		for (Firma f : allFirma) {
//			firmaDTO.add(new FirmaDTO(f));
//		}
//		// convert pacijent to DTOs
//		return new ResponseEntity<>(firmaDTO, HttpStatus.OK);
//
//	}
//	
//	//GET
//	//@PreAuthorize("hasRole('ADMIN')")
//	@RequestMapping(method=RequestMethod.GET, value="/Firma/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<FirmaDTO> getFirma(@PathVariable("id") Long id){
//		
//		Firma firma = firmaService.findOne(id);
//		//return radnikService.getRadnik(id);
//		if (firma  == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(new FirmaDTO(firma), HttpStatus.OK);
//		
//	}
//	
//	//POST
//	//Ovo kaze metoda addTopic hendla svaki zahtev sa url '/topics' koji ima http zahtev POST:
//	@RequestMapping(method=RequestMethod.POST, value="/Firma",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<FirmaDTO> addFirma(@RequestBody FirmaDTO firmaDTO)  throws Exception {
//		
//		Firma savedFirma = new Firma();
//					
//		savedFirma.setNaziv(firmaDTO.getNaziv());			
//		savedFirma.setPoslovniMaticniBroj(firmaDTO.getPoslovniMaticniBroj());					
//		
//			List<KomentarDTO> komentarDTO = firmaDTO.getKomentar();
//			ArrayList<Komentar> komentari = new ArrayList<Komentar>();
//			//prebacivanje iz DTO u model
//			for (KomentarDTO k : komentarDTO) {
//				komentari.add(komentarService.findOne(k.getId()));
//			}
//			
//			List<OglasDTO> oglasDTO = firmaDTO.getOglas();
//			ArrayList<Oglas> oglasi = new ArrayList<Oglas>();
//			//prebacivanje iz DTO u model
//			for (OglasDTO o : oglasDTO) {
//				oglasi.add(oglasService.findOne(o.getId()));
//			}
//			
//			List<PorukaDTO> porukaDTO = firmaDTO.getPoruka();
//			ArrayList<Poruka> poruke = new ArrayList<Poruka>();
//			//prebacivanje iz DTO u model
//			for (PorukaDTO p : porukaDTO) {
//				poruke.add(porukaService.findOne(p.getId()));
//			}
//		
//		savedFirma = firmaService.addFirma(savedFirma);
//		return new ResponseEntity<>(new FirmaDTO(savedFirma), HttpStatus.CREATED);
//	}
//	
//	//PUT
//	@RequestMapping(method=RequestMethod.PUT, value="/Firma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<FirmaDTO> updateFirma(@RequestBody FirmaDTO firmaDTO) throws Exception{
//		
//		System.out.println("Usao u update profile!");
//		Firma updatedFirma = firmaService.findOne(firmaDTO.getId());
//		
//		if (updatedFirma == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		// we allow changing date and points for an pacijent only
//		updatedFirma.setIme(firmaDTO.getNaziv());
//		updatedFirma.setPrezime(firmaDTO.getPoslovniMaticniBroj());		
//		
//		//updatedPacijent.setBrojOsiguranika(pacijentDTO.getBrojOsiguranika());
//		updatedFirma = firmaService.updateFirma(updatedFirma.getId(), updatedFirma);
//		return new ResponseEntity<>(new FirmaDTO(updatedFirma), HttpStatus.OK);
//	}
//	
//	//DELET	
//	@RequestMapping(value="/Firma/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteFirma(@PathVariable Long id) {
//		
//		Firma firma = firmaService.findOne(id);
//		if (firma != null) {
//			firmaService.deleteFirma(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} 
//	}
//	
//}