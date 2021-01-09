package com.example.Automobil.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.dto.AutomobilPomDTO;
import com.example.Automobil.model.Automobil;
import com.example.Automobil.model.CommonData;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.TKlasaAutomobilaRepository;
import com.example.Automobil.repository.TMarkaAutomobilaRepository;
import com.example.Automobil.repository.TModelAutomobilaRepository;
import com.example.Automobil.repository.TTipGorivaRepository;
import com.example.Automobil.repository.TTipMenjacaRepository;

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

	public AutomobilPomDTO toPomDTO(Automobil a) {
		CommonData data = cmdRep.findById(a.getCommonDataId()).get();
		String marka = markaRep.findById(a.getMarkaAutomobilaId()).get().getNazivMarke();
		String model = modelRep.findById(a.getModelAutomobilaId()).get().getNazivModela();
		String klasa = klasaRep.findById(a.getKlasaAutomobilaId()).get().getNazivKlase();
		String Username = "";// tUserRep.findById(data.getUserid()).get().getKorisnickoIme();

		AutomobilPomDTO autoDTO = new AutomobilPomDTO(a.getId(), a.getMarkaAutomobilaId(), a.getModelAutomobilaId(),
				a.getKlasaAutomobilaId(), a.getVrstaGorivaId(), a.getTipMenjacaId(), a.getPredjenaKilometraza(),
				a.isCollisionDamageWaiver(), a.getBrojSedistaZaDecu(), a.getCommonDataId(),
				null,
				marka, model, klasa, data.getUserId(), Username, a.getUkupnaOcena());
		return autoDTO;
	}
	
	public AutomobilDTO toDTO(Automobil a) {
		String marka = markaRep.findById(a.getMarkaAutomobilaId()).get().getNazivMarke();
		String model = modelRep.findById(a.getModelAutomobilaId()).get().getNazivModela();
		String klasa = klasaRep.findById(a.getKlasaAutomobilaId()).get().getNazivKlase();
		String menjac = tipMenjacaRep.findById(a.getTipMenjacaId()).get().getNazivMenjaca();
		String gorivo = tipGorivaRep.findById(a.getVrstaGorivaId()).get().getNazivTipa();

		AutomobilDTO autoDTO = new AutomobilDTO(a, marka, model, klasa, menjac, gorivo);
		return autoDTO;
	}

	
	public Automobil fromPomDTO(AutomobilPomDTO dto) {
		CommonData data = new CommonData();
		
		Automobil a = new Automobil(dto.getId(), dto.getMarkaAutomobilaId(), dto.getModelAutomobilaId(),
				dto.getKlasaAutomobilaId(), dto.getVrstaGorivaId(), dto.getTipMenjacaId(), dto.getPredjenaKilometraza(),
				dto.getUkupnaOcena(), dto.isCollisionDamageWaiver(), dto.getBrojSedistaZaDecu(), dto.getCommonDataId());
		cmdRep.save(data);
		cmdRep.flush();
		a.setCommonDataId(data.getId());
		return a;
	}
}
