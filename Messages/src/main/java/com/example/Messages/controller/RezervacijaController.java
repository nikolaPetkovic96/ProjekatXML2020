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
import com.example.Messages.DTO.OglasDTO;
import com.example.Messages.DTO.PorukaDTO;
import com.example.Messages.DTO.RezervacijaDTO;
import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
import com.example.Messages.service.OglasService;
import com.example.Messages.service.PorukaService;
import com.example.Messages.service.RezervacijaService;

@RestController
public class RezervacijaController {

	@Autowired
	private OglasService oglasService;
	@Autowired 
	private PorukaService porukaService;
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/Rezervacija", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RezervacijaDTO>> getAllRezervacija(){
		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacija();
		
		List<RezervacijaDTO> rezervacijaDTO = new ArrayList<>();
		for(Rezervacija r : allRezervacija) {
			rezervacijaDTO.add(new RezervacijaDTO(r));
			
		}
		return new ResponseEntity<>(rezervacijaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/Rezervacija/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> getRezervacija(@PathVariable("id") Long id){
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RezervacijaDTO(rezervacija), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> addRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
		
		List<OglasDTO> oglasi = rezervacijaDTO.getOglas();
		ArrayList<Oglas> ads = new ArrayList<Oglas>();
		for(OglasDTO o : oglasi) {
			ads.add(oglasService.findOne(o.getId()));
		}
		
		List<PorukaDTO> poruke = rezervacijaDTO.getPoruka();
		ArrayList<Poruka> msgs = new ArrayList<Poruka>();
		for(PorukaDTO p : poruke) {
			msgs.add(porukaService.findOne(p.getId()));
		}
		
		Rezervacija savedRezervacija = new Rezervacija();
		
		savedRezervacija.setOglas(ads);
		savedRezervacija.setPoruka(msgs);
		
		savedRezervacija.setRezervacija_id(rezervacijaDTO.getRezervacija_id());
		savedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
		savedRezervacija.setOdDatuma(rezervacijaDTO.getOdDatuma());
		savedRezervacija.setDoDatuma(rezervacijaDTO.getDoDatuma());
		savedRezervacija.setBundle(rezervacijaDTO.getBundle());
		savedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
		
		savedRezervacija = rezervacijaService.addRezervacija(savedRezervacija);

		return new ResponseEntity<>(new RezervacijaDTO(savedRezervacija), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> updateRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
		
		Rezervacija updatedRezervacija = rezervacijaService.findOne(rezervacijaDTO.getRezervacija_id());
		if(updatedRezervacija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		updatedRezervacija.setOdDatuma(rezervacijaDTO.getOdDatuma());
		updatedRezervacija.setDoDatuma(rezervacijaDTO.getDoDatuma());
		updatedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
		updatedRezervacija.setBundle(rezervacijaDTO.getBundle());
		updatedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
		//updatedRezervacija.setRezervacija_id(rezervacijaDTO.getRezervacija_id());
		
		updatedRezervacija = rezervacijaService.updateRezervacija(updatedRezervacija.getRezervacija_id(), updatedRezervacija);
		return new ResponseEntity<>(new RezervacijaDTO(updatedRezervacija),HttpStatus.OK);
	}
	
	@RequestMapping(value="/Rezervacija/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRezervacija(@PathVariable Long id){
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		if(rezervacija != null) {
			rezervacijaService.deleteRezervacija(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
