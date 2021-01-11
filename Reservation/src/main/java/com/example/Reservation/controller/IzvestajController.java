package com.example.Reservation.controller;

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

import com.example.Reservation.dto.IzvestajDTO;
import com.example.Reservation.repository.service.IzvestajService;

@RestController
@RequestMapping(value="/izvestaj")
public class IzvestajController {
	@Autowired
	private IzvestajService izvServ;
	
	@GetMapping(value="")
	public List<IzvestajDTO> getAllIzvestaj(){
		return izvServ.getAll();
	}
	@GetMapping(value="/{id}")
	public IzvestajDTO getIzvestaj(@PathVariable("id") Long id) throws Exception {
		return izvServ.getOne(id);
	}
	
	@PostMapping(value="")
	public IzvestajDTO addIzvestaj(Principal principal, @RequestBody IzvestajDTO dto) throws Exception {
		return izvServ.addIZvestaj(dto,principal.getName());
	}
	@PutMapping(value="/")
	public IzvestajDTO updateIzvestaj(@RequestBody IzvestajDTO dto) throws Exception {
		return izvServ.updateIzvestaj(dto);
	}
	@DeleteMapping(value="/{id}")
	public Void deleteIzvestaj(@PathVariable Long id) throws Exception {
		return izvServ.deleteIzvestaj(id);
	}
}
