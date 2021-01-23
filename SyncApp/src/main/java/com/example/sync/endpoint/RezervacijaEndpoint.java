package com.example.sync.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.rezervacija.RezervacijaResponse;
import com.example.sync.dto.rezervacija.izvestaj.IzvestajResponse;
import com.example.sync.dto.rezervacija.narudzbenica.NarudzbenicaResponse;
import com.example.sync.service.RezervacijaService;

@Endpoint
public class RezervacijaEndpoint {

	@Autowired
	private RezervacijaService typesService;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetRezervacijaRequest")
	@ResponsePayload
	public RezervacijaResponse getRezervacija() {
		return  typesService.getRezervacija();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetIzvestajRequest")
	@ResponsePayload
	public IzvestajResponse getIzvestaj() {
		return  typesService.getIzvestaj();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetNarudzbenicaRequest")
	@ResponsePayload
	public NarudzbenicaResponse getNarudzbenica() {
		return  typesService.getNarudzbenica();
	}
}