package com.example.sync.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.adresa.Adresa;
import com.example.sync.dto.adresa.AdresaResponse;
@Service
public class AdresaService {

	public AdresaResponse getAdresa() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/api/user/adresa/sync")
				.withMethod(HttpMethod.GET).send();
		System.out.println("Pronadjeno adresa : "+trans.size());
		List<Adresa> ret = new LinkedList<>();
		for (Map m : trans) {
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

			ret.add(t);
		}
		AdresaResponse res = new AdresaResponse();
		res.setTypes(ret);
		return res;
	}
}
