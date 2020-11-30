package com.example.Automobil.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.model.Automobil;
import com.example.Automobil.model.CommonData;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.TKlasaAutomobilaRepository;
import com.example.Automobil.repository.TMarkaAutomobilaRepository;
import com.example.Automobil.repository.TModelAutomobilaRepository;
import com.example.Automobil.repository.TTipGorivaRepository;
import com.example.Automobil.repository.TTipMenjacaRepository;
import com.example.Automobil.repository.TUserRepository;

public class AutomobilMapper {
	
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private TUserRepository tUserRep;
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
	
	public AutomobilDTO toDTO(Automobil a) {		
		CommonData data=cmdRep.findById(a.getCommonDataId()).get();		
		String marka=markaRep.findById(a.getMarkaAutomobilaId()).get().getNazivMarke();
		String model=modelRep.findById(a.getModelAutomobilaId()).get().getNazivModela();
		String klasa=klasaRep.findById(a.getKlasaAutomobilaId()).get().getNazivKlase();
		String Username=tUserRep.findById(data.getUserid()).get().getKorisnickoIme();
		
		AutomobilDTO autoDTO=new AutomobilDTO(	a.getId(), 
												a.getMarkaAutomobilaId(), 
												a.getModelAutomobilaId(), 
												a.getKlasaAutomobilaId(), 
												a.getVrstaGorivaId(), 
												a.getTipMenjacaId(), 
												a.getPredjenaKilometraza(), 
												a.getPlaniranaKilometraza(), 
												a.isCollisionDamageWaiver(), 
												a.getBrojSedistaZaDecu(), 
												a.getCommonDataId(), 
												null, ///////////////////////////
												marka, 
												model, 
												klasa, 
												data.getUserid(), 
												Username);
		return autoDTO;		
	}
	
	public Automobil fromDTO(AutomobilDTO dto) {
		CommonData data=new CommonData();
		
		Automobil a=new Automobil(	dto.getId(),
									dto.getMarkaAutomobilaId(),
									dto.getModelAutomobilaId(),
									dto.getKlasaAutomobilaId(),
									dto.getVrstaGorivaId(),
									dto.getTipMenjacaId(),
									dto.getPredjenaKilometraza(),
									dto.getPredjenaKilometraza(),
									dto.isCollisionDamageWaiver(),
									dto.getBrojSedistaZaDecu(),
									(long) 0);
		cmdRep.save(data);
		cmdRep.flush();
		a.setCommonDataId(data.getId());
		return a;
		
	}
}
