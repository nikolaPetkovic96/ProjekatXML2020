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
import com.example.Reservation.repository.RezervacijaRepository;
import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.RezervacijaService;
import com.example.Reservation.repository.service.impl.AsynchronousService;


@RestController
@RequestMapping(value="/reservation")
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService commonDataService;
	
/**********************ADMINGETALL **********************/
	
	@GetMapping(value="/all")//da preuzme sve rezervacije, smeo bi samo admin
	public List<RezervacijaDTO> getAllRezervacija(){		
			return rezervacijaService.getAllRezervacije();
	}	
	@GetMapping(value="/all/full")//da preuzme sve rezervacije, smeo bi samo admin
	public List<RezervacijaFullDTO> getAllRezervacijaImg(){		
			return rezervacijaService.getAllRezervacijeFull();
	}	

/**********************ULOGOVANI KORISNIK U USER MODU**********************/
	
	@GetMapping(value="/user/full")	//sve rezervacije koje je korisnik kreirao
	public List<RezervacijaFullDTO> getAllRezervacijaUserFull(Principal principal){		
			return rezervacijaService.getAllRezervacijeUserFull(principal.getName());
	}
	@GetMapping(value="/user")	//sve rezervacije koje je korisnik kreirao
	public List<RezervacijaDTO> getAllRezervacijaUser(	Principal principal){		
			return rezervacijaService.getAllRezervacijeUserDTO(principal.getName());

	}
	@GetMapping(value="user/expired")		//placene i zavrsene, rez koje je napravio ovaj korisnik
	public List<RezervacijaDTO> getAllFinishedRezervacijaForUser(Principal p){
			return rezervacijaService.getAllFinishedForUser(p.getName());
	}

/**********************ULOGOVANI KORISNIK U AGENT MODU**********************/	

	@GetMapping(value="/agent/full")	//sve rezervacije vezane za ogalse agenta
	public List<RezervacijaFullDTO> getAllRezervacijaAgentFull(Principal principal){		
			return rezervacijaService.getAllRezervacijeAgentFullDTO(principal.getName());
	}
	@GetMapping(value="/agent")	//sve rezervacije vezane za ogalse agenta
	public List<RezervacijaDTO> getAllRezervacijaAgent(	Principal principal){		
			return rezervacijaService.getAllRezervacijeAgentDTO(principal.getName());
	}
	@GetMapping(value="/agent/expired")		//placene i zavrsene, rez gde se nalaze oglasi ovog agenta
	public List<RezervacijaDTO> getAllFinishedRezervacijaForAgent(Principal p){
			return rezervacijaService.getAllFinishedForAgent(p.getName());
	}
	
/****************************************************************************/	

	@GetMapping(value="/{id}")
	public RezervacijaDTO getRezervacija(@PathVariable("id") Long id){
		return rezervacijaService.getRezervacija(id);
	}
	
	@GetMapping(value="{id}/details")
	public RezervacijaFullDTO getRezervacijaDetails(@PathVariable("id") Long id) {
		return rezervacijaService.getRezervacijaFull(id);
	}
	
	@PostMapping(value="")
	public List<RezervacijaNewDTO> addRezervacija(Principal principal, @RequestBody List<RezervacijaNewDTO> dto) throws Exception{
		List<RezervacijaNewDTO> rezervacije=rezervacijaService.createRezervacija(dto, principal.getName());
		return rezervacije;	
	}
	
	@PutMapping(value="/status")
	ResponseEntity<RezervacijaStatusDTO> updateStatusRezervacija(@RequestBody RezervacijaStatusDTO dto) throws Exception{
		return new ResponseEntity<RezervacijaStatusDTO>(rezervacijaService.updateStatus(dto), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteRezervacija(@PathVariable Long id) {
		Boolean uspeh=rezervacijaService.deleteRezervacija(id);
		if(uspeh)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}	
	@Autowired
	private RezervacijaRepository rRep;
	@GetMapping(value="/sync")
	public List<Rezervacija> sync(){
		return rRep.findAll();
	}
	//tajmeri
	@Autowired
	private AsynchronousService asyncServ;
	@GetMapping(value="/tajmer/placanje/{id}")
	public void tajmerPlacanje(@PathVariable Long id)  {
		asyncServ.proveraPlacanja(id);
	}
	@GetMapping(value="/tajmer/obrada/{id}")
	public void tajmerObrada(@PathVariable Long id)  {
		asyncServ.proveraObrade(id);
	}
}
