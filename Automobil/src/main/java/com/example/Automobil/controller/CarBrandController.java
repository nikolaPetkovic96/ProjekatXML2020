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

import com.example.Automobil.model.TMarkaAutomobila;
import com.example.Automobil.service.CarBrandService;

@RestController
@RequestMapping("brand")
public class CarBrandController {
	@Autowired
	private CarBrandService carBrandService;

	@GetMapping("")
	public List<TMarkaAutomobila> getAll() {
		return carBrandService.getAll();
	}
	
	@GetMapping("test")
	public String test() {
		return "RADI";
	}

	@PostMapping("")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public TMarkaAutomobila addNew(@RequestBody TMarkaAutomobila t) {
		return carBrandService.addNew(t);
	}

	@DeleteMapping("{id}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@PathVariable(name = "id") Long t) {
		return carBrandService.deleteOne(t);
	}

	@PutMapping("")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public TMarkaAutomobila change(@RequestBody TMarkaAutomobila t) {
		return carBrandService.changeOne(t);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	public void conflict() {

	}

}
