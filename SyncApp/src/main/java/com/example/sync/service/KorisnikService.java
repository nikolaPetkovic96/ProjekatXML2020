package com.example.sync.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

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

			
			ret.add(t);
		}
		UserTypesResponse res = new UserTypesResponse();
		res.setTypes(ret);
		return res;
	}
	
	public UserTypesResponse postUser(Long id, String korisnickoIme, String lozinka, String email,
										String status, Long adresaId, String pol, String ime, String prezime, String jmbg,
										String nazivFirme, String poslovniMaticniBroj, 
										boolean allowedToCommend, boolean allowedToMessage, boolean allowedToMakeReservation) {
		UserType body=new UserType(id,  korisnickoIme, lozinka, email,
								status, adresaId, pol, ime, prezime, jmbg, 
								nazivFirme, poslovniMaticniBroj,
								allowedToCommend, allowedToMessage, allowedToMakeReservation);
		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("api/user/sync")
				.withMethod(HttpMethod.POST).withBody(body).send();
		List<UserType> ret = new LinkedList<>();
		for (Map m : trans) {
			UserType t = new UserType();
			t.setId(((Number) m.get("id")).longValue());
			
			t.setKorisnickoIme((String) m.get("korisnickoIme"));
			t.setLozinka((String) m.get("lozinka"));
			t.setEmail((String) m.get("email"));
			t.setStatus((String) m.get("status"));
			t.setAdresaId((Long) m.get("adresaId"));
			
			t.setPol((String) m.get("pol"));
			t.setIme((String) m.get("ime"));
			t.setPrezime((String) m.get("prezime"));
			t.setJmbg((String) m.get("jmbg"));
			
			t.setNazivFirme((String) m.get("nazivFirme"));
			t.setPoslovniMaticniBroj((String) m.get("poslovniMaticniBroj"));
			
			t.setAllowedToCommend((boolean) m.get("allowedToCommend"));
			t.setAllowedToMessage((boolean) m.get("allowedToMessage"));
			t.setAllowedToMakeReservation((boolean) m.get("allowedToMakeReservation"));
			
			ret.add(t);
		}
		UserTypesResponse res = new UserTypesResponse();
		res.setTypes(ret);
		return res;
	}

}
