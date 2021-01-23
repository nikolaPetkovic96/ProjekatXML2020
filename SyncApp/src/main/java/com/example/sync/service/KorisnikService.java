package com.example.sync.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.example.sync.dto.user.Authority;
import com.example.sync.dto.user.UserType;
import com.example.sync.dto.user.UserTypesResponse;

@Service
public class KorisnikService {

	public UserTypesResponse getUser() {
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/api/user/sync")
				.withMethod(HttpMethod.GET).send();
		List<UserType> ret = new LinkedList<>();
		System.out.println("Pronadjeno korisnika : "+trans.size());
		for (Map m : trans) {
			UserType t = new UserType();
			t.setId(((Number) m.get("id")).longValue());
			System.out.println("Id : "+t.getId());

			t.setKorisnickoIme((String) m.get("korisnickoIme"));
			System.out.println("username : "+t.getKorisnickoIme());

			t.setLozinka((String) m.get("lozinka"));
			System.out.println("Lozinka : "+t.getLozinka());

			t.setEmail((String) m.get("email"));
			System.out.println("email : "+t.getEmail());

			t.setStatus((String) m.get("status"));
			System.out.println("Status : "+t.getStatus());

			t.setAdresaId(((Number) m.get("adresaId")).longValue());
			System.out.println("adresa : "+t.getAdresaId());

			t.setPol((String) m.get("pol"));
			System.out.println("pol : "+t.getPol());

			t.setIme((String) m.get("ime"));
			System.out.println("ime : "+t.getIme());

			t.setPrezime((String) m.get("prezime"));
			System.out.println("prezime : "+t.getPrezime());

			t.setJmbg((String) m.get("jmbg"));
			System.out.println("jmbg"+t.getJmbg());

			
			t.setNazivFirme((String) m.get("nazivFirme"));
			System.out.println("naziv firme : "+t.getNazivFirme());

			t.setPoslovniMaticniBroj((String) m.get("poslovniMaticniBroj"));
			System.out.println("pib : "+t.getPoslovniMaticniBroj());

			
			t.setAllowedToCommend(((Boolean)m.get("allowedToCommend")).booleanValue());
			System.out.println("commend : "+t.isAllowedToCommend());

			t.setAllowedToMessage(((Boolean)m.get("allowedToMessage")).booleanValue());
			System.out.println("message : "+t.isAllowedToMessage());

			t.setAllowedToMakeReservation((boolean) m.get("allowedToMakeReservation"));
			System.out.println("reservation : "+t.isAllowedToMakeReservation());
			
			//t.setAuthorities(m.get("authorities"));
			List<LinkedHashMap<String,Object>> list=(List<LinkedHashMap<String,Object>> ) m.get("authorities");
			//System.out.println(list.get(0).get("authority")+" , "+ list.size());
			Authority a=new Authority((String)list.get(0).get("authority"));
			System.out.println(list.get(0).get("authority"));
			//System.out.println(String.valueOf(list.get(0).get("id")));
			//a.setAuthority((String)list.get(0).get("authority"));			

			//a.setId(Long.valueOf((String)list.get(0).get("id")));
			//System.out.println(t.getAuthorities().get(0).getAuthority());
//			System.out.println(t.getAuthorities().get(0).getId());
			List<Authority> newList=new ArrayList<>();
			newList.add(a);
			t.setAuthorities(newList);
			

			ret.add(t);
		}
		
		UserTypesResponse res = new UserTypesResponse();
		res.setTypes(ret);
		return res;
	}
}
