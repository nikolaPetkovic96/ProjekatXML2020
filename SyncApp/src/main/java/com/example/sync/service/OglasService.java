package com.example.sync.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.oglas.Oglas;
import com.example.sync.dto.oglas.OglasResponse;
import com.example.sync.dto.oglas.cenovnik.Cenovnik;
import com.example.sync.dto.oglas.cenovnik.CenovnikResponse;
@Service
public class OglasService {

	public OglasResponse getOglas() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.OGLAS).withPath("/ads")
				.withMethod(HttpMethod.GET).send();
		List<Oglas> ret = new LinkedList<>();
		for (Map m : trans) {
			Oglas t = new Oglas();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setOdDatuma((String) m.get("odDatuma"));
			t.setDoDatuma((String) m.get("doDatuma"));
			t.setAdresaId(((Number) m.get("adresaId")).longValue());
			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
			t.setCenovnikId(((Number) m.get("cenovnikId")).longValue());
			t.setPlaniranaKm(((Number) m.get("planiranaKm")).floatValue());
			t.setUsername((String) m.get("username"));
			ret.add(t);
		}
		OglasResponse res = new OglasResponse();
		res.setTypes(ret);
		return res;
	}
	
	public CenovnikResponse getCenovnik() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.OGLAS).withPath("/price/sync")
				.withMethod(HttpMethod.GET).send();
		List<Cenovnik> ret = new LinkedList<>();
		for (Map m : trans) {
			Cenovnik t = new Cenovnik();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setCenaCollisionDamageWaiver(((Number) m.get("cenaCollisionDamageWaiver")).floatValue());
			t.setCenaPoDanu(((Number) m.get("cenaPoDanu")).floatValue());
			t.setCenaPoKilometru(((Number) m.get("cenaPoKilometru")).floatValue());
			t.setNazivCenovnika((String) m.get("nazivCenovnika"));
			t.setPopustZaPreko30Dana(((Number) m.get("popustZaPreko30Dana")).floatValue());
			ret.add(t);
		}
		CenovnikResponse res = new CenovnikResponse();
		res.setTypes(ret);
		return res;
	}

}
