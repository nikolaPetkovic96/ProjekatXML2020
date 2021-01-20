package com.example.sync.endpoint;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.commonData.CommonDataResponse;
import com.example.sync.service.CommonDataService;

@Endpoint
public class CommonDataEndpoint {

	@Autowired
	private CommonDataService typesService;
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetCommonDataResponse")
	@ResponsePayload
	public CommonDataResponse getCommonDataTypes() {
		return  typesService.getCommonDataTypes();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostCommonDataResponse")
	@ResponsePayload
	public CommonDataResponse getCommonDataTypes(Long id, Long userId, LocalDateTime datumKreiranja, LocalDateTime datumIzmene ) {
		return  typesService.postCommonData(id, userId, datumKreiranja, datumIzmene);
	}
}
