package com.team32.AgentApp.controller;

import java.security.Principal;
import java.time.LocalDateTime;
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

import com.team32.AgentApp.DTO.IzvestajDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Izvestaj;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.AutomobilService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.IzvestajService;
import com.team32.AgentApp.service.RezervacijaService;
import com.team32.AgentApp.service.UserService;
import com.team32.AgentApp.service.impl.EmailService;

@RestController
public class IzvestajController {
	
	@Autowired
	private IzvestajService izvestajService;
	
	@Autowired
	private CommonDataService comDataService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private EmailService emailService;
	@Autowired
	private RezervacijaService rezervacijaService;
	
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/izvestaj", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IzvestajDTO>> getAllNarudzbenica() {
		List<Izvestaj> all = izvestajService.getAllIzvestaj();
		
		List<IzvestajDTO> dto = new ArrayList<>();
		for(Izvestaj i : all )
			dto.add(new IzvestajDTO(i));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/izvestaj/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<IzvestajDTO> getIzvestaj(@PathVariable("id") Long id){
		Izvestaj izv = izvestajService.findOne(id);
			if(izv ==null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new IzvestajDTO(izv), HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/izvestaj",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IzvestajDTO> addIzvestaj(Principal principal, @RequestBody IzvestajDTO dto)  throws Exception {
		Izvestaj savedIzvestaj = new Izvestaj();
		
		//Preuzima se user, koji je trenutno ulogovan, iz sesije
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId(loggedAgent.getId());
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);
	
		savedIzvestaj.setId(dto.getId());
		savedIzvestaj.setNarudzbenicaId(dto.getNarudzbenicaId());
		savedIzvestaj.setAutomobilId(dto.getAutomobilId());
		savedIzvestaj.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		savedIzvestaj.setTekstIzvestaja(dto.getTekstIzvestaja());
		savedIzvestaj.setRezervacijaId(dto.getRezervacijaId());
		savedIzvestaj.setPrekoracenaKilometraza(dto.getPrekoracenaKilometraza());
		savedIzvestaj.setDodatniTroskovi(dto.getDodatniTroskovi());
		savedIzvestaj.setCommonDataId(commonData.getId());
		
		savedIzvestaj = izvestajService.addIzvestaj(savedIzvestaj);
		
		
		Rezervacija rezerv = rezervacijaService.findOne(dto.getRezervacijaId());
		CommonData comData = comDataService.findOne(rezerv.getCommonDataId());
		User userWhoMadeReserv = userService.findOne(comData.getUserid());
		if(savedIzvestaj.getPrekoracenaKilometraza() > 0) {
			emailService.sendBillEmail(userWhoMadeReserv, savedIzvestaj);
		}
		
		Automobil auto = automobilService.findOne(savedIzvestaj.getAutomobilId());
		auto.setPredjenaKilometraza(auto.getPredjenaKilometraza() + savedIzvestaj.getPredjenaKilometraza());
		automobilService.updateAutomobil(auto.getId(), auto);
		
		return new ResponseEntity<>(new IzvestajDTO(savedIzvestaj), HttpStatus.CREATED);
	}
	
	//PUT
	@RequestMapping(method=RequestMethod.PUT, value="/izvestaj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IzvestajDTO> updateIzvestaj(@RequestBody IzvestajDTO dto) throws Exception{
		
		Izvestaj updIzvestaj = (Izvestaj) izvestajService.findOne(dto.getId());
		if(updIzvestaj ==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updIzvestaj.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		
		updIzvestaj.setId(dto.getId());
		updIzvestaj.setNarudzbenicaId(dto.getNarudzbenicaId());
		updIzvestaj.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		updIzvestaj.setTekstIzvestaja(dto.getTekstIzvestaja());
		updIzvestaj.setCommonDataId(comDatId);		
		
		
		updIzvestaj = izvestajService.updateIzvestaj(updIzvestaj.getId(), updIzvestaj);
		return new ResponseEntity<>(new IzvestajDTO(updIzvestaj), HttpStatus.OK);	
	}
			
	//DELET	
	@RequestMapping(value="/izvestaj/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteIzvestaj(@PathVariable Long id) {
		Izvestaj izvestaj = izvestajService.findOne(id);
		if (izvestaj != null) {
			izvestajService.deleteIzvestaj(id);
			comDataService.deleteCommonData(izvestaj.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}	

}
