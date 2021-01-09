package com.example.Oglas.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.dto.AutomobilDTO;
import com.example.Oglas.dto.AutomobilImgDTO;
import com.example.Oglas.dto.TSlikaVozilaDTO;
import com.example.Oglas.model.Automobil;
import com.example.Oglas.model.auto.TSlikaVozila;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.auto.TKlasaAutomobilaRepository;
import com.example.Oglas.repository.auto.TMarkaAutomobilaRepository;
import com.example.Oglas.repository.auto.TModelAutomobilaRepository;
import com.example.Oglas.repository.auto.TTipGorivaRepository;

import com.example.Oglas.repository.auto.TTipMenjacaRepository;
import com.example.Oglas.service.TSlikaVozilaService;


@Component
public class AutomobilMapper {

	@Autowired
	private CommonDataRepository cmdRep;
	// @Autowired
	// private TUserRepository tUserRep;
	@Autowired
	private TMarkaAutomobilaRepository markaRep;
	@Autowired
	private TModelAutomobilaRepository modelRep;
	@Autowired
	private TKlasaAutomobilaRepository klasaRep;
	@Autowired
	private TTipGorivaRepository tipGorivaRep;
	@Autowired
	private TTipMenjacaRepository tipMenjacaRep;
	@Autowired
	private TSlikaVozilaService slikaServ;
	
	
	public AutomobilDTO toDTO(Automobil a) {
		String marka = markaRep.findById(a.getMarkaAutomobilaId()).get().getNazivMarke();
		String model = modelRep.findById(a.getModelAutomobilaId()).get().getNazivModela();
		String klasa = klasaRep.findById(a.getKlasaAutomobilaId()).get().getNazivKlase();
		String menjac = tipMenjacaRep.findById(a.getTipMenjacaId()).get().getNazivMenjaca();
		String gorivo = tipGorivaRep.findById(a.getVrstaGorivaId()).get().getNazivTipa();

		AutomobilDTO autoDTO = new AutomobilDTO(a, marka, model, klasa, menjac, gorivo);
		return autoDTO;
	}
	public AutomobilImgDTO toImgDTO(Automobil a) throws Exception {
		TSlikaVozilaDTO slikaDTO=new TSlikaVozilaDTO(slikaServ.getSlikaVozilaByAutomobilId(a.getId()));
		AutomobilImgDTO imgDTO=new AutomobilImgDTO(toDTO(a),slikaDTO);
		return null;
	}

	

}
