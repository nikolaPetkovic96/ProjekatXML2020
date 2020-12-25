package com.example.Automobil.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Automobil.model.TModelAutomobila;
import com.example.Automobil.service.CarModelService;

@RestController
@RequestMapping("model")
public class CarModelController {
	@Autowired
	private CarModelService carBrandService;

	@GetMapping("")
	public List<TModelAutomobila> getAll(@RequestParam("model") Optional<Long> model) {
		return carBrandService.getAll(model.orElse(null));
	}

	@PostMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public TModelAutomobila addNew(@RequestBody TModelAutomobila t) {
		return carBrandService.addNew(t);
	}

	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public boolean delete(@PathVariable(name = "id") Long t) {
		return carBrandService.deleteOne(t);
	}

	@PutMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public TModelAutomobila change(@RequestBody TModelAutomobila t) {
		return carBrandService.changeOne(t);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	public void conflict() {

	}

}
