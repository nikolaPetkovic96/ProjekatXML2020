package com.example.sync.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.poruka.Poruka;
import com.example.sync.dto.poruka.PorukaResponse;

@Service
public class PorukaService {

	public PorukaResponse getPoruka() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.MESSAGE).withPath("/message")
				.withMethod(HttpMethod.GET).send();
		List<Poruka> ret = new LinkedList<>();
		for (Map m : trans) {
			Poruka t = new Poruka();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
			t.setRezervacijaId(((Number)m.get("rezervacijaId")).longValue());
			t.setTekstPoruke( m.get("tekstPoruke").toString());
			
			ret.add(t);
		}
		PorukaResponse res = new PorukaResponse();
		res.setTypes(ret);
		return res;
	}
}
