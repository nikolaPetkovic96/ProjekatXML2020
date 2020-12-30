package com.example.Automobil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Automobil.model.TTipMenjaca;
import com.example.Automobil.service.TransmissionService;

@RestController
@RequestMapping("transmission")
public class TransmissionController {
	@Autowired
	private TransmissionService fuelTypeService;

	@GetMapping("")
	public List<TTipMenjaca> getAll() {
		return fuelTypeService.getAll();
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("")
	public TTipMenjaca addNew(@RequestBody TTipMenjaca t) {
		return fuelTypeService.addNew(t);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("{id}")
	public boolean delete(@PathVariable(name = "id") Long t) {
		return fuelTypeService.deleteOne(t);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("")
	public TTipMenjaca change(@RequestBody TTipMenjaca t) {
		return fuelTypeService.changeOne(t);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	public void conflict() {

	}

}
