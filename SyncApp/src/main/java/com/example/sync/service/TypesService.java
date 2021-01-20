//package com.example.sync.service;
//
//import java.time.LocalDateTime;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Service;
//
//import com.example.sync.dto.adresa.Adresa;
//import com.example.sync.dto.adresa.AdresaResponse;
//import com.example.sync.dto.automobil.Automobil;
//import com.example.sync.dto.automobil.AutomobilResponse;
//import com.example.sync.dto.automobil.brand.Brand;
//import com.example.sync.dto.automobil.brand.BrandResponse;
//import com.example.sync.dto.automobil.carClass.Klasa;
//import com.example.sync.dto.automobil.carClass.KlasaResponse;
//import com.example.sync.dto.automobil.fuel.FuelType;
//import com.example.sync.dto.automobil.fuel.FuelTypeResponse;
//import com.example.sync.dto.automobil.model.Model;
//import com.example.sync.dto.automobil.model.ModelResponse;
//import com.example.sync.dto.automobil.slika.Slika;
//import com.example.sync.dto.automobil.slika.SlikaResponse;
//import com.example.sync.dto.automobil.transmission.TransmissionType;
//import com.example.sync.dto.automobil.transmission.TransmissionTypesResponse;
//import com.example.sync.dto.commonData.CommonData;
//import com.example.sync.dto.commonData.CommonDataResponse;
//import com.example.sync.dto.komentar.Komentar;
//import com.example.sync.dto.komentar.KomentarResponse;
//import com.example.sync.dto.ocena.Ocena;
//import com.example.sync.dto.ocena.OcenaResponse;
//import com.example.sync.dto.oglas.Oglas;
//import com.example.sync.dto.oglas.OglasResponse;
//import com.example.sync.dto.oglas.cenovnik.Cenovnik;
//import com.example.sync.dto.oglas.cenovnik.CenovnikResponse;
//import com.example.sync.dto.poruka.Poruka;
//import com.example.sync.dto.poruka.PorukaResponse;
//import com.example.sync.dto.rezervacija.Rezervacija;
//import com.example.sync.dto.rezervacija.RezervacijaResponse;
//import com.example.sync.dto.rezervacija.izvestaj.Izvestaj;
//import com.example.sync.dto.rezervacija.izvestaj.IzvestajResponse;
//import com.example.sync.dto.rezervacija.narudzbenica.Narudzbenica;
//import com.example.sync.dto.rezervacija.narudzbenica.NarudzbenicaResponse;
//import com.example.sync.dto.user.UserType;
//import com.example.sync.dto.user.UserTypesResponse;
//
//@Service
//public class TypesService {
//
//	public FuelTypeResponse getFuelTypes() {
//		List<Map> fluel = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/fuel")
//				.withMethod(HttpMethod.GET).send();
//		List<FuelType> ret = new LinkedList<>();
//		for (Map m : fluel) {
//			FuelType t = new FuelType();
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setId(((Number) m.get("id")).longValue());
//			t.setNazivTipa((String) m.get("nazivTipa"));
//			ret.add(t);
//		}
//		FuelTypeResponse res = new FuelTypeResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public TransmissionTypesResponse getTransmissionTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/transmission")
//				.withMethod(HttpMethod.GET).send();
//		List<TransmissionType> ret = new LinkedList<>();
//		for (Map m : trans) {
//			TransmissionType t = new TransmissionType();
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setId(((Number) m.get("id")).longValue());
//			t.setNazivTipa((String) m.get("nazivMenjaca"));
//			ret.add(t);
//		}
//		TransmissionTypesResponse res = new TransmissionTypesResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public ModelResponse getModelTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/model")
//				.withMethod(HttpMethod.GET).send();
//		List<Model> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Model t = new Model();
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setId(((Number) m.get("id")).longValue());
//			t.setNazivModela((String) m.get("nazivModela"));
//			t.setMarkaAutomobilaId(((Number) m.get("markaAutomobilaId")).longValue());
//			ret.add(t);
//		}
//		ModelResponse res = new ModelResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public BrandResponse getBrandTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/brand")
//				.withMethod(HttpMethod.GET).send();
//		List<Brand> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Brand t = new Brand();
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setId(((Number) m.get("id")).longValue());
//			t.setNazivMarke((String) m.get("nazivMarke"));
//			ret.add(t);
//		}
//		BrandResponse res = new BrandResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public KlasaResponse getClassTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/class")
//				.withMethod(HttpMethod.GET).send();
//		List<Klasa> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Klasa t = new Klasa();
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setId(((Number) m.get("id")).longValue());
//			t.setNazivKlase((String) m.get("nazivKlase"));
//			ret.add(t);
//		}
//		KlasaResponse res = new KlasaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public SlikaResponse getSlikaTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/slikaVozila")
//				.withMethod(HttpMethod.GET).send();
//		List<Slika> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Slika t = new Slika();
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setId(((Number) m.get("id")).longValue());
//			t.setAutomobilId(((Number) m.get("automobilId")).longValue());
//			t.setSlika((String[]) m.get("slika"));
//			ret.add(t);
//		}
//		SlikaResponse res = new SlikaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public CommonDataResponse getCommonDataTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/commonData")
//				.withMethod(HttpMethod.GET).send();
//		List<CommonData> ret = new LinkedList<>();
//		for (Map m : trans) {
//			CommonData t = new CommonData();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setDatumKreiranja((LocalDateTime) m.get("datumKreiranja"));
//			t.setDatumIzmene((LocalDateTime) m.get("datumIzmene"));
//			t.setUserId((Long) m.get("userId"));
//			ret.add(t);
//		}
//		CommonDataResponse res = new CommonDataResponse();
//		res.setTypes(ret);
//		return res;
//	}
//
//	public AutomobilResponse getAutomobilTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.CAR).withPath("/automobil")
//				.withMethod(HttpMethod.GET).send();
//		List<Automobil> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Automobil t = new Automobil();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setBrojSedistaZaDecu(((Number)m.get("brojSedistaZaDecu")).intValue());
//			t.setCollisionDamageWaiver((boolean) m.get("collisionDamageWaiver"));
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setKlasaAutomobilaId((Long) m.get("klasaAutomobilaId"));
//			t.setMarkaAutomobilaId((Long) m.get("markaAutomobila"));
//			t.setModelAutomobilaId((Long) m.get("modelAutomobila"));
//			t.setPredjenaKilometraza((float) m.get("predjenaKilometraza"));		
//			t.setTipMenjacaId((Long) m.get("tipMenjaca"));
//			t.setUkupnaOcena((float) m.get("ukupnaOcena"));			
//			ret.add(t);
//		}
//		AutomobilResponse res = new AutomobilResponse();
//		res.setTypes(ret);
//		return res;
//		
//	}
//	public KomentarResponse getKomentarTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.KOMENTAROCENA).withPath("/komentar")
//				.withMethod(HttpMethod.GET).send();
//		List<Komentar> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Komentar t = new Komentar();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setAutomobilId((Long) m.get("automobilId"));
//			t.setAutor((String) m.get("autor"));
//			t.setOdobren((boolean) m.get("odobren"));
//			t.setRezervacijaId((Long) m.get("rezervacija"));
//			t.setTekstKomentara((String) m.get("tekstKomentara"));
//			ret.add(t);
//		}
//		KomentarResponse res = new KomentarResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public OcenaResponse getOcenaTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.KOMENTAROCENA).withPath("/ocena")
//				.withMethod(HttpMethod.GET).send();
//		List<Ocena> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Ocena t = new Ocena();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setAutomobilId((Long) m.get("automobilId"));
//			t.setAutor((String) m.get("autor"));
//			t.setRezervacijaId((Long) m.get("rezervacija"));
//			t.setAutor((String) m.get("autor"));
//			ret.add(t);
//		}
//		OcenaResponse res = new OcenaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public AdresaResponse getAdresaTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/adresa")
//				.withMethod(HttpMethod.GET).send();
//		List<Adresa> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Adresa t = new Adresa();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setBroj((String) m.get("broj"));
//			t.setMesto((String) m.get("mesto"));
//			t.setPostanskiBroj((String) m.get("postanskiBroj"));
//			t.setUlica((String) m.get("ulica"));
//			ret.add(t);
//		}
//		AdresaResponse res = new AdresaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public UserTypesResponse getUserTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/user")
//				.withMethod(HttpMethod.GET).send();
//		List<UserType> ret = new LinkedList<>();
//		for (Map m : trans) {
//			UserType t = new UserType();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			
//			t.setKorisnickoIme((String) m.get("korisnickoIme"));
//			t.setLozinka((String) m.get("lozinka"));
//			t.setEmail((String) m.get("email"));
//			t.setStatus((String) m.get("status"));
//			t.setAdresaId((Long) m.get("adresaId"));
//			
//			t.setPol((String) m.get("pol"));
//			t.setIme((String) m.get("ime"));
//			t.setPrezime((String) m.get("prezime"));
//			t.setJmbg((String) m.get("prezime"));
//			
//			t.setNazivFirme((String) m.get("nazivFirme"));
//			t.setPoslovniMaticniBroj((String) m.get("poslovniMaticniBroj"));
//			
//			t.setAllowedToCommend((boolean) m.get("allowedToCommend"));
//			t.setAllowedToMessage((boolean) m.get("allowedToMessage"));
//			t.setAllowedToMakeReservation((boolean) m.get("allowedToMakeReservation"));
//			
//			ret.add(t);
//		}
//		UserTypesResponse res = new UserTypesResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public PorukaResponse getPorukaTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.MESSAGE).withPath("/message")
//				.withMethod(HttpMethod.GET).send();
//		List<Poruka> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Poruka t = new Poruka();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setAutomobilId((Long) m.get("automobilid"));
//			t.setRezervacijaId((Long) m.get("rezervacijaId"));
//			t.setTekstPoruke((String) m.get("tekstPoruke"));
//			
//			ret.add(t);
//		}
//		PorukaResponse res = new PorukaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	
//	public IzvestajResponse getIzvestajTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/izvestaj")
//				.withMethod(HttpMethod.GET).send();
//		List<Izvestaj> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Izvestaj t = new Izvestaj();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setAutomobilId((Long) m.get("automobilid"));
//			t.setRezervacijaId((Long) m.get("rezervacijaId"));
//			t.setDodatniTroskovi((Long) m.get("dodatniTroskovi"));
//			t.setNarudzbenicaId((Long) m.get("narudzbenicaId"));
//			t.setPredjenaKilometraza((float) m.get("predjenaKilometraza"));
//			t.setPrekoracenaKilometraza((Long) m.get("prekoracenaKilometraza"));
//			t.setTekstIzvestaja((String) m.get("tekstIzvestaja"));
//			ret.add(t);
//		}
//		IzvestajResponse res = new IzvestajResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public CenovnikResponse getCenovnikTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.OGLAS).withPath("/cenovnik")
//				.withMethod(HttpMethod.GET).send();
//		List<Cenovnik> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Cenovnik t = new Cenovnik();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setCenaCollisionDamageWaiver((float) m.get("cenaCollisionDamageWaiver"));
//			t.setCenaPoDanu((float) m.get("cenaPoDanu"));
//			t.setCenaPoKilometru((float) m.get("cenaPoKilometru"));
//			t.setNazivCenovnika((String) m.get("nazivCenovnika"));
//			t.setPopustZaPreko30Dana((float) m.get("popustZaPreko30Dana"));
//			ret.add(t);
//		}
//		CenovnikResponse res = new CenovnikResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public NarudzbenicaResponse getNarudzbenicaTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/narudzbenica")
//				.withMethod(HttpMethod.GET).send();
//		List<Narudzbenica> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Narudzbenica t = new Narudzbenica();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setOdDatuma((LocalDateTime) m.get("odDatuma"));
//			t.setDoDatuma((LocalDateTime) m.get("doDatuma"));
//			t.setAgentId((Long) m.get("agentId"));
//			t.setUserId((Long) m.get("userId"));
//			t.setOglasId((Long) m.get("oglasId"));
//			t.setRezervacijaId((Long) m.get("rezervacijaId"));
//			ret.add(t);
//		}
//		NarudzbenicaResponse res = new NarudzbenicaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public OglasResponse getOglasTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.OGLAS).withPath("/oglas")
//				.withMethod(HttpMethod.GET).send();
//		List<Oglas> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Oglas t = new Oglas();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setOdDatuma((LocalDateTime) m.get("odDatuma"));
//			t.setDoDatuma((LocalDateTime) m.get("doDatuma"));
//			t.setAdresaId((Long) m.get("adresaId"));
//			t.setAutomobilId((Long) m.get("automobilId"));
//			t.setCenovnikId((Long) m.get("cenovnikId"));
//			t.setPlaniranaKm((float) m.get("planiranaKm"));
//			t.setUsername((String) m.get("username"));
//			ret.add(t);
//		}
//		OglasResponse res = new OglasResponse();
//		res.setTypes(ret);
//		return res;
//	}
//	public RezervacijaResponse getRezervacijaTypes() {
//		List<Map> trans = (List<Map>) RESTClient.getClient().forService(Services.RESERVATION).withPath("/rezervacija")
//				.withMethod(HttpMethod.GET).send();
//		List<Rezervacija> ret = new LinkedList<>();
//		for (Map m : trans) {
//			Rezervacija t = new Rezervacija();
//			t.setId(((Number) m.get("id")).longValue());
//			t.setCommonDataId(((Number) m.get("commonDataId")).longValue());
//			t.setBundle((Boolean) m.get("bundle"));
//			t.setNapomena((String) m.get("napomena"));
//			t.setStatusRezervacije((String) m.get("statusRezervacije"));
//			t.setUkupnaCena((double) m.get("ukupnaCena"));
//		}
//		RezervacijaResponse res = new RezervacijaResponse();
//		res.setTypes(ret);
//		return res;
//	}
//}
