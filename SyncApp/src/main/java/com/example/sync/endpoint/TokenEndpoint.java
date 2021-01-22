package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import com.example.sync.dto.user.token.TokenRequest;
import com.example.sync.dto.user.token.TokenResponse;
import com.example.sync.service.TokenService;

@Endpoint
public class TokenEndpoint {

	@Autowired
	private TokenService typesService;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetTokenRequest")
	@ResponsePayload
	public TokenResponse getTokenRequest(@RequestPayload  TokenRequest req) {
		System.out.println("pogodjen! "+ req.getUsername()+" "+req.getPassword());
		return  typesService.getToken(req);
	}
}
