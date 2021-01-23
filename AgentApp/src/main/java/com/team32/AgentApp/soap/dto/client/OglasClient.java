package com.team32.AgentApp.soap.dto.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team32.AgentApp.model.entitet.Cenovnik;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.soap.SoapMessageSender;
import com.team32.AgentApp.soap.dto.adresa.AdresaRequest;
import com.team32.AgentApp.soap.dto.adresa.AdresaResponse;
import com.team32.AgentApp.soap.dto.adresa.AdresaSuccessResponse;
import com.team32.AgentApp.soap.dto.cenovnik.CenovnikRequest;
import com.team32.AgentApp.soap.dto.cenovnik.CenovnikResponse;
import com.team32.AgentApp.soap.dto.cenovnik.CenovnikSuccessResponse;
import com.team32.AgentApp.soap.dto.oglas.OglasRequest;
import com.team32.AgentApp.soap.dto.oglas.OglasResponse;
import com.team32.AgentApp.soap.dto.oglas.OglasSuccessResponse;

@Component
public class OglasClient {

	@Autowired
	private SoapMessageSender soapMessageSender;
	
	//GET ZA SVE
	public List<Oglas> getAllOglas() {
		OglasRequest request = new OglasRequest();
		OglasResponse response = (OglasResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getAds();		
	}
	
	public List<Adresa> getAllAdresa() {
		AdresaRequest request = new AdresaRequest();
		AdresaResponse response = (AdresaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getAddress();
	}

	public List<Cenovnik> getAllCenovnik() {
		CenovnikRequest request = new CenovnikRequest();
		CenovnikResponse response = (CenovnikResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getPrices();
	}
	
	
	//CREATE NEW
	public Oglas createNewOglas(Oglas o) {

		OglasSuccessResponse response = (OglasSuccessResponse) soapMessageSender
				.sendMessage(o);
		if (response.isSuccessful()) {
			o.setId(response.getOglasId());
			
			return o;
		}
		
		return null;
	}
	
	public Adresa createNewOglas(Adresa a) {

		AdresaSuccessResponse response = (AdresaSuccessResponse) soapMessageSender
				.sendMessage(a);
		if (response.isSuccessful()) {
			a.setId(response.getAdresaId());
			
			return a;
		}
		
		return null;
	}
	
	public Cenovnik createNewCenovnik(Cenovnik c) {

		CenovnikSuccessResponse response = (CenovnikSuccessResponse) soapMessageSender
				.sendMessage(c);
		if (response.isSuccessful()) {
			c.setId(response.getCenovnikId());
			
			return c;
		}
		
		return null;
	}
}
