package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.timer.ReservedTimerRequest;
import com.example.sync.dto.timer.ReservedTimerResponse;
import com.example.sync.service.RezervacijaService;


@Endpoint
public class TimerEndpoint {
	@Autowired
	private RezervacijaService rServ;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "ReservedTimerRequest")
	@ResponsePayload
	public ReservedTimerResponse ReservedTimer(@RequestPayload ReservedTimerRequest req) {
		return rServ.createReservedTimer(req);
	}
	
//	public TimerEndpoint() {
//		// TODO Auto-generated constructor stub
//	}

}
