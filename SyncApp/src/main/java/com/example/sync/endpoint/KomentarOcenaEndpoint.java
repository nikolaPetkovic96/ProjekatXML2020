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
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetKomentarResponse")
	@ResponsePayload
	public KomentarResponse getKomentarTypes() {
		return  typesService.getKomentar();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetOcenaResponse")
	@ResponsePayload
	public OcenaResponse getOcenaTypes() {
		return  typesService.getOcena();
	}
//POST
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostKomentarResponse")
	@ResponsePayload
	public KomentarResponse postKomentarTypes(Long id, Long commonDataId, String tekstKomentara, boolean odobren, Long automobilId, Long rezervacijaId, String autor) {
		return  typesService.postKomentar(id, commonDataId, tekstKomentara, odobren, automobilId, rezervacijaId, autor);
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostOcenaResponse")
	@ResponsePayload
	public OcenaResponse postOcenaTypes(Long id, Long commonDataId, int vrednostOcene, Long automobilId, Long rezervacijaId, String autor){
		return  typesService.postOcena(id, commonDataId, vrednostOcene, automobilId, rezervacijaId, autor);
	}
}
