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
	
	@GetMapping(value = "/pretraga")
	public List<OglasDTO>getOglase(	@RequestParam(name = "odDatum", required = false) String odDatum,
									@RequestParam(name = "doDatum", required = false) String doDatum,
									@RequestParam(name = "cenaKmMin", required = true) int cenaKmMin,
									@RequestParam(name = "cenaKmMax", required = true) int cenaKmMax,
									@RequestParam(name = "cenaDanMin", required = true) int cenaDanMin,
									@RequestParam(name = "cenaDanMax", required = true) int cenaDanMax,
									@RequestParam(name = "collisionDamageWaiver", required = false) Boolean collisiondamageWaiver,
									@RequestParam(name = "popustPreko30Dana", required = true) int popustPreko30dana,
									@RequestParam(name = "predjenaKm", required = true) int predjenaKm,
									@RequestParam(name = "planiranaKm", required = true) int planiranaKm,
									@RequestParam(name = "brojSedistaZaDecu", required = true) int brojSedistaZaDecu,
									@RequestParam(name = "mesto", required = false) String mesto,
									@RequestParam(name = "ulica", required = false) String ulica,
									@RequestParam(name = "nazivKlase", required = false) String nazivKlase,
									@RequestParam(name = "nazivMarke", required = false) String nazivMarke,
									@RequestParam(name = "nazivModela", required = false) String nazivModela,
									@RequestParam(name = "nazivGoriva", required = false) String nazivGoriva,
									@RequestParam(name = "nazivMenjaca", required = false) String nazivMenjaca	
			){
		LocalDateTime odDatum1=LocalDateTime.now();
		LocalDateTime doDatum1=LocalDateTime.now();

		return pretragaService.getOglase(odDatum1, doDatum1, 
											cenaKmMin, cenaKmMax,cenaDanMin, cenaDanMax, collisiondamageWaiver, popustPreko30dana, 
											predjenaKm, planiranaKm, brojSedistaZaDecu, mesto, 
											ulica, nazivKlase, nazivMarke, nazivModela, nazivGoriva, nazivMenjaca);
	}
	@GetMapping(value = "/all")
	public List<OglasDTO> getAll(){
		return pretragaService.getAllOglas();
	}
}
