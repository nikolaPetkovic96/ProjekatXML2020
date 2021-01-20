package com.example.Oglas.controller;

import java.security.Principal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.dto.OglasDetailsImgDTO;
import com.example.Oglas.dto.OglasNewDTO;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.OglasRepository;
import com.example.Oglas.repository.TAdresaRepository;
import com.example.Oglas.service.CommonDataService;
import com.example.Oglas.service.NarudzbenicaService;
import com.example.Oglas.service.OglasService;

@RestController
@RequestMapping(value="/ads")		//Nema UPDATE, za izmenu bi se morao obrisati ceo oglas pa postaviti novi, 
public class OglasController {		//za pokretanje i testiranje eureka, zuul, loginReg,Automobil, oglas
	@Autowired
	private OglasService oglasService;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private NarudzbenicaService narudzbService;
	@Autowired
	private TAdresaRepository adresaRep;
	
		
	@GetMapping(value="")
	public ResponseEntity<List<OglasDTO>> getAllOglas() {
		List<OglasDTO> all=oglasService.getAll();
		if(all!=null)
			return new ResponseEntity<>(all, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/numberOfAds")
	public int getNumberOfAds() {
		return  oglasService.getNumberOfAds();
	}
	
	@GetMapping(value="/agent")
	public ResponseEntity<List<OglasDTO>> getAllAgentsOglas() {
		
		List<OglasDTO> all=oglasService.getOglaseForUser();
		if(all!=null)
			return new ResponseEntity<>(all, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<OglasDTO> getOglas(@PathVariable("id") Long id){
		OglasDTO o=oglasService.getOglas(id);
		if(o!=null)
			return new ResponseEntity<>(o, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value= "/{id}/details")		//todo
	public ResponseEntity<OglasDetailsImgDTO> getOglasDetails(@PathVariable("id") Long id) throws Exception{
		OglasDetailsImgDTO o = oglasService.getOglasDetails(id);
		if(o!=null)
			return new ResponseEntity<>(o, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/img")
	List<OglasDetailsImgDTO> getAllOglasWithImg(Principal principal) throws Exception{
		return oglasService.getAllWithImages();
	}
	

	@PostMapping(value="")
	public ResponseEntity<?> addOglas(Principal principal, @RequestBody OglasNewDTO dto)  throws Exception {
		String username = principal.getName();
		return oglasService.addOglas(dto, username);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteOglas(@PathVariable Long id) {
		return oglasService.deleteOglas(id);
	}	
	
	@GetMapping(value="search")
	public List<OglasDetailsImgDTO> searchOglas(
			@RequestParam("markaAut") Optional<Long> markaAutId,
			@RequestParam("modelAut") Optional<Long> modelAutId,
			@RequestParam("klasaAut") Optional<Long> klasaAutId,
			@RequestParam("tipMenjaca") Optional<Long> tipMenjacaId,
			@RequestParam("tipGoriva") Optional<Long> tipGorivaId,
			@RequestParam("brojSedZaDec") Optional<Integer> brojSedZaDec,
			@RequestParam("ColDmgWaiv") Optional<Boolean> ColDmgWaiv,
			@RequestParam("kilometraza") Optional<Float> kilometraza,
			@RequestParam("cenaMin") Optional<Float> cenaMin,
			@RequestParam("cenaMax") Optional<Float> cenaMax,
			@RequestParam("od") Optional<Long> odDatum,
			@RequestParam("do") Optional<Long> doDatum
			,Principal principal) throws Exception{
		String username = principal.getName();
		
		//Mora ova konverzija zato sto puca sa fronta error ako se ne stave odDatum i doDatum u Optional<>
		//A kada se stave u Optional<> onda puca Instant.ofEpocheMilli jer ne moze da radi sa Optional<> tipom
		Long odDat = odDatum.orElse(null);
		Long doDat = doDatum.orElse(null);
		
		LocalDateTime odDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(odDat), TimeZone.getDefault().toZoneId());
		LocalDateTime doDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(doDat), TimeZone.getDefault().toZoneId());
		
		return oglasService.pretragaOglasa(markaAutId.orElse(null),modelAutId.orElse(null),klasaAutId.orElse(null),
											tipMenjacaId.orElse(null),tipGorivaId.orElse(null),brojSedZaDec.orElse(null),
											ColDmgWaiv.orElse(null),kilometraza.orElse(null),
											cenaMin.orElse(null),cenaMax.orElse(null),
											odDatuma ,doDatuma
											,username);
	}
	
	@Autowired
	private OglasRepository ogRep;
	@GetMapping(value="/sync")
	public List<Oglas> getAllOglasSync() {
		List<Oglas> all=ogRep.findAll();
		return all;	
		}
	@Autowired
	private CommonDataRepository cmdRep;
	@GetMapping(value="/sync/cmd")
	public List<CommonData> syncCommonData(){
		return cmdRep.findAll();
	}
}
