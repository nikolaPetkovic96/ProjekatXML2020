package com.example.Reservation.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.dto.RezervacijaFullDTO;
import com.example.Reservation.dto.RezervacijaNewDTO;
import com.example.Reservation.dto.RezervacijaStatusDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.model.TUser;
import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.RezervacijaService;
import com.example.Reservation.repository.service.TUserService;



@RestController
@RequestMapping(value="/rezervacija")
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService commonDataService;
	@Autowired
	private TUserService userService;
	
	@GetMapping(value="")
	public List<RezervacijaFullDTO> getAllRezervacija(	@RequestParam(name = "oglas", required = false) Long oglas_id,
													@RequestParam(name = "user", required = false) String username)
													{
		
		 if(username!=null)
			return rezervacijaService.getAllRezervacijeUser(username);
		 else if(oglas_id!=null)
			return rezervacijaService.getAllRezervacijeOglas(oglas_id);
		 else return rezervacijaService.getAllFull();
	}
	@GetMapping(value="/expired")		//to proveriti datume
	public List<RezervacijaDTO> getAllFinishedRezervacija(	@RequestParam(name = "oglas", required = false) Long oglas_id,
																			@RequestParam(name = "user", required = false) String username,
																			@RequestParam(name = "status", required = false) String status){
		if(username!=null)
			return rezervacijaService.getAllStatusUser(username, status);
		else 
			return rezervacijaService.getAllStatus(status);			
	}
	
	@GetMapping(value="{id}/details")
	public RezervacijaFullDTO getRezervacijaDetails(@PathVariable("id") Long id) {
		return rezervacijaService.getRezervacijaFull(id);
	}
	
	@PostMapping(value="")
	public ResponseEntity<RezervacijaNewDTO> addRezervacija(@RequestBody RezervacijaNewDTO dto, @RequestBody String username) throws Exception{
		RezervacijaNewDTO rezervacija=rezervacijaService.createRezervacija(dto, username);
		return new ResponseEntity<>(rezervacija, HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/status")
	ResponseEntity<RezervacijaStatusDTO> updateStatusRezervacija(@RequestBody RezervacijaStatusDTO dto) throws Exception{
		RezervacijaStatusDTO r=rezervacijaService.updateStatus(dto);
		if(r == null || dto.getStatusRezervacije().equals("CANCELED")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<RezervacijaStatusDTO>(r,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteRezervacija(@PathVariable Long id) {
		Boolean uspeh=rezervacijaService.deleteRezervacija(id);
		if(uspeh)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	
}
