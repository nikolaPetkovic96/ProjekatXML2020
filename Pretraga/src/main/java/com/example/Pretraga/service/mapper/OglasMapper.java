package com.example.Pretraga.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Pretraga.dto.OglasDTO;
import com.example.Pretraga.model.Automobil;
import com.example.Pretraga.model.Cenovnik;
import com.example.Pretraga.model.CommonData;
import com.example.Pretraga.model.Oglas;
import com.example.Pretraga.model.TAdresa;
import com.example.Pretraga.model.TKlasaAutomobila;
import com.example.Pretraga.model.TMarkaAutomobila;
import com.example.Pretraga.model.TModelAutomobila;
import com.example.Pretraga.model.TTipGoriva;
import com.example.Pretraga.model.TTipMenjaca;
import com.example.Pretraga.model.TUser;
import com.example.Pretraga.repository.AutomobilRepository;
import com.example.Pretraga.repository.CenovnikRepository;
import com.example.Pretraga.repository.CommonDataRepository;
import com.example.Pretraga.repository.OglasRepository;
import com.example.Pretraga.repository.TAdresaRepository;
import com.example.Pretraga.repository.TKlasaAutomobilaRepository;
import com.example.Pretraga.repository.TMarkaAutomobilaRepository;
import com.example.Pretraga.repository.TModelAutomobilaRepository;
import com.example.Pretraga.repository.TTipGorivaRepository;
import com.example.Pretraga.repository.TTipMenjacaRepository;
import com.example.Pretraga.repository.TUserRepository;
@Component
public class OglasMapper {
	@Autowired
	private CommonDataRepository dataRep;
	@Autowired
	private AutomobilRepository autoRep;
	@Autowired
	private CenovnikRepository cenRep;
	@Autowired
	private OglasRepository oglasRep;
	@Autowired
	private TAdresaRepository adresaRep;
	@Autowired
	private TKlasaAutomobilaRepository klasaRep;
	@Autowired
	private TMarkaAutomobilaRepository markaRep;
	@Autowired
	private TModelAutomobilaRepository modelRep;
	@Autowired
	private TTipGorivaRepository tipGorivaRep;
	@Autowired
	private TTipMenjacaRepository menjacRep;
	@Autowired
	private TUserRepository userRep;
	
	public OglasDTO toDTO(Oglas o) {
		Oglas og=o;
		CommonData data=dataRep.findById(o.getCommonDataId()).get();
		TUser user=userRep.findById(data.getUserid()).get();
		Automobil auto=autoRep.findById(o.getAutomobilId()).get();
		Cenovnik cena=cenRep.findById(o.getCenovnikId()).get();
		TAdresa adresa=adresaRep.findById(user.getAdresaId()).get();	//adresa se uzima od adrese vlasnika
		TKlasaAutomobila klasa=klasaRep.findById(auto.getKlasaAutomobilaId()).get();
		TMarkaAutomobila marka=markaRep.findById(auto.getMarkaAutomobilaId()).get();
		TModelAutomobila model=modelRep.findById(auto.getModelAutomobilaId()).get();
		TTipGoriva gorivo=tipGorivaRep.findById(auto.getVrstaGorivaId()).get();
		TTipMenjaca menjac=menjacRep.findById(auto.getTipMenjacaId()).get();
		OglasDTO dto=new OglasDTO(	og.getId(),
									og.getOdDatuma(),
									og.getDoDatuma(),
									og.getCenovnikId(),
									og.getAutomobilId(),
									cena.getCenaPoDanu(),
									cena.getPopustZaPreko30Dana(),
									cena.getCenaCollisionDamageWaiver(),
									cena.getCenaPoKilometru(),
									auto.getPredjenaKilometraza(),
									auto.getPlaniranaKilometraza(),
									auto.isCollisionDamageWaiver(),
									auto.getBrojSedistaZaDecu(),
									data.getDatumKreiranja(),
									data.getDatumIzmene(),
									user.getId(),
									adresa.getMesto(),
									adresa.getPostanskiBroj(),
									adresa.getUlica(),
									adresa.getBroj(),
									klasa.getNazivKlase(),
									marka.getNazivMarke(),
									model.getNazivModela(),
									gorivo.getNazivTipa(),
									menjac.getNazivMenjaca(),
									user.getKorisnickoIme(),
									adresa.getId());
									
		
		return dto;
		
	}
	public OglasDTO toDTO(Long id) {
		Oglas og=oglasRep.findById(id).get();
		CommonData data=dataRep.findById(og.getCommonDataId()).get();
		TUser user=userRep.findById(data.getUserid()).get();
		Automobil auto=autoRep.findById(og.getAutomobilId()).get();
		Cenovnik cena=cenRep.findById(og.getCenovnikId()).get();
		TAdresa adresa=adresaRep.findById(user.getAdresaId()).get();	//adresa se uzima od adrese vlasnika
		TKlasaAutomobila klasa=klasaRep.findById(auto.getKlasaAutomobilaId()).get();
		TMarkaAutomobila marka=markaRep.findById(auto.getMarkaAutomobilaId()).get();
		TModelAutomobila model=modelRep.findById(auto.getModelAutomobilaId()).get();
		TTipGoriva gorivo=tipGorivaRep.findById(auto.getVrstaGorivaId()).get();
		TTipMenjaca menjac=menjacRep.findById(auto.getTipMenjacaId()).get();
		OglasDTO dto=new OglasDTO(	og.getId(),
									og.getOdDatuma(),
									og.getDoDatuma(),
									og.getCenovnikId(),
									og.getAutomobilId(),
									cena.getCenaPoDanu(),
									cena.getPopustZaPreko30Dana(),
									cena.getCenaCollisionDamageWaiver(),
									cena.getCenaPoKilometru(),
									auto.getPredjenaKilometraza(),
									auto.getPlaniranaKilometraza(),
									auto.isCollisionDamageWaiver(),
									auto.getBrojSedistaZaDecu(),
									data.getDatumKreiranja(),
									data.getDatumIzmene(),
									user.getId(),
									adresa.getMesto(),
									adresa.getPostanskiBroj(),
									adresa.getUlica(),
									adresa.getBroj(),
									klasa.getNazivKlase(),
									marka.getNazivMarke(),
									model.getNazivModela(),
									gorivo.getNazivTipa(),
									menjac.getNazivMenjaca(),
									user.getKorisnickoIme(),
									adresa.getId());
									
		
		return dto;
		
	}
	public Oglas fromDTO(OglasDTO o) {
		return null;}
}
