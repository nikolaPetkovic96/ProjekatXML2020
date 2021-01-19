package com.team32.AgentApp.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.DTO.AutomobilDetailsDTO;
import com.team32.AgentApp.DTO.AutomobilImgDTO;
import com.team32.AgentApp.DTO.AutomobilNewDTO;
import com.team32.AgentApp.DTO.AutomobilReviewDTO;
import com.team32.AgentApp.DTO.AutomobilStatisticDTO;
import com.team32.AgentApp.DTO.KomentarDTO;
import com.team32.AgentApp.DTO.OcenaDTO;
import com.team32.AgentApp.DTO.ReviewDTO;
import com.team32.AgentApp.DTO.SlikaVozilaDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Komentar;
import com.team32.AgentApp.model.entitet.Ocena;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.tentitet.SlikaVozila;
import com.team32.AgentApp.service.AutomobilService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.KomentarService;
import com.team32.AgentApp.service.OcenaService;
import com.team32.AgentApp.service.OglasService;
import com.team32.AgentApp.service.SlikaVozilaService;
import com.team32.AgentApp.service.UserService;

@RestController
public class AutomobilController {
	
	@Autowired
	private AutomobilService automobilService;	
	
	@Autowired
	private CommonDataService comDataService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private OcenaService ocenaService;
	
	@Autowired
	private SlikaVozilaService slikaVozService;
	
