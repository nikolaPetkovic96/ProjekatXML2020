package com.example.sync.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.user.token.TokenRequest;
import com.example.sync.dto.user.token.JwtAuthenticationRequest;
import com.example.sync.dto.user.token.TokenResponse;

@Service
public class TokenService {



	public TokenResponse getToken(TokenRequest req) {
		JwtAuthenticationRequest authenticationRequest=new JwtAuthenticationRequest(req.getUsername(), req.getPassword());
		Map<String, Object>  response = (Map<String, Object> ) RESTClient.getClient().forService(Services.LOGIN)
				.withPath("/api/user/login")
				.withMethod(HttpMethod.POST)
				.withBody(authenticationRequest)
				.send();
	
		List<TokenResponse> list=new ArrayList<TokenResponse>();
		for(Map.Entry<String, Object> m : response.entrySet()) {
			String accessToken="";
			if( m.getKey().equals("accessToken")) {
				accessToken=(String) m.getValue();
			}
			//String accessToken=(String) m.getKey();
			//String expiresIn=(String) m.getKey();
			
			TokenResponse token=new TokenResponse();
			token.setToken(accessToken);
			list.add(token);
		}
		
		return list.get(0);
	}

}
