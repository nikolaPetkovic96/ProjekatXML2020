package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.poruka.Poruka;
import com.example.sync.dto.poruka.PorukaResponse;
import com.example.sync.service.PorukaService;

@Endpoint
public class PorukaEndpoint {

	@Autowired
	private PorukaService service;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetPorukaResponse")
	@ResponsePayload
	public PorukaResponse getPoruka() {
		return  service.getPoruka();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostPorukaResponse")
	@ResponsePayload
	public PorukaResponse postoruka(Long id, Long commonDataId, String tekstPoruke, Long rezervacijaId, Long automobilId) {
		Poruka body=new Poruka(id, commonDataId, tekstPoruke, rezervacijaId, automobilId);
		return  service.postPoruka(id, commonDataId, tekstPoruke, rezervacijaId, automobilId);
	}
}
