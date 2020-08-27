package com.example.Pretraga.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pretraga.dto.OglasDTO;
import com.example.Pretraga.service.PretragaService;

@RestController
@RequestMapping(value = "/search")
public class PretragaController {
	
	@Autowired
	private PretragaService pretragaService;
	
	@GetMapping(value = "")
	public List<OglasDTO>getOglase(	@RequestParam(name = "odDatum", required = false) LocalDateTime odDatum,
									@RequestParam(name = "doDatum", required = false) LocalDateTime doDatum,
									@RequestParam(name = "cenaKmMin", required = false) int cenaKmMin,
									@RequestParam(name = "cenaKmMax", required = false) int cenaKmMax,
									@RequestParam(name = "collisionDamageWaiver", required = false) Boolean collisiondamageWaiver,
									@RequestParam(name = "popustPreko30Dana", required = false) int popustPreko30dana,
									@RequestParam(name = "predjenaKm", required = false) int predjenaKm,
									@RequestParam(name = "planiranaKm", required = false) int planiranaKm,
									@RequestParam(name = "brojSedistaZaDecu", required = false) int brojSedistaZaDecu,
									@RequestParam(name = "mesto", required = false) String mesto,
									@RequestParam(name = "ulica", required = false) String ulica,
									@RequestParam(name = "nazivKlase", required = false) String nazivKlase,
									@RequestParam(name = "nazivMarke", required = false) String nazivMarke,
									@RequestParam(name = "nazivModela", required = false) String nazivModela,
									@RequestParam(name = "nazivGoriva", required = false) String nazivGoriva,
									@RequestParam(name = "nazivMenjaca", required = false) String nazivMenjaca	
			){
		
		return null;
	}
}
