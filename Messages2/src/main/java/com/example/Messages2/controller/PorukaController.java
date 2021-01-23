package com.example.Messages2.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Messages2.dto.CommonDataDTO;
import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.CommonData;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.PorukaRepository;
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
	//test
	@PostMapping(value = "/proba")
	public PorukaDTO addPoruka() throws Exception {
		String username = "TESTUSER";
		PorukaDTO dto=new PorukaDTO(new Poruka(null, "proba", Long.parseLong("1"), Long.parseLong("1"), null, username), new CommonDataDTO());
		return porService.createPoruka(dto, username);
	}
	@Autowired
	private PorukaRepository pRep;
	@PutMapping(value = "/proba/{id}/{id2}")
	public Poruka editPoruka(@PathVariable("id") Long id, @PathVariable("id2") Long newId) throws Exception {
		Poruka stara=pRep.findById(id).orElse(null);
		Poruka nova=new Poruka(newId, stara.getTekstPoruke(), stara.getRezervacijaId(), stara.getAutomobilId(), stara.getCommonDataId(), stara.getUsername());
		nova.setId(newId);
		porService.deletePoruka(stara.getId());
		nova=porService.updatePoruka(stara,nova);
		return nova;
	}
	
}
