package com.example.sync.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.adresa.Adresa;
import com.example.sync.dto.adresa.AdresaResponse;
import com.example.sync.dto.adresa.AdresaSuccessResponse;
import com.example.sync.dto.automobil.Automobil;
@Service
public class AdresaService {

	public AdresaResponse getAdresa() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/api/user/adresa/sync")
				.withMethod(HttpMethod.GET).send();
		System.out.println("Pronadjeno adresa : "+trans.size());
		List<Adresa> ret = new LinkedList<>();
		for (Map m : trans) {
			Adresa t=fromMap(m);
			ret.add(t);
		}
		AdresaResponse res = new AdresaResponse();
		res.setTypes(ret);
		return res;
	}

	public AdresaSuccessResponse createAdresa(Adresa a) {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/api/user/adresa/sync/")
				.withMethod(HttpMethod.POST).withBody(a).send();
		List<Adresa> ret = new LinkedList<>();
		for (Map m : trans) {
			Adresa temp=fromMap(m);
			ret.add(temp);
		}
		AdresaSuccessResponse response=new AdresaSuccessResponse();
		response.setAdresaId(ret.get(0).getId());
		if(response.getAdresaId()!=null) 
			response.setSuccessful(true);
		else
			response.setSuccessful(false);
		return response;
	}

	private Adresa fromMap(Map m) {
		Adresa t = new Adresa();
		t.setId(((Number) m.get("id")).longValue());
		//System.out.println("id : "+t.getId());
		t.setBroj((String) m.get("broj"));
		//System.out.println("broj : "+t.getBroj());
		t.setMesto((String) m.get("mesto"));
		//System.out.println("mesto : "+t.getMesto());
		t.setPostanskiBroj((String) m.get("postanskiBroj"));
		//System.out.println("postanskiBroj : "+t.getPostanskiBroj());
		t.setUlica((String) m.get("ulica"));
		//System.out.println("ulica : "+t.getUlica());
		return t;
	}
}
