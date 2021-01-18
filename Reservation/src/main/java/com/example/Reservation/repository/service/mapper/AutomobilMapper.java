package com.example.Reservation.repository.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Reservation.dto.AutomobilDTO;

import com.example.Reservation.model.Automobil;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.auto.TKlasaAutomobilaRepository;
import com.example.Reservation.repository.auto.TMarkaAutomobilaRepository;
import com.example.Reservation.repository.auto.TModelAutomobilaRepository;
import com.example.Reservation.repository.auto.TTipGorivaRepository;

import com.example.Reservation.repository.auto.TTipMenjacaRepository;


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
//	@Autowired
//	private TSlikaVozilaService slikaServ;
	
	
	public AutomobilDTO toDTO(Automobil a) {
		String marka = markaRep.findById(a.getMarkaAutomobilaId()).get().getNazivMarke();
		String model = modelRep.findById(a.getModelAutomobilaId()).get().getNazivModela();
		String klasa = klasaRep.findById(a.getKlasaAutomobilaId()).get().getNazivKlase();
		String menjac = tipMenjacaRep.findById(a.getTipMenjacaId()).get().getNazivMenjaca();
		String gorivo = tipGorivaRep.findById(a.getVrstaGorivaId()).get().getNazivTipa();

		AutomobilDTO autoDTO = new AutomobilDTO(a, marka, model, klasa, menjac, gorivo);
		return autoDTO;
	}
//	public AutomobilImgDTO toImgDTO(Automobil a) throws Exception {
//		TSlikaVozilaDTO slikaDTO=new TSlikaVozilaDTO(slikaServ.getSlikaVozilaByAutomobilId(a.getId()));
//		AutomobilImgDTO imgDTO=new AutomobilImgDTO(toDTO(a),slikaDTO);
//		return null;
//	}

	

}