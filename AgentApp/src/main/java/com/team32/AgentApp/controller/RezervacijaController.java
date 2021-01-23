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
import com.team32.AgentApp.DTO.NarudzbenicaNewDTO;
import com.team32.AgentApp.DTO.PorukaDTO;
import com.team32.AgentApp.DTO.RezervacijaDTO;
import com.team32.AgentApp.DTO.RezervacijaFullDTO;
import com.team32.AgentApp.DTO.RezervacijaNewDTO;
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

	//GET ALL Za prikaz samo osnovnih podataka iz rezervacija koje pripadaju ulogovanom agentu
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
	
	
	//GET ALL Za prikaz samo osnovnih podataka iz rezervacija koje pripadaju ulogovanom agentu
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/rezervacija/expired", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RezervacijaDTO>> getAllFinishedRezervacija(Principal principal){
		
		//Preuzima se user, koji je trenutno ulogovan, iz sesije
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		LocalDateTime now = LocalDateTime.now();
		
		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacijaByIdAgenta(loggedAgent.getId());
		
		//Filtiriramo i vracamo samo one rezervacije ciji je status PAID
		allRezervacija = rezervacijaService.getAllPaidRezervacije(allRezervacija);
		
		List<RezervacijaDTO> rezervacijeDTO = new ArrayList<>();
		for(Rezervacija r : allRezervacija) {
			
			//Pruzimamo sve narudzbenice koje su vezane za tu rezervaciju
			List<Narudzbenica> narudzbenica = narudzbService.getAllNarudzbeniceByRezervId(r.getId());
			
			
			//Soritramo ih po datumu zavrsetka u rastucem poretku
			List<Narudzbenica> sortiraneNarudzb = narudzbService.getAllSortedNarudzbByRezervId(narudzbenica);
			
			
			//Poredimo datum poslednjeg clan tako sortiranog niza (ima najkasniji datum zavrsetka) 
			//sa danasnijim danom i ako je manji vratimo tu rezervaciju.  
			Narudzbenica poslClan =  sortiraneNarudzb.get(sortiraneNarudzb.toArray().length-1);
			
			
			if (now.isAfter(poslClan.getDoDatuma())){

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
			
		}
		return new ResponseEntity<>(rezervacijeDTO, HttpStatus.OK);
	}	
	
	//GET
	@PreAuthorize("hasRole('ROLE_AGENT')")
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
		System.out.println("Usao u detail");
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
	
	//POST
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.POST, value="/rezervacija", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaNewDTO> addRezervacija(Principal principal, @RequestBody RezervacijaNewDTO dto) throws Exception{
		
		Rezervacija savedRezervacija = new Rezervacija();		
		
		//Dobavljanje username iz zahteva
		String username = principal.getName();
		User loggedUser = userService.findByUsername(username);
		
		//Kreirao se commonData za rezervacuju (uglovani user je kreira)
		CommonData commonData = setCommonData(loggedUser.getId());
		
		savedRezervacija.setId(dto.getId());
		savedRezervacija.setUkupnaCena(dto.getUkupnaCena());
		savedRezervacija.setBundle(dto.getBundle());
		savedRezervacija.setStatusRezervacije(dto.getStatusRezervacije());
//		savedRezervacija.setStatusRezervacije("RESERVED");
		savedRezervacija.setCommonDataId(commonData.getId());
		
		//kreirala se rezervacija i sada njen id se koristi pri kreiranju narudzbenice
		savedRezervacija = rezervacijaService.addRezervacija(savedRezervacija);
		
		//NARUDZBENICA
		Narudzbenica narudzbenica = new Narudzbenica();
		narudzbenica.setDoDatuma(dto.getNarudzbenica().getDoDatuma());
		narudzbenica.setOdDatuma(dto.getNarudzbenica().getOdDatuma());
		narudzbenica.setOglasId(dto.getNarudzbenica().getOglasId());
		narudzbenica.setAgentId(dto.getNarudzbenica().getAgentId());
		narudzbenica.setRezervacijaId(savedRezervacija.getId());
		
		//Kreirao se commonData za narudzbenicu (uglovani user je kreira)
		CommonData commonDataNarudzb = setCommonData(loggedUser.getId());
		narudzbenica.setCommonDataId(commonDataNarudzb.getId());
		
		narudzbenica = narudzbService.addNarudzbenica(narudzbenica);
		
		setOtherReservationToCanceled(narudzbenica, loggedUser.getId());
		
		return new ResponseEntity<>(new RezervacijaNewDTO(savedRezervacija, new NarudzbenicaNewDTO(narudzbenica)), HttpStatus.CREATED);
	}
	

	//PUT
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.PUT, value="/rezervacija/status", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaStatusDTO> updateStatusRezervacija(@RequestBody RezervacijaStatusDTO dto) throws Exception{
		
		Rezervacija updatedRezervacija = rezervacijaService.findOne(dto.getRezervacijaId());
		if(updatedRezervacija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(dto.getStatusRezervacije().equals("CANCELED")) {
			
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
	
	//Pomocna metoda za kreiranje novog commonData
	public CommonData setCommonData(Long userId) throws Exception {
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId(userId); 
		commonData = comDataService.addCommonData(commonData);	
		return commonData;
	}
	
	//TODO Dodato
	/***
	 *  
	 * @param Narudzbenica rucno kreirane rezervacije...
	 * Pomocna metoda koja setuje status svih drugih rezervacija za isti termin na CANCELED
	 * @throws Exception 
	 */
	public void setOtherReservationToCanceled(Narudzbenica rucnaRezNar, Long id) throws Exception{
		List<Rezervacija> allRezervacija = rezervacijaService.getAllRezervacijaByIdAgenta(id);
		
		//Filtiriramo i vracamo samo one rezervacije ciji je status PENDING
		allRezervacija = rezervacijaService.getAllPendingRezervacije(allRezervacija);
		
		for(Rezervacija r : allRezervacija) {
			//Pruzimamo sve narudzbenice koje su vezane za tu rezervaciju
			List<Narudzbenica> narudzbenice = narudzbService.getAllNarudzbeniceByRezervId(r.getId());
			
			for(Narudzbenica n:narudzbenice) {
				//Provera da li su rezervacije za bas taj oglas
				if(rucnaRezNar.getOglasId() == n.getOglasId()) {
					if(!(rucnaRezNar.getOdDatuma().isAfter(n.getDoDatuma()) || rucnaRezNar.getDoDatuma().isBefore(n.getOdDatuma()))){
						r.setStatusRezervacije("CANCELED");
						rezervacijaService.updateRezervacija(r.getId(), r);
						break;
					}
				}
			}
		}
		
	}


}
