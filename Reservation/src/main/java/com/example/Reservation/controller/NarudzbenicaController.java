package com.example.Reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.dto.NarudzbenicaNewDTO;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.NarudzbenicaService;
import com.example.Reservation.repository.service.mapper.NaruzbenicaMapper;

@RestController
@RequestMapping(value="/narudzbenica")
public class NarudzbenicaController {

	@Autowired
	private NarudzbenicaService narServ;
	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private NaruzbenicaMapper narMap;
	
	@GetMapping(value="")
	public ResponseEntity<List<NarudzbenicaDTO>> getAllNarudzbenica() {
		List<NarudzbenicaDTO> lista = narServ.getAll();
		if(lista!=null)
			return new ResponseEntity<>(lista, HttpStatus.OK);	
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<NarudzbenicaDTO> getNarudzbenica(@PathVariable("id") Long id){
		NarudzbenicaDTO dto=narServ.get(id);
		if(dto!=null)
			return new ResponseEntity<>(dto, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteNarudzbenica(@PathVariable Long id) {
		Narudzbenica narudzb = narRep.findById(id).orElse(null);
		if (narudzb != null) {
			narServ.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	
	
	@PutMapping(value="")
	public ResponseEntity<NarudzbenicaNewDTO> updateNarudzbenica(@RequestBody NarudzbenicaNewDTO dto) throws Exception{
		NarudzbenicaNewDTO izmenjena=narServ.updateNar(dto);
		return new ResponseEntity<>(izmenjena, HttpStatus.OK);	
	}
	@Autowired
	private NarudzbenicaRepository nRep;
	@GetMapping(value="/sync")
	public List<Narudzbenica> sync(){
		return nRep.findAll();
	}
	
}
