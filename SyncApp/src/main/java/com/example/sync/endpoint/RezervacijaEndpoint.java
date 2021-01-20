package com.example.sync.endpoint;

import java.time.LocalDateTime;

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
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetRezervacijaResponse")
	@ResponsePayload
	public RezervacijaResponse getRezervacija() {
		return  typesService.getRezervacija();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetIzvestajResponse")
	@ResponsePayload
	public IzvestajResponse getIzvestaj() {
		return  typesService.getIzvestaj();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetNarudzbenicaResponse")
	@ResponsePayload
	public NarudzbenicaResponse getNarudzbenica() {
		return  typesService.getNarudzbenica();
	}
	//POST
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostRezervacijaResponse")
	@ResponsePayload
	public RezervacijaResponse postRezervacija(Long id, Long commonDataId, float ukupnaCena, boolean bundle, String statusRezervacije, String napomena) {
		return  typesService.postRezervacija(id, commonDataId, ukupnaCena, bundle, statusRezervacije, napomena);
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostNarudzbenicaResponse")
	@ResponsePayload
	public NarudzbenicaResponse postNarudzbenica(Long id, Long commonDataId, Long agentId, Long userId, 
			Long oglasId, Long rezervacijaId, LocalDateTime odDatuma, LocalDateTime doDatuma) {
		return  typesService.postNarudzbenica(id, commonDataId, agentId, userId, 
				oglasId, rezervacijaId, odDatuma, doDatuma);
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostIzvestajResponse")
	@ResponsePayload
	public IzvestajResponse postIzvestaj(Long id, Long commonDataId, float predjenaKilometraza, String tekstIzvestaja, 
			Long narudzbenicaId, Long automobilId, Long rezervacijaId,
			Long prekoracenaKilometraza, Long dodatniTroskovi) {
		return  typesService.postIzvestaj(id, commonDataId, predjenaKilometraza, tekstIzvestaja, 
				narudzbenicaId, automobilId, rezervacijaId, 
				prekoracenaKilometraza, dodatniTroskovi);
	}
	
	
}
