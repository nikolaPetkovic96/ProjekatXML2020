package com.example.sync.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.automobil.AutoSuccessResponse;
import com.example.sync.dto.automobil.Automobil;
import com.example.sync.dto.automobil.AutomobilResponse;
import com.example.sync.dto.automobil.brand.Brand;
import com.example.sync.dto.automobil.brand.BrandResponse;
import com.example.sync.dto.automobil.carClass.Klasa;
import com.example.sync.dto.automobil.carClass.KlasaResponse;
import com.example.sync.dto.automobil.fuel.FuelType;
import com.example.sync.dto.automobil.fuel.FuelTypeResponse;
import com.example.sync.dto.automobil.model.Model;
import com.example.sync.dto.automobil.model.ModelResponse;
import com.example.sync.dto.automobil.slika.Slika;
import com.example.sync.dto.automobil.slika.SlikaResponse;
import com.example.sync.dto.automobil.transmission.TransmissionType;
import com.example.sync.dto.automobil.transmission.TransmissionTypesResponse;

@Service
public class AutomobilService {

	public FuelTypeResponse getFuelTypes() {
		List<Map> fluel = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/fuel")
				.withMethod(HttpMethod.GET).send();
		List<FuelType> ret = new LinkedList<>();
		for (Map m : fluel) {
			FuelType t = new FuelType();
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setId(((Number) m.get("id")).longValue());
			t.setNazivTipa((String) m.get("nazivTipa"));
			ret.add(t);
		}
		FuelTypeResponse res = new FuelTypeResponse();
		res.setTypes(ret);
		return res;
	}

	public TransmissionTypesResponse getTransmissions() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/transmission")
				.withMethod(HttpMethod.GET).send();
		List<TransmissionType> ret = new LinkedList<>();
		for (Map m : trans) {
			TransmissionType t = new TransmissionType();
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setId(((Number) m.get("id")).longValue());
			t.setNazivTipa((String) m.get("nazivMenjaca"));
			ret.add(t);
		}
		TransmissionTypesResponse res = new TransmissionTypesResponse();
		res.setTypes(ret);
		return res;
	}

	public ModelResponse getModels() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/model")
				.withMethod(HttpMethod.GET).send();
		List<Model> ret = new LinkedList<>();
		for (Map m : trans) {
			Model t = new Model();
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setId(((Number) m.get("id")).longValue());
			t.setNazivModela((String) m.get("nazivModela"));
			t.setMarkaAutomobilaId(((Number) m.get("markaAutomobilaId")).longValue());
			ret.add(t);
		}
		ModelResponse res = new ModelResponse();
		res.setModels(ret);
		return res;
	}

	public BrandResponse getBrands() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/brand")
				.withMethod(HttpMethod.GET).send();
		List<Brand> ret = new LinkedList<>();
		for (Map m : trans) {
			Brand t = new Brand();
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setId(((Number) m.get("id")).longValue());
			t.setNazivMarke((String) m.get("nazivMarke"));
			ret.add(t);
		}
		BrandResponse res = new BrandResponse();
		res.setBrands(ret);
		return res;
	}

	public KlasaResponse getKlase() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/class")
				.withMethod(HttpMethod.GET).send();
		List<Klasa> ret = new LinkedList<>();
		for (Map m : trans) {
			Klasa t = new Klasa();
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setId(((Number) m.get("id")).longValue());
			t.setNazivKlase((String) m.get("nazivKlase"));
			ret.add(t);
		}
		KlasaResponse res = new KlasaResponse();
		res.setKlase(ret);
		return res;
	}

	public SlikaResponse getSlika() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/slikaVozila")
				.withMethod(HttpMethod.GET).send();
		List<Slika> ret = new LinkedList<>();
		for (Map m : trans) {
			Slika t = new Slika();
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setId(((Number) m.get("id")).longValue());
			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
			t.setSlika((String[]) m.get("slika"));
			ret.add(t);
		}
		SlikaResponse res = new SlikaResponse();
		res.setSlika(ret);
		return res;
	}
	public AutomobilResponse getAutomobil() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/car/sync")
				.withMethod(HttpMethod.GET).send();
		//System.out.println("Prondajeno automobila:"+trans.size());
		List<Automobil> ret = new LinkedList<>();
		for (Map m : trans) {
			Automobil t=mapToAutomobil(m);
			ret.add(t);
		}
		System.out.println(ret.size());
		AutomobilResponse res = new AutomobilResponse();
		res.setTypes(ret);
		return res;
		
	}
	
	private Automobil mapToAutomobil(Map m) {
		Automobil t = new Automobil();
		t.setId(((Number) m.get("id")).longValue());
//		System.out.println("Id "+t.getId());
		t.setBrojSedistaZaDecu(((Number)m.get("brojSedistaZaDecu")).intValue());
//		System.out.println("sedistaDeca"+t.getBrojSedistaZaDecu());
		t.setCollisionDamageWaiver(((Boolean)m.get("collisionDamageWaiver")).booleanValue());
//		System.out.println("colDmgWaiv "+t.isCollisionDamageWaiver());
		t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//		System.out.println("cmdId "+t.getCommonDataId());
		t.setKlasaAutomobilaId(((Number) m.get("klasaAutomobilaId")).longValue());
//		System.out.println("klasaId "+t.getKlasaAutomobilaId());
		t.setMarkaAutomobilaId(((Number) m.get("markaAutomobilaId")).longValue());
//		System.out.println("MarkaId"+t.getMarkaAutomobilaId());
		t.setModelAutomobilaId(((Number) m.get("modelAutomobilaId")).longValue());
		System.out.println("ModelId "+t.getModelAutomobilaId());
		t.setPredjenaKilometraza(((Number) m.get("predjenaKilometraza")).floatValue());	
//		System.out.println("predjanaKm "+t.getPredjenaKilometraza());
		t.setTipMenjacaId(((Number) m.get("tipMenjacaId")).longValue());
//		System.out.println("TipMenjaca "+t.getTipMenjacaId());
		t.setUkupnaOcena(((Number) m.get("ukupnaOcena")).floatValue());	
//		System.out.println("OcenaUkupna "+t.getUkupnaOcena());
		t.setVrstaGorivaId(((Number) m.get("vrstaGorivaId")).longValue());
		//System.out.println("GorivaoId "+t.getVrstaGorivaId());
		return t;
	}

	public AutoSuccessResponse postAutomobil(Automobil a) {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/car/agent/push")
				.withMethod(HttpMethod.POST).send();
		Automobil responseSaServera=new Automobil();
		//preuzmi auto iz mape
		List<Long> Ids = new LinkedList<>();
		for (Map m : trans) {
			Long noviId=((Number)m.get("id")).longValue();
			Ids.add(noviId);
		}
		AutoSuccessResponse response=new AutoSuccessResponse(a.getId(),false);

		if(Ids.get(0)!=null) {
			response.setAutomobilId(Ids.get(0));
			response.setSuccessful(true);
		}
		
		return response;

		
	}

}
