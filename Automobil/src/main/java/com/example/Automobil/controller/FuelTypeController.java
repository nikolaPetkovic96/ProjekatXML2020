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

import com.example.Automobil.model.TTipGoriva;
import com.example.Automobil.service.FuelTypeService;

@RestController
@RequestMapping("fuel")
public class FuelTypeController {
	@Autowired
	private FuelTypeService fuelTypeService;

	@GetMapping("")
	public List<TTipGoriva> getAll() {
		return fuelTypeService.getAll();
	}

	@PostMapping("")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public TTipGoriva addNew(@RequestBody TTipGoriva t) {
		return fuelTypeService.addNew(t);
	}

	@DeleteMapping("{id}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public boolean delete(@PathVariable(name = "id") Long t) {
		return fuelTypeService.deleteOne(t);
	}

	@PutMapping("")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public TTipGoriva change(@RequestBody TTipGoriva t) {
		return fuelTypeService.changeOne(t);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	public void conflict() {

	}

}
