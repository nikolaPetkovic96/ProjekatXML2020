package com.example.sync.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.commonData.CommonData;
import com.example.sync.dto.commonData.CommonDataResponse;
@Service
public class CommonDataService {

	public CommonDataResponse getCommonDataTypes() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.OGLAS).withPath("/ads/sync/cmd")
				.withMethod(HttpMethod.GET).send();
		//System.out.println("Pronadjeno cmd : "+trans.size());
		List<CommonData> ret = new LinkedList<>();
		for (Map m : trans) {
			CommonData t = new CommonData();
			t.setId(((Number) m.get("id")).longValue());
			//System.out.println("id : "+t.getId());
			t.setDatumKreiranja((String) m.get("datumKreiranja"));
			//System.out.println("datumKreiranja : "+t.getDatumKreiranja() +" : "+(String) m.get("datumKreiranja"));
			if((Object)m.get("datumIzmene")!=null)
			t.setDatumIzmene((String) m.get("datumIzmene"));
			else
			t.setDatumIzmene(t.getDatumKreiranja());
			//System.out.println("datumIzmene : "+t.getDatumIzmene());

			t.setUserId(((Number) m.get("userId")).longValue());
			//System.out.println("userId : "+t.getUserId());

			ret.add(t);
		}
		CommonDataResponse res = new CommonDataResponse();
		res.setTypes(ret);
		return res;
	}

}
