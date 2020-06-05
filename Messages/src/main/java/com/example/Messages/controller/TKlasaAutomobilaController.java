package com.example.Messages.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Messages.DTO.TKlasaAutomobilaDTO;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.service.TKlasaAutomobilaService;

@RestController
public class TKlasaAutomobilaController {
	@Autowired
	private TKlasaAutomobilaService service;
	
	//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/TKlasaAutomobila", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<TKlasaAutomobilaDTO>> getAllKlasaAutomobila() {
			List<TKlasaAutomobila> all = service.getAllTKlasaAutomobila();
			
			List<TKlasaAutomobilaDTO> dto = new ArrayList<>();
			for(TKlasaAutomobila tm : all )
				dto.add(new TKlasaAutomobilaDTO(tm));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}

}
