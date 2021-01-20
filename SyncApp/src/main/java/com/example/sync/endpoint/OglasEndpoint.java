package com.example.sync.endpoint;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.oglas.OglasResponse;
import com.example.sync.dto.oglas.cenovnik.CenovnikResponse;
import com.example.sync.service.OglasService;

@Endpoint
public class OglasEndpoint {

	@Autowired
	private OglasService typesService;
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetCenovnikResponse")
	@ResponsePayload
	public CenovnikResponse getCenovnik() {
		return  typesService.getCenovnik();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetOglasResponse")
	@ResponsePayload
	public OglasResponse getOglas() {
		return  typesService.getOglas();
	}
	
	//POST
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostOglasResponse")
	@ResponsePayload
	public OglasResponse postOglas(Long id, Long commonDataId, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId,
			Long automobilId, float planiranaKm, Long adresaId, String username) {
		return  typesService.postOglas(id, commonDataId, odDatuma, doDatuma, cenovnikId,
				automobilId, planiranaKm, adresaId, username);
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostCenovnikResponse")
	@ResponsePayload
	public CenovnikResponse postCenovnik(Long id, Long commonDataId, float cenaPoDanu, String nazivCenovnika,
			float popustZaPreko30Dana, float cenaCollisionDamageWaiver, float cenaPoKilometru) {
		return  typesService.postCenovnik(id, commonDataId, cenaPoDanu, nazivCenovnika,
				popustZaPreko30Dana, cenaCollisionDamageWaiver, cenaPoKilometru);
	}
}
