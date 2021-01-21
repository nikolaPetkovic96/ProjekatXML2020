package com.example.sync.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.komentar.Komentar;
import com.example.sync.dto.komentar.KomentarResponse;
import com.example.sync.dto.ocena.Ocena;
import com.example.sync.dto.ocena.OcenaResponse;

@Service
public class KomentarOcenaService {

	public KomentarResponse getKomentar() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.KOMENTAROCENA).withPath("/comment/sync")
				.withMethod(HttpMethod.GET).send();
		List<Komentar> ret = new LinkedList<>();
		for (Map m : trans) {
			Komentar t = new Komentar();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
			t.setAutor((String) m.get("autor"));
			t.setOdobren((boolean) m.get("odobren"));
			t.setRezervacijaId(((Number) m.get("rezervacijaId")).longValue());
			t.setTekstKomentara((String) m.get("tekstKomentara"));
			ret.add(t);
		}
		KomentarResponse res = new KomentarResponse();
		res.setTypes(ret);
		return res;
	}
	public OcenaResponse getOcena() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.KOMENTAROCENA).withPath("/rating/sync")
				.withMethod(HttpMethod.GET).send();
		List<Ocena> ret = new LinkedList<>();
		for (Map m : trans) {
			Ocena t = new Ocena();
			t.setId(((Number) m.get("id")).longValue());
			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
			t.setAutor((String) m.get("autor"));
			t.setRezervacijaId(((Number) m.get("rezervacijaId")).longValue());
			ret.add(t);
		}
		OcenaResponse res = new OcenaResponse();
		res.setTypes(ret);
		return res;
	}

}
