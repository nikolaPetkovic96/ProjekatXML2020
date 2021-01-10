package com.example.Messages2.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.service.PorukaService;

@RestController
@RequestMapping(value = "/message")
public class PorukaController {
	@Autowired
	private PorukaService porService;
	
	@GetMapping(value = "")
	public List<PorukaDTO> getPoruke(){
		return porService.getAllMessages();
	}
	
	@GetMapping(value = "/reservation/{id}")
	public List<PorukaDTO> getPoruke(@PathVariable("id") Long id){
		return porService.getAllMessagesByRezerv(id);
	}
	
	@GetMapping(value = "/{id}")
	public PorukaDTO getPoruka(@PathVariable("id") Long id){
		return porService.getPoruka(id);
	}
	@PostMapping(value = "")
	public PorukaDTO addPoruka(Principal principal, @RequestBody PorukaDTO por) throws Exception {
		String username = principal.getName();
		return porService.createPoruka(por, username);
	}
	
	@DeleteMapping("/{id}")
	public void deletePoruka(@PathVariable("id") Long id) {
		 porService.deletePoruka(id);
	}
}
