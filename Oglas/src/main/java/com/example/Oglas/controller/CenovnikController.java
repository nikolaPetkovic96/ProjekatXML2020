package com.example.Oglas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Oglas.dto.CenovnikDTO;
import com.example.Oglas.model.Cenovnik;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.repository.CenovnikRepository;
import com.example.Oglas.repository.OglasRepository;
import com.example.Oglas.service.CenovnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("price")
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(method=RequestMethod.GET, value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CenovnikDTO> getAllCenovnik(){
		return cenovnikService.getAllCenovniks();
 	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(method=RequestMethod.GET, value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CenovnikDTO getCenovnik(@PathVariable("id") Long id){
		return cenovnikService.getCenovnik(id);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(method=RequestMethod.POST, value="", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CenovnikDTO addCenovnik(@RequestBody CenovnikDTO cenovnikDTO) throws Exception{
		return cenovnikService.addCenovnik(cenovnikDTO);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(method=RequestMethod.PUT, value="", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CenovnikDTO updateAutomobil(@RequestBody CenovnikDTO cenovnikDTO) throws Exception{
		return cenovnikService.updateCenovnik(cenovnikDTO);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean deleteCenovnik(@PathVariable Long id){
		return cenovnikService.deleteCenovnik(id);
	}
	
	@Autowired
	private CenovnikRepository ogRep;
	@GetMapping(value="/sync")
	public List<Cenovnik> getAllOglasSync() {
		List<Cenovnik> all=ogRep.findAll();
		
		return all;	
		}
}
