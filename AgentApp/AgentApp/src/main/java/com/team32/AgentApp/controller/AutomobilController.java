package com.team32.AgentApp.controller;

import java.security.Principal;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.DTO.AutomobilReviewDTO;
import com.team32.AgentApp.DTO.AutomobilStatisticDTO;
import com.team32.AgentApp.DTO.KomentarDTO;
import com.team32.AgentApp.DTO.OcenaDTO;
import com.team32.AgentApp.DTO.ReviewDTO;
import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Komentar;
import com.team32.AgentApp.model.entitet.Ocena;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.AutomobilService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.KomentarService;
import com.team32.AgentApp.service.OcenaService;
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
	
	@RequestMapping(method=RequestMethod.GET, value="/automobil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutomobilDTO>> getAllAutomobil(){
		List<Automobil> allAutomobil = automobilService.getAllAutomobil();
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAutomobil) {
			
			automobilDTO.add(automobilService.findOneWithDetails(a.getId()));
			
		}
		return new ResponseEntity<>(automobilDTO, HttpStatus.OK);
	}
	
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
	
	//Ovo je za automobil details vise odradjeno...
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
			
			//Kreiramo dobavljamo komentare i ocene vezane za njega
			List<ReviewDTO> reviews = getAllReviewsByAutomobilId(a.getId(), username);
			
			automobilRewiewDTO.add(new AutomobilReviewDTO(autoDTO, reviews));
			
		}
		return new ResponseEntity<>(automobilRewiewDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/automobil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> getAutomobil(@PathVariable("id") Long id){
		Automobil automobil = automobilService.findOne(id);
		
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(automobilService.findOneWithDetails(automobil.getId()), HttpStatus.OK);
	}

	@RequestMapping(value="/automobil/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAutomobil(@PathVariable Long id){
		Automobil automobil = automobilService.findOne(id);
		if(automobil != null) {
			automobilService.deleteAutomobil(id);
			comDataService.deleteCommonData(automobil.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
	

//	@RequestMapping(method=RequestMethod.POST, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AutomobilDTO> addAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
//		Automobil savedAutomobil = new Automobil();
//		
//		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
//		CommonData commonData = new CommonData();
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
//		commonData.setDatumKreiranja(now);
//		commonData = comDataService.addCommonData(commonData);
//	
//		savedAutomobil.setId(automobilDTO.getId());
//		savedAutomobil.setMarkaAutomobilaId(automobilDTO.getMarkaAutomobilaId());
//		savedAutomobil.setModelAutomobilaId(automobilDTO.getModelAutomobilaId());
//		savedAutomobil.setKlasaAutomobilaId(automobilDTO.getKlasaAutomobilaId());
//		savedAutomobil.setTipGorivaId(automobilDTO.getTipGorivaId());
//		savedAutomobil.setTipMenjacaId(automobilDTO.getTipMenjacaId());
//		savedAutomobil.setUkupnaOcena(automobilDTO.getTipMenjacaId());
//		savedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
//		savedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
//		savedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
//		
//		savedAutomobil.setCommonDataId(commonData.getId());
//		
//		savedAutomobil = automobilService.addAutomobil(savedAutomobil);
//		return new ResponseEntity<>(new AutomobilDTO(savedAutomobil), HttpStatus.CREATED);
//	}
//	
//	@RequestMapping(method=RequestMethod.PUT, value="/automobil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AutomobilDTO> updateAutomobil(@RequestBody AutomobilDTO automobilDTO) throws Exception{
//		
//		Automobil updatedAutomobil = automobilService.findOne(automobilDTO.getId());
//		if(updatedAutomobil == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		Long comDatId = updatedAutomobil.getCommonDataId();
//		
//		CommonData commonData = comDataService.findOne(comDatId);
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setDatumIzmene(now);
//		commonData = comDataService.updateCommonData(comDatId, commonData);
//		
//		updatedAutomobil.setId(automobilDTO.getId());
//		updatedAutomobil.setBrojSedistaZaDecu(automobilDTO.getBrojSedistaZaDecu());
//		updatedAutomobil.setCollisionDamageWaiver(automobilDTO.isCollisionDamageWaiver());
//		updatedAutomobil.setPredjenaKilometraza(automobilDTO.getPredjenaKilometraza());
//		
//		updatedAutomobil.setMarkaAutomobilaId(automobilDTO.getMarkaAutomobilaId());
//		updatedAutomobil.setModelAutomobilaId(automobilDTO.getModelAutomobilaId());
//		updatedAutomobil.setKlasaAutomobilaId(automobilDTO.getKlasaAutomobilaId());
//		updatedAutomobil.setTipGorivaId(automobilDTO.getTipGorivaId());
//		updatedAutomobil.setTipMenjacaId(automobilDTO.getTipMenjacaId());
//		updatedAutomobil.setUkupnaOcena(automobilDTO.getTipMenjacaId());
//		
//		updatedAutomobil.setCommonDataId(comDatId);
//	
//		updatedAutomobil = automobilService.updateAutomobil(updatedAutomobil.getId(), updatedAutomobil);
//		return new ResponseEntity<>(new AutomobilDTO(updatedAutomobil),HttpStatus.OK);
//	}

}