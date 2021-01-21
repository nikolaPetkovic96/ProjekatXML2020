package com.team32.AgentApp.soap.dto.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team32.AgentApp.model.entitet.Komentar;
import com.team32.AgentApp.model.entitet.Ocena;
import com.team32.AgentApp.model.entitet.Poruka;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.soap.SoapMessageSender;
import com.team32.AgentApp.soap.dto.komentar.KomentarRequest;
import com.team32.AgentApp.soap.dto.komentar.KomentarResponse;
import com.team32.AgentApp.soap.dto.komentar.KomentarSuccessResponse;
import com.team32.AgentApp.soap.dto.ocena.OcenaRequest;
import com.team32.AgentApp.soap.dto.ocena.OcenaResponse;
import com.team32.AgentApp.soap.dto.poruka.PorukaRequest;
import com.team32.AgentApp.soap.dto.poruka.PorukaResponse;
import com.team32.AgentApp.soap.dto.poruka.PorukaSuccessResponse;
import com.team32.AgentApp.soap.dto.token.TokenRequest;
import com.team32.AgentApp.soap.dto.token.TokenResponse;
import com.team32.AgentApp.soap.dto.user.UserRequest;
import com.team32.AgentApp.soap.dto.user.UserResponse;

@Component
public class KomunikacijaClient {
	
	@Autowired
	private SoapMessageSender soapMessageSender;

	//GET ZA SVE
	public List<Komentar> getAllKomentar() {
		KomentarRequest request = new KomentarRequest();
		KomentarResponse response = (KomentarResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getComments();
	}
	
	public List<Ocena> getAllOcena() {
		OcenaRequest request = new OcenaRequest();
		OcenaResponse response = (OcenaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getRating();
	}
	
	public List<Poruka> getAllPoruka() {
		PorukaRequest request = new PorukaRequest();
		PorukaResponse response = (PorukaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getMessages();
	}
	
	public List<User> getAllUsers() {
		UserRequest request = new UserRequest();
		UserResponse response = (UserResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getUsers();
	}
	
	public TokenResponse login(String usename,String passwod) {
		TokenRequest request = new TokenRequest();
		request.setUsername(usename);
		request.setPassword(passwod);
		TokenResponse response = (TokenResponse) soapMessageSender
				.sendMessage(request);
		
		return response;
	}
	
	
	//CREATE NEW
	public Poruka createNewPoruka(Poruka p) {

		PorukaSuccessResponse response = (PorukaSuccessResponse) soapMessageSender
				.sendMessage(p);
		if (response.isSuccessful()) {
			p.setId(response.getPorukaId());
			
			return p;
		}
		
		return null;
	}

	public Komentar createNewKomentar(Komentar k) {

		KomentarSuccessResponse response = (KomentarSuccessResponse) soapMessageSender
				.sendMessage(k);
		if (response.isSuccessful()) {
			k.setId(response.getKomentarId());
			
			return k;
		}
		
		return null;
	}
	
}
