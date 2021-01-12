package com.example.Reservation.controller;

import java.security.Principal;
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
import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.RezervacijaService;


@RestController
@RequestMapping(value="/rezervacija")
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService commonDataService;
/**********************ADMIN -GETALL **********************/	
	@GetMapping(value="/all")//da preuzme sve rezervacije, smeo bi samo admin
	public List<RezervacijaDTO> getAllRezervacija(	){		
			return rezervacijaService.getAllRezervacije();
	}	
	@GetMapping(value="/all/full")//da preuzme sve rezervacije, smeo bi samo admin
	public List<RezervacijaFullDTO> getAllRezervacijaImg(){		
			return rezervacijaService.getAllRezervacijeFull();
	}	
/****************************************************************************/	

/**********************KORISNIK TRENUTNO ULOGOVAN -GETALL **********************/	
	@GetMapping(value="/user")	//sve rezervacije koje je korisnik kreirao
	public List<RezervacijaFullDTO> getAllRezervacijaUserFull(	Principal principal){		
			return rezervacijaService.getAllRezervacijeUserFull(principal.getName());
	}
	@GetMapping(value="/user/full")	//sve rezervacije koje je korisnik kreirao
	public List<RezervacijaDTO> getAllRezervacijaUser(	Principal principal){		
			return rezervacijaService.getAllRezervacijeUserDTO(principal.getName());

	}
	
/****************************************************************************/	

/**********************AGENT TRENUTNO ULOGOVAN  **********************/	

	@GetMapping(value="/agent")	//sve rezervacije vezane za ogalse agenta
	public List<RezervacijaFullDTO> getAllRezervacijaAgentFull(	Principal principal){		
			return rezervacijaService.getAllRezervacijeAgentFullDTO(principal.getName());
	}
	@GetMapping(value="/agent/full")	//sve rezervacije vezane za ogalse agenta
	public List<RezervacijaDTO> getAllRezervacijaAgent(	Principal principal){		
			return rezervacijaService.getAllRezervacijeAgentDTO(principal.getName());
	}
/****************************************************************************/	

	@GetMapping(value="/expired")		//sortirani, treba proveriti
	public List<RezervacijaDTO> getAllFinishedRezervacija(	Principal p){
			return rezervacijaService.getAllStatusUser(p.getName(), "PAID");
		
	}
	@GetMapping(value="/{id}")
	public RezervacijaDTO getRezervacija(@PathVariable("id") Long id){
		return rezervacijaService.getRezervacija(id);
	}
	
	@GetMapping(value="{id}/details")
	public RezervacijaFullDTO getRezervacijaDetails(@PathVariable("id") Long id) {
		return rezervacijaService.getRezervacijaFull(id);
	}
	
	@PostMapping(value="")
	public RezervacijaNewDTO addRezervacija(Principal principal, @RequestBody RezervacijaNewDTO dto) throws Exception{
		RezervacijaNewDTO rezervacija=rezervacijaService.createRezervacija(dto, principal.getName());
		return rezervacija;	
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
