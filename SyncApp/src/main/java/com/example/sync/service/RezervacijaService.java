package com.example.sync.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.rezervacija.Rezervacija;
import com.example.sync.dto.rezervacija.RezervacijaResponse;
import com.example.sync.dto.rezervacija.izvestaj.Izvestaj;
import com.example.sync.dto.rezervacija.izvestaj.IzvestajResponse;
import com.example.sync.dto.rezervacija.narudzbenica.Narudzbenica;
import com.example.sync.dto.rezervacija.narudzbenica.NarudzbenicaResponse;
import com.example.sync.dto.timer.ReservedTimerRequest;
import com.example.sync.dto.timer.ReservedTimerResponse;
@Service
public class RezervacijaService {

	public RezervacijaResponse getRezervacija() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/reservation/sync")
				.withMethod(HttpMethod.GET).send();
		List<Rezervacija> ret = new LinkedList<>();
		System.out.println("Broj Rezervacija: "+trans.size());
		for (Map m : trans) {
			Rezervacija t = new Rezervacija();
			t.setId(((Number) m.get("id")).longValue());
			System.out.println("Id : "+t.getId());

			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			//System.out.println("CommonDataId : "+t.getCommonDataId());

			t.setBundle(((Boolean)m.get("bundle")).booleanValue());
			//System.out.println("bundle : "+t.getBundle());

			t.setUsername((String) m.get("username"));
			//System.out.println("username : "+t.getUsername());

			t.setStatusRezervacije((String) m.get("statusRezervacije"));
			//System.out.println("statusRezervacije :"+t.getStatusRezervacije());

			t.setUkupnaCena(((Number) m.get("ukupnaCena")).doubleValue());
			//System.out.println("ukupnaCena : "+t.getUkupnaCena());
			ret.add(t);
		}
		RezervacijaResponse res = new RezervacijaResponse();
		res.setTypes(ret);
		return res;
	}
	public NarudzbenicaResponse getNarudzbenica() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/narudzbenica/sync")
				.withMethod(HttpMethod.GET).send();
		List<Narudzbenica> ret = new LinkedList<>();
		for (Map m : trans) {
			Narudzbenica t = new Narudzbenica();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setOdDatuma((String)m.get("odDatuma"));
			t.setDoDatuma((String) m.get("doDatuma"));
			t.setAgentId(((Number) m.get("agentId")).longValue());
			t.setUserId(((Number) m.get("userId")).longValue());
			t.setOglasId(((Number) m.get("oglasId")).longValue());
			t.setRezervacijaId(((Number) m.get("rezervacijaId")).longValue());
			ret.add(t);
		}
		NarudzbenicaResponse res = new NarudzbenicaResponse();
		res.setTypes(ret);
		return res;
	}
	public IzvestajResponse getIzvestaj() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/report/sync")
				.withMethod(HttpMethod.GET).send();
		System.out.println("Broj Izvestaja: "+trans.size());
		List<Izvestaj> ret = new LinkedList<>();
		for (Map m : trans) {
			Izvestaj t = new Izvestaj();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
			t.setRezervacijaId(((Number) m.get("rezervacijaId")).longValue());
			t.setDodatniTroskovi(((Number) m.get("dodatniTroskovi")).longValue());
			t.setNarudzbenicaId(((Number) m.get("narudzbenicaId")).longValue());
			t.setPredjenaKilometraza(((Number) m.get("predjenaKilometraza")).floatValue());
			t.setPrekoracenaKilometraza(((Number) m.get("prekoracenaKilometraza")).longValue());
			t.setTekstIzvestaja((String) m.get("tekstIzvestaja"));
			ret.add(t);
		}
		System.out.println("Obradjenih izvestaja :"+ ret.size());
		IzvestajResponse res = new IzvestajResponse();
		res.setTypes(ret);
		return res;
	}
	public ReservedTimerResponse createReservedTimer(ReservedTimerRequest req) {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/tajmer/placanje/"+req.getRezId())
				.withMethod(HttpMethod.GET).send();
		return new ReservedTimerResponse();
		
	}
	
}
