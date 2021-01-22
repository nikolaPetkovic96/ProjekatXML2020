package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.komentar.KomentarResponse;
import com.example.sync.dto.ocena.OcenaResponse;
import com.example.sync.service.KomentarOcenaService;

@Endpoint
public class KomentarOcenaEndpoint {

	@Autowired
	private KomentarOcenaService typesService;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetKomentarRequest")
	@ResponsePayload
	public KomentarResponse getKomentarTypes() {
		return  typesService.getKomentar();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetOcenaRequest")
	@ResponsePayload
	public OcenaResponse getOcenaTypes() {
		return  typesService.getOcena();
	}
}