	@Autowired
	private OglasService oglasService;
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/automobil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilDTO>> getAllAutomobil(Principal principal){
		//Preuzima se user iz sesije koji je trenutno ulogovan
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		List<Automobil> allAgentsAutomobil = automobilService.getAllAutomobilByAgent(loggedAgent.getId());
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAgentsAutomobil) {
			
			automobilDTO.add(automobilService.findOneWithDetails(a.getId()));
			
		}
		return new ResponseEntity<>(automobilDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	//Vraca najbolja 3 automobila po nekom parametru 
	@RequestMapping(method=RequestMethod.GET, value="/automobil/best/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilStatisticDTO>> getAllBestAutomobil(Principal principal, @PathVariable("category") String category){
		
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		List<Automobil> allAutomobil = automobilService.getAllAutomobilByAgent(loggedAgent.getId());
		List<AutomobilStatisticDTO> autoStatDTO = new ArrayList<>();
		
		if(category.equals("comment")) {
			autoStatDTO = automobilService.getBestAutomobilByComment(category, allAutomobil );
			return new ResponseEntity<>(autoStatDTO, HttpStatus.OK);
		}
		if(category.equals("km")) {
			allAutomobil = automobilService.getBestAutomobilByKm(category, allAutomobil);
		}
		else if(category.equals("rating")) {
			allAutomobil = automobilService.getBestAutomobilByRating(category, allAutomobil );
		}
		

		for(Automobil a : allAutomobil) {
			
			autoStatDTO.add(automobilService.findOneWithStat(a.getId()));
			
		}
		return new ResponseEntity<>(autoStatDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	//Ovo je za automobil details vise odradjeno...
	@RequestMapping(method=RequestMethod.GET, value="/automobil/{id}/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDetailsDTO> getAutomobilDetails(Principal principal, @PathVariable("id") Long id) throws Exception{
		
		//Preuzima se user iz sesije koji je trenutno ulogovan
		String username = principal.getName();
		
		AutomobilDTO autoDTO = automobilService.findOneWithDetails(id);
		
		List<ReviewDTO> reviews = new ArrayList<>();
		//Kreiramo review = dobavljamo komentare i ocene vezane za njega
		if(getAllReviewsByAutomobilId(id, username) != null) {
			reviews = getAllReviewsByAutomobilId(id, username);
		}
		
		//Dobavljamo slike koje su vezane za njega
		SlikaVozila s = slikaVozService.getSlikaVozilaByAutomobilId(id);
		SlikaVozilaDTO slike = new SlikaVozilaDTO(s);

			
		return new ResponseEntity<>(new AutomobilDetailsDTO(autoDTO, reviews, slike), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/automobilReview", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilReviewDTO>> getAllAutomobilReviews(Principal principal){
		
		//Preuzima se user iz sesije koji je trenutno ulogovan
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		List<Automobil> allAgentsAutomobil = automobilService.getAllAutomobilByAgent(loggedAgent.getId());
		
		List<AutomobilReviewDTO> automobilRewiewDTO = new ArrayList<>();
		for(Automobil a : allAgentsAutomobil) {
			//Popunjavamo automobil podacima iz modela
			AutomobilDTO autoDTO = automobilService.findOneWithDetails(a.getId());
			
			List<ReviewDTO> reviews = new ArrayList<>();
			//Kreiramo review = dobavljamo komentare i ocene vezane za njega
			if(getAllReviewsByAutomobilId(a.getId(), username) != null) {
				reviews = getAllReviewsByAutomobilId(a.getId(), username);
			}
			
			automobilRewiewDTO.add(new AutomobilReviewDTO(autoDTO, reviews));
			
		}
		return new ResponseEntity<>(automobilRewiewDTO, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilDTO>> searchApartments(Principal principal,
			@RequestParam(value="markaAut", required=false) Long markaAutId,
			@RequestParam(value="modelAut", required=false) Long modelAutId,
			@RequestParam(value="klasaAut", required=false) Long klasaAutId,
			@RequestParam(value="tipMenjaca", required=false) Long tipMenjacaId,
			@RequestParam(value="tipGoriva", required=false) Long tipGorivaId,
			@RequestParam(value="brojSedZaDec", required=false) Integer brojSedZaDec,
			@RequestParam(value="ColDmgWaiv", required=false) Boolean ColDmgWaiv,
			@RequestParam(value="kilometraza", required=false) Float kilometraza
			){

    	//Obrisati na kraju
    	System.out.println("markaAut " + markaAutId);
    	System.out.println("modelAut: " + modelAutId);
    	System.out.println("klasaAut: " + klasaAutId);
    	System.out.println("tipMenjaca: " + tipMenjacaId);
    	System.out.println("tipGoriva: " + tipGorivaId);
    	System.out.println("brojSedZaDec: " + brojSedZaDec);
		System.out.println("ColDmgWaiv: " + ColDmgWaiv);
		System.out.println("kilometraza: " + kilometraza);

		//Preuzima se user iz sesije koji je trenutno ulogovan
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		List<Automobil> allAgentsAutomobil = automobilService.getAllAutomobilByAgent(loggedAgent.getId());


		if(markaAutId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getMarkaAutomobilaId() == markaAutId)
					.collect(Collectors.toList());
		}
		if(modelAutId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
				.filter(a -> a.getModelAutomobilaId() == modelAutId)
				.collect(Collectors.toList());
		}
		if(klasaAutId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
				.filter(a -> a.getKlasaAutomobilaId() == klasaAutId)
				.collect(Collectors.toList());
		}
		if(tipMenjacaId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
				.filter(a -> a.getTipMenjacaId() == tipMenjacaId)
				.collect(Collectors.toList());
		}
		if (tipGorivaId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getTipGorivaId() == tipGorivaId)
					.collect(Collectors.toList());
		}
		if (brojSedZaDec != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getBrojSedistaZaDecu() == brojSedZaDec)
					.collect(Collectors.toList());
		}
		if (ColDmgWaiv != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.isCollisionDamageWaiver() == ColDmgWaiv)
					.collect(Collectors.toList());
		}
		if (kilometraza != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getPredjenaKilometraza() <= kilometraza)
					.collect(Collectors.toList());
		}
		
		//Oni automobili koji su zadovoljili uslove se prebacuju u DTO
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAgentsAutomobil) {
			
			automobilDTO.add(automobilService.findOneWithDetails(a.getId()));
			
		}

		return new ResponseEntity<>(automobilDTO, HttpStatus.OK);
    }
	
	
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/automobil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> getAutomobil(@PathVariable("id") Long id){
		Automobil automobil = automobilService.findOne(id);
		
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(automobilService.findOneWithDetails(automobil.getId()), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(value="/automobil/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAutomobil(@PathVariable Long id) throws Exception{
		Automobil automobil = automobilService.findOne(id);
		if(automobil != null) {
			
			//Provera da li postoji neki oglas kreiran za taj automobil
			if(oglasService.getAllOglasByAutomobilId(automobil.getId()).size() != 0) {
				throw new Exception("There is an ad connected to this car!");
			}
			
			automobilService.deleteAutomobil(id);
			comDataService.deleteCommonData(automobil.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.POST, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilImgDTO> addAutomobil(Principal principal, @RequestBody AutomobilNewDTO dto) throws Exception{
		Automobil savedAutomobil = new Automobil();
		
		System.out.println("Usao u add automobil!");
		//Preuzima se user iz sesije koji je trenutno ulogovan
		String username = principal.getName();
		User loggedAgent = userService.findByUsername(username);
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = setCommonData(loggedAgent.getId());
	
		savedAutomobil.setId(dto.getId());
		savedAutomobil.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
		savedAutomobil.setModelAutomobilaId(dto.getModelAutomobilaId());
		savedAutomobil.setKlasaAutomobilaId(dto.getKlasaAutomobilaId());
		savedAutomobil.setTipGorivaId(dto.getTipGorivaId());
		savedAutomobil.setTipMenjacaId(dto.getTipMenjacaId());
		savedAutomobil.setUkupnaOcena(dto.getUkupnaOcena());
		savedAutomobil.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		savedAutomobil.setCollisionDamageWaiver(dto.isCollisionDamageWaiver());
		savedAutomobil.setBrojSedistaZaDecu(dto.getBrojSedistaZaDecu());
		savedAutomobil.setCommonDataId(commonData.getId());
		
		savedAutomobil = automobilService.addAutomobil(savedAutomobil);
		
		//SLIKE
		CommonData commonDataImg = setCommonData(loggedAgent.getId());
		SlikaVozila slikaVozila = new SlikaVozila();
		slikaVozila.setSlika(dto.getSlikeVozila());
		slikaVozila.setCommonDataId(commonDataImg.getId());
		slikaVozila.setAutomobilId(savedAutomobil.getId());
		
		slikaVozila = slikaVozService.addSlikaVozila(slikaVozila);
		
		AutomobilDTO autoDto = automobilService.findOneWithDetails(savedAutomobil.getId());
		return new ResponseEntity<>(new AutomobilImgDTO(autoDto, new SlikaVozilaDTO(slikaVozila)), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.PUT, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> updateAutomobil(@RequestBody AutomobilNewDTO dto) throws Exception{
		
		Automobil updatedAutomobil = automobilService.findOne(dto.getId());
		if(updatedAutomobil == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updatedAutomobil.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updatedAutomobil.setId(dto.getId());
		updatedAutomobil.setBrojSedistaZaDecu(dto.getBrojSedistaZaDecu());
		updatedAutomobil.setCollisionDamageWaiver(dto.isCollisionDamageWaiver());
		updatedAutomobil.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		
		updatedAutomobil.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
		updatedAutomobil.setModelAutomobilaId(dto.getModelAutomobilaId());
		updatedAutomobil.setKlasaAutomobilaId(dto.getKlasaAutomobilaId());
		updatedAutomobil.setTipGorivaId(dto.getTipGorivaId());
		updatedAutomobil.setTipMenjacaId(dto.getTipMenjacaId());
		updatedAutomobil.setUkupnaOcena(dto.getUkupnaOcena());
		
		updatedAutomobil.setCommonDataId(comDatId);

		updatedAutomobil = automobilService.updateAutomobil(updatedAutomobil.getId(), updatedAutomobil);
		
		AutomobilDTO auto = automobilService.findOneWithDetails(updatedAutomobil.getId());
		
		//svejedno je sta cemo vratiti kod update
		return new ResponseEntity<>(auto,HttpStatus.OK);
	}
	
	public List<ReviewDTO> getAllReviewsByAutomobilId(Long autoId, String loggedUsername){
		List<ReviewDTO> reviews = new ArrayList<>();
		
		//Komentari i ocene se poklapaju po 2 kriterijuma po automobilu i po rezervaciji
		//Vadimo sve komentare i rezervacije za jedan isti automobil;
		List<Komentar> sviKomentAutomob = komentarService.getAllKomentarByAutomobilId(autoId);
		List<Ocena> sveOceneAutomob = ocenaService.getAllOcenaByAutomobilId(autoId);
		
		//Prolazimo kroz rezulat i proveravamo koji od njih pripadaju istoj rezervaciji
		for(Komentar k : sviKomentAutomob) {
			//Provera da li je komentar ostavio sam agent (onda nema ocene)
			CommonData comData = comDataService.findOne(k.getCommonDataId());
			User u = userService.findOne(comData.getUserid());
			
			if(u.getKorisnickoIme().equals(loggedUsername)  && k.isOdobren() == true) {
				reviews.add(new ReviewDTO(new KomentarDTO(k, u.getKorisnickoIme())));
				continue;
			}
			for(Ocena o : sveOceneAutomob) {
				if(k.getRezervacijaId() == o.getRezervacijaId() && k.isOdobren() == true) {
					
					reviews.add(new ReviewDTO(new OcenaDTO(o), new KomentarDTO(k, u.getKorisnickoIme())));
				}
			}
		}
		
		return reviews;
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


}