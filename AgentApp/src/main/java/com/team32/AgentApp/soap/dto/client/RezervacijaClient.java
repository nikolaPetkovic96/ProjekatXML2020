package com.team32.AgentApp.soap.dto.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.team32.AgentApp.model.entitet.Izvestaj;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.soap.SoapMessageSender;
import com.team32.AgentApp.soap.dto.izvestaj.IzvestajRequest;
import com.team32.AgentApp.soap.dto.izvestaj.IzvestajResponse;
import com.team32.AgentApp.soap.dto.izvestaj.IzvestajSuccessResponse;
import com.team32.AgentApp.soap.dto.narudzbenica.NarudzbenicaRequest;
import com.team32.AgentApp.soap.dto.narudzbenica.NarudzbenicaResponse;
import com.team32.AgentApp.soap.dto.narudzbenica.NarudzbenicaSuccessResponse;
import com.team32.AgentApp.soap.dto.rezervacija.RezervacijaRequest;
import com.team32.AgentApp.soap.dto.rezervacija.RezervacijaResponse;
import com.team32.AgentApp.soap.dto.rezervacija.RezevacijaSuccessResponse;

@Component
public class RezervacijaClient {
	
	@Autowired
	private SoapMessageSender soapMessageSender;
	
	//GET ZA SVE
	public List<Rezervacija> getAllRezervacija() {
		RezervacijaRequest request = new RezervacijaRequest();
		RezervacijaResponse response = (RezervacijaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getReservations();
	}

	public List<Narudzbenica> getAllNarudzbenica() {
		NarudzbenicaRequest request = new NarudzbenicaRequest();
		NarudzbenicaResponse response = (NarudzbenicaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getNarudzbenice();
	}

	public List<Izvestaj> getAllIzvestaj() {
		IzvestajRequest request = new IzvestajRequest();
		IzvestajResponse response = (IzvestajResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getIzvestaji();
	}

	
	//CREATE NEW
	public Rezervacija createNewRezervacija(Rezervacija r) {

		RezevacijaSuccessResponse response = (RezevacijaSuccessResponse) soapMessageSender
				.sendMessage(r);
		if (response.isSuccessful()) {
			r.setId(response.getRezevacijaId());
			
			return r;
		}
		
		return null;
	}
	
	public Narudzbenica createNewNarudzbenice(Narudzbenica n) {

		NarudzbenicaSuccessResponse response = (NarudzbenicaSuccessResponse) soapMessageSender
				.sendMessage(n);
		if (response.isSuccessful()) {
			n.setId(response.getNarudzbenicaId());
			
			return n;
		}
		
		return null;
	}
	
	public Izvestaj createNewIzvestaj(Izvestaj i) {

		IzvestajSuccessResponse response = (IzvestajSuccessResponse) soapMessageSender
				.sendMessage(i);
		if (response.isSuccessful()) {
			i.setId(response.getIzvestajId());
			
			return i;
		}
		
		return null;
	}
}
