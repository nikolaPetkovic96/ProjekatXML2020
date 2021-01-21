package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.user.UserTypesResponse;
import com.example.sync.service.KorisnikService;

@Endpoint
public class KorisnikEndpoint {

	@Autowired
	private KorisnikService typesService;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetUserTypesResponse")
	@ResponsePayload
	public UserTypesResponse getUser() {
		return  typesService.getUser();
	}
}
