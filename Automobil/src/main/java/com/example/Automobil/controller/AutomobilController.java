package com.example.Automobil.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.dto.AutomobilPomDTO;
import com.example.Automobil.dto.AutomobilDetailsDTO;
import com.example.Automobil.dto.AutomobilImgDTO;
import com.example.Automobil.dto.AutomobilNewDTO;
import com.example.Automobil.model.Automobil;
import com.example.Automobil.service.AutomobilService;

@RestController
@RequestMapping("car")
public class AutomobilController {
	
	@Autowired
	private AutomobilService autoService;
	
	@GetMapping("")
	public List<AutomobilPomDTO> getAll() {
		return autoService.getAllAutomobil();
	}
	
	@GetMapping("/agent")
	public List<AutomobilDTO> getAllAgentsAutomobil() {
		
		return autoService.getAllAutomobilByAgent();
	}
	
	//Ako se pojavi ovaj error u browser konzoli:
	//XML Parsing Error: no root element found
	//Location: http://localhost:2020/automobil-service/car/agent/search?&markaAut=Fiat&markaAut=Fiat
	//Line Number 1, Column 1:
	//Moraju se argumetni RequestParam u Optional<>
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/agent/search", method = RequestMethod.GET)
	public List<AutomobilDTO> searchAgentsAutomobil(
			@RequestParam("markaAut") Optional<Long> markaAutId,
			@RequestParam("modelAut") Optional<Long> modelAutId,
			@RequestParam("klasaAut") Optional<Long> klasaAutId,
			@RequestParam("tipMenjaca") Optional<Long> tipMenjacaId,
			@RequestParam("tipGoriva") Optional<Long> tipGorivaId,
			@RequestParam("brojSedZaDec") Optional<Integer> brojSedZaDec,
			@RequestParam("ColDmgWaiv") Optional<Boolean> ColDmgWaiv,
			@RequestParam("kilometraza") Optional<Float> kilometraza
			){
		
		return autoService.searchAgentsAutomobil(markaAutId.orElse(null), modelAutId.orElse(null), klasaAutId.orElse(null),
			tipMenjacaId.orElse(null), tipGorivaId.orElse(null), brojSedZaDec.orElse(null), ColDmgWaiv.orElse(null),kilometraza.orElse(null));
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(method=RequestMethod.POST, value="/agent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AutomobilImgDTO addAutomobil(Principal principal, @RequestBody AutomobilNewDTO dto) throws Exception{
		return autoService.addNewAutomobil(dto);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	//Ovo je za automobil details vise odradjeno...
	@RequestMapping(method=RequestMethod.GET, value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AutomobilDTO getAutomobil(@PathVariable("id") Long id) throws Exception{
		
		return autoService.findOneDTO(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	//Ovo je za automobil details vise odradjeno...
	@RequestMapping(method=RequestMethod.GET, value="/{id}/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public AutomobilImgDTO getAutomobilDetails(@PathVariable("id") Long id) throws Exception{
		
		return autoService.findOneWithDetails(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(method=RequestMethod.PUT, value="", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AutomobilDTO updateAutomobil(@RequestBody AutomobilNewDTO dto) throws Exception{
		
		return autoService.updAutomobil(dto);
		
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAutomobil(@PathVariable Long id) throws Exception{
		
		return autoService.deleteAutomobil(id);
	}
	
}
