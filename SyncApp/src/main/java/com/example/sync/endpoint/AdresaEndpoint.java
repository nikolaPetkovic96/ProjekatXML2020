package com.example.sync.endpoint;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.adresa.AdresaResponse;
import com.example.sync.service.AdresaService;
@Endpoint
public class AdresaEndpoint {

	@Autowired
	private AdresaService typesService;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetAdresaResponse")
	@ResponsePayload
	public AdresaResponse getAdresa() {
		return  typesService.getAdresa();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostAdresaResponse")
	@ResponsePayload
	public AdresaResponse postAdresa(Long id, String mesto, String postanskiBroj, String ulica, String broj) {
		return  typesService.postAdresa(id, mesto, postanskiBroj, ulica, broj);
	}

}
