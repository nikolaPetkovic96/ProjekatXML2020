package com.team32.AgentApp.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.CommonDataDTO;
import com.team32.AgentApp.DTO.NarudzbenicaDTO;
import com.team32.AgentApp.DTO.PorukaDTO;
import com.team32.AgentApp.DTO.RezervacijaDTO;
import com.team32.AgentApp.DTO.RezervacijaFullDTO;
import com.team32.AgentApp.DTO.RezervacijaStatusDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Poruka;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.NarudzbenicaService;
import com.team32.AgentApp.service.PorukaService;
import com.team32.AgentApp.service.RezervacijaService;
import com.team32.AgentApp.service.UserService;

@RestController
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private UserService userService;
	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private NarudzbenicaService narudzbService;

	//GET ALL Za prikaz samo osnovnih podataka iz rezervacija koje pripadaju ulogovanom
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/rezervacija", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RezervacijaDTO>> getAllRezervacija(Principal principal){
		
		//Preuzima se user, koji je trenutno ulogovan, iz sesije
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
//		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacija();
		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacijaByIdAgenta(loggedAgent.getId());
		
		List<RezervacijaDTO> rezervacijeDTO = new ArrayList<>();
		for(Rezervacija r : allRezervacija) {
			
			RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
			CommonData comData = comDataService.findOne(r.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			//User koji je kreirao rezervaciju i preizet je iz commonData 
			User user = userService.findOne(comData.getUserid());
			rezervacijaDTO.setUsername(user.getKorisnickoIme());
			rezervacijaDTO.setId(r.getId());
			rezervacijaDTO.setUkupnaCena(r.getUkupnaCena());
			rezervacijaDTO.setBundle(r.getBundle());
			rezervacijaDTO.setStatusRezervacije(r.getStatusRezervacije());
			rezervacijaDTO.setCommonDataId(r.getCommonDataId());
			
			rezervacijeDTO.add(rezervacijaDTO);
			
		}
		return new ResponseEntity<>(rezervacijeDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/rezervacija/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> getRezervacija(@PathVariable("id") Long id){
		RezervacijaDTO rezervacijaDTO = new RezervacijaDTO();
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CommonData comData = comDataService.findOne(rezervacija.getCommonDataId());
		User user = userService.findOne(comData.getUserid());
		rezervacijaDTO.setUsername(user.getKorisnickoIme());
		rezervacijaDTO.setId(rezervacija.getId());
		rezervacijaDTO.setUkupnaCena(rezervacija.getUkupnaCena());

		rezervacijaDTO.setBundle(rezervacija.getBundle());
		rezervacijaDTO.setStatusRezervacije(rezervacija.getStatusRezervacije());
		rezervacijaDTO.setCommonDataId(rezervacija.getCommonDataId());
		
		return new ResponseEntity<>(rezervacijaDTO, HttpStatus.OK);
	}
	
	//GET
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/rezervacija/{id}/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaFullDTO> getRezervacijaDetails(@PathVariable("id") Long id){
		RezervacijaFullDTO rezervacijaFullDTO = new RezervacijaFullDTO();
		
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Poruka> poruke = porukaService.findAllPorukeByRezervId(id);
		List<PorukaDTO> porukeDTO = new ArrayList<PorukaDTO>();
		if(poruke == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		for(Poruka p : poruke) {
			String username = getUsernameByComDataId(p.getCommonDataId());
			CommonData comData = comDataService.findOne(p.getCommonDataId());
			porukeDTO.add(new PorukaDTO(p, username, new CommonDataDTO(comData)));
		}
		
		List<Narudzbenica> narudzbenice = narudzbService.getAllNarudzbeniceByRezervId(id);
		List<NarudzbenicaDTO> narudzbeniceDTO = new ArrayList<NarudzbenicaDTO>();
		if(narudzbenice == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		for(Narudzbenica nar:narudzbenice) {
			narudzbeniceDTO.add(narudzbService.getNarudzbFullDetails(nar));
		}		
		
		//Dobavljanje username usera koji je kreirao rezervaciju
		rezervacijaFullDTO.setUsername(getUsernameByComDataId(rezervacija.getCommonDataId()));
		//Osnovni podaci rezervacije
		rezervacijaFullDTO.setId(rezervacija.getId());
		rezervacijaFullDTO.setUkupnaCena(rezervacija.getUkupnaCena());
		rezervacijaFullDTO.setBundle(rezervacija.getBundle());
		rezervacijaFullDTO.setStatusRezervacije(rezervacija.getStatusRezervacije());
		rezervacijaFullDTO.setCommonDataId(rezervacija.getCommonDataId());
		//Prosireni podaci karakteristicni za DTO
		rezervacijaFullDTO.setPoruke(porukeDTO);
		rezervacijaFullDTO.setNarudzbenice(narudzbeniceDTO);
		return new ResponseEntity<>(rezervacijaFullDTO, HttpStatus.OK);
	}
	
	
//	@RequestMapping(method=RequestMethod.POST, value="/rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<RezervacijaDTO> addRezervacija(Principal principal, @RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
//		
//		Rezervacija savedRezervacija = new Rezervacija();
//		
//		Long agentId;
//		
//		CommonData commonData = new CommonData();
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setDatumKreiranja(now);
//		
//		//Dobavljanje username iz zahteva
//		String username = principal.getName();
//		User user = userService.findByUsername(username);
//		commonData.setUserId(user.getId());
//		
//		commonData = comDataService.addCommonData(commonData);
//		
////	User user = userService.findOne(commonData.getUserid());
//		
//		savedRezervacija.setId(rezervacijaDTO.getId());
//		savedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
//		savedRezervacija.setBundle(rezervacijaDTO.getBundle());
//		savedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
//		savedRezervacija.setCommonDataId(commonData.getId());
//		
//		savedRezervacija = rezervacijaService.addRezervacija(savedRezervacija);
//
//		return new ResponseEntity<>(new RezervacijaDTO(savedRezervacija, user.getKorisnickoIme(), agentId), HttpStatus.CREATED);
//	}
	
//	@RequestMapping(method=RequestMethod.PUT, value="/rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<RezervacijaDTO> updateRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception{
//		
//		Rezervacija updatedRezervacija = rezervacijaService.findOne(rezervacijaDTO.getId());
//		if(updatedRezervacija == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		Long comDatId = updatedRezervacija.getCommonDataId();
//		
//		CommonData commonData = comDataService.findOne(comDatId);
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setDatumIzmene(now);
//		commonData = comDataService.updateCommonData(comDatId, commonData);
//		
//		User user = userService.findOne(commonData.getUserid());
//		
//		updatedRezervacija.setId(rezervacijaDTO.getId());
//		updatedRezervacija.setUkupnaCena(rezervacijaDTO.getUkupnaCena());
//		updatedRezervacija.setBundle(rezervacijaDTO.getBundle());
//		updatedRezervacija.setStatusRezervacije(rezervacijaDTO.getStatusRezervacije());
//		updatedRezervacija.setCommonDataId(comDatId);
//		
//		updatedRezervacija = rezervacijaService.updateRezervacija(updatedRezervacija.getId(), updatedRezervacija);
//		return new ResponseEntity<>(new RezervacijaDTO(updatedRezervacija,user.getKorisnickoIme()),HttpStatus.OK);
//	}
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.PUT, value="/rezervacija/status", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaStatusDTO> updateRezervacija(@RequestBody RezervacijaStatusDTO dto) throws Exception{
		
		Rezervacija updatedRezervacija = rezervacijaService.findOne(dto.getRezervacijaId());
		if(updatedRezervacija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updatedRezervacija.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		commonData.setDatumIzmene(LocalDateTime.now());
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
	
		updatedRezervacija.setStatusRezervacije(dto.getStatusRezervacije());
		updatedRezervacija.setCommonDataId(comDatId);
		
		updatedRezervacija = rezervacijaService.updateRezervacija(updatedRezervacija.getId(), updatedRezervacija);
		return new ResponseEntity<>(new RezervacijaStatusDTO(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(value="/rezervacija/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRezervacija(@PathVariable Long id){
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		if(rezervacija != null) {
			rezervacijaService.deleteRezervacija(id);
			comDataService.deleteCommonData(rezervacija.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	POMOCNE METODE
	public String getUsernameByComDataId(Long comDataId) {
		CommonData comData = comDataService.findOne(comDataId);
		User user = userService.findOne(comData.getUserid());
		return user.getKorisnickoIme();
	}
	
	public LocalDateTime getDateByComDataId(Long comDataId) {
		CommonData comData = comDataService.findOne(comDataId);
		return comData.getDatumKreiranja();
	}
	
}
