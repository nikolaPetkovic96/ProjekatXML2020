package com.example.Messages2.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.PorukaRepository;
import com.example.Messages2.service.PorukaService;
import com.example.Messages2.service.mapper.PorukaMapper;

@RestController
@RequestMapping(value = "/messsage")
public class PorukaController {
	@Autowired
	private PorukaService porService;
	
	@GetMapping(value = "")
	public List<PorukaDTO> getPoruke(	@RequestParam(name = "rez_id", required = false) Long rezId
			){
		return porService.getAllMessages(rezId);
	}
	@GetMapping(value = "/{id}")
	public PorukaDTO getPoruka(	@PathVariable("id") Long id
			){
		return porService.getPoruka(id);
	}
	@PostMapping(value = "")
	public PorukaDTO addPoruka(@RequestBody PorukaDTO por) {
		return porService.createPoruka(por);
	}
	@DeleteMapping("/{id}")
	public void deletePoruka(	@PathVariable("id") Long id) {
		 porService.deletePoruka(id);
	}
}
