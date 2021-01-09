package com.example.Reservation.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reservation.dto.RezervacijaDTO;

import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.RezervacijaService;
//import com.example.Reservation.repository.service.TUserService;


@RestController
@RequestMapping(value="/rating")
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService commonDataService;
	@Autowired
//	private TUserService userService;
	
	@GetMapping(value = "")
	public List<RezervacijaDTO> getRezervacije(@RequestParam("oglas_id") Optional<Long> oglas_id,
												@RequestParam("username") Optional<String> username){
				if(oglas_id!=null)
					return rezervacijaService.getAllRezervacijeOglas(oglas_id.orElse(null));
				else if(username!=null)
					return rezervacijaService.getAllRezervacijeUser(username.orElse(null));
				else return null;		
	}
	@GetMapping(value = "/{id}")
	public RezervacijaDTO getRezervacijaById(@PathVariable("id") Long id ) {
		return rezervacijaService.getRezervacija(id);
	}
	
	@PostMapping(value="")
	public List<RezervacijaDTO> addRezervacija(@RequestBody RezervacijaDTO rez){
		return rezervacijaService.createRezervacija(rez);
		
	}
	
	@PostMapping(value="/{id}/accept")
	public RezervacijaDTO acceptRezervacija(@PathVariable("id") Long id){
		return rezervacijaService.prihvatiRezervaciju(id);		
	}
	
	@PostMapping(value="/{id}/cancel")
	public RezervacijaDTO cancelRezervacija(@PathVariable("id") Long id){
		return rezervacijaService.otkaziRezervaciju(id);		
	}
	@PostMapping(value="/{id}/pay")
	public RezervacijaDTO platiRezervacija(@PathVariable("id") Long id){
		return rezervacijaService.platiRezervaciju(id);		
	}

}
