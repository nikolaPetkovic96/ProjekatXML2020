package com.team32.AgentApp.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.entitet.Cenovnik;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Izvestaj;
import com.team32.AgentApp.model.entitet.Komentar;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Ocena;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.entitet.Poruka;
import com.team32.AgentApp.model.entitet.Rezervacija;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.model.tentitet.KlasaAutomobila;
import com.team32.AgentApp.model.tentitet.MarkaAutomobila;
import com.team32.AgentApp.model.tentitet.ModelAutomobila;
import com.team32.AgentApp.model.tentitet.SlikaVozila;
import com.team32.AgentApp.model.tentitet.TipGoriva;
import com.team32.AgentApp.model.tentitet.TipMenjaca;
import com.team32.AgentApp.repository.AdresaRepository;
import com.team32.AgentApp.repository.AutomobilRepository;
import com.team32.AgentApp.repository.CenovnikRepository;
import com.team32.AgentApp.repository.CommonDataRepository;
import com.team32.AgentApp.repository.IzvestajRepository;
import com.team32.AgentApp.repository.KlasaAutomobilaRepository;
import com.team32.AgentApp.repository.KomentarRepository;
import com.team32.AgentApp.repository.MarkaAutomobilaRepository;
import com.team32.AgentApp.repository.ModelAutomobilaRepository;
import com.team32.AgentApp.repository.NarudzbenicaRepository;
import com.team32.AgentApp.repository.OcenaRepository;
import com.team32.AgentApp.repository.OglasRepository;
import com.team32.AgentApp.repository.PorukaRepository;
import com.team32.AgentApp.repository.RezervacijaRepository;
import com.team32.AgentApp.repository.SlikaVozilaRepository;
import com.team32.AgentApp.repository.TipGorivaRepository;
import com.team32.AgentApp.repository.TipMenjacaRepository;
import com.team32.AgentApp.repository.UserRepository;
import com.team32.AgentApp.soap.dto.client.AutombilClient;
import com.team32.AgentApp.soap.dto.client.KomunikacijaClient;
import com.team32.AgentApp.soap.dto.client.OglasClient;
import com.team32.AgentApp.soap.dto.client.RezervacijaClient;

@Service
public class SyncService {

	@Autowired
	private AutombilClient autombilClient;
	@Autowired
	private KomunikacijaClient komunikacijaClient;
	@Autowired
	private OglasClient oglasClient;
	@Autowired
	private RezervacijaClient rezervClient;
	
	@Autowired
	private MarkaAutomobilaRepository markaAutoRep;
	@Autowired
	private ModelAutomobilaRepository modAutoRep;
	@Autowired
	private KlasaAutomobilaRepository klasaAutoRep;
	@Autowired
	private TipMenjacaRepository tipMenjacaRep;
	@Autowired
	private TipGorivaRepository tipGorivaRep;
	@Autowired
	private AutomobilRepository autoRep;
	@Autowired
	private SlikaVozilaRepository slikaRep;
	@Autowired
	private CommonDataRepository commonDataRep;
	@Autowired
	private KomentarRepository komentarRep;
	@Autowired
	private OcenaRepository ocenaRep;
	@Autowired
	private PorukaRepository porukaRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private OglasRepository oglasRep;
	@Autowired
	private AdresaRepository adresaRep;
	@Autowired
	private CenovnikRepository cenovnikRep;
	@Autowired
	private RezervacijaRepository rezervRep;
	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired
	private IzvestajRepository izvRep;
	
	/***
	 * Metoda koja sluzi da se prilikom logovanja agenta azurira lokalna baza sa glavnom
	 */
	public void init() {
		
		pullMarkaAut();
		pullModelAut();
		pullKlasaAut();
		pullTipGoriva();
		pullTipMenjaca();
		pullAutomobil();
		pullSlikaVozila();
		pullCommonData();
		
		pullKomentare();
		pullOcene();
		pullPoruke();
		pullUser();

		pullOglas();
		pullAdresa();
		pullCenovnike();
		
		pullRezervacije();
		pullNarudzbenica();
		pullIzvestaj();
		
	}
			
		public void pullMarkaAut() {
			List<MarkaAutomobila> ma = autombilClient.getAllMarka();
			markaAutoRep.saveAll(ma);
			markaAutoRep.flush();
	
		}
		public void pullModelAut() {
			List<ModelAutomobila> ma = autombilClient.getAllModel();
			modAutoRep.saveAll(ma);
			modAutoRep.flush();
		}
		public void pullKlasaAut() {
			List<KlasaAutomobila> ka = autombilClient.getAllKlasa();
			klasaAutoRep.saveAll(ka);
			klasaAutoRep.flush();
		}
		public void pullTipGoriva() {
			List<TipGoriva> tg = autombilClient.getAllTipGoriva();
			tipGorivaRep.saveAll(tg);
			tipGorivaRep.flush();
		}
		public void pullTipMenjaca() {
			List<TipMenjaca> tm = autombilClient.getAllTipMenjaca();
			tipMenjacaRep.saveAll(tm);
			tipMenjacaRep.flush();
		}
		public void pullAutomobil() {
			List<Automobil> aut = autombilClient.getAllAutomobil();
			autoRep.saveAll(aut);
			autoRep.flush();
		}
		public void pullSlikaVozila() {
			List<SlikaVozila> sv = autombilClient.getAllSlikaVozila();
			slikaRep.saveAll(sv);
			slikaRep.flush();
		}
		public void pullCommonData() {
			List<CommonData> cmd = autombilClient.getAllCommonData();
			commonDataRep.saveAll(cmd);
			commonDataRep.flush();
		}
		
		
		public void pullKomentare() {
			List<Komentar> kom = komunikacijaClient.getAllKomentar();
			komentarRep.saveAll(kom);
			komentarRep.flush();
		}
		public void pullOcene() {
			List<Ocena> oc = komunikacijaClient.getAllOcena();
			ocenaRep.saveAll(oc);
			ocenaRep.flush();
		}
		public void pullPoruke() {
			List<Poruka> por = komunikacijaClient.getAllPoruka();
			porukaRep.saveAll(por);
			porukaRep.flush();
		}
		public void pullUser() {
			List<User> user = komunikacijaClient.getAllUsers();
			userRep.saveAll(user);
			userRep.flush();
		}

		
		public void pullOglas() {
			List<Oglas> ogl = oglasClient.getAllOglas();
			oglasRep.saveAll(ogl);
			oglasRep.flush();
		}
		public void pullAdresa() {
			List<Adresa> adr = oglasClient.getAllAdresa();
			adresaRep.saveAll(adr);
			adresaRep.flush();
		}
		public void pullCenovnike() {
			List<Cenovnik> cen = oglasClient.getAllCenovnik();
			cenovnikRep.saveAll(cen);
			cenovnikRep.flush();
		}
		
		
		public void pullRezervacije() {
			List<Rezervacija> rez = rezervClient.getAllRezervacija();
			rezervRep.saveAll(rez);
			rezervRep.flush();
		}
		public void pullNarudzbenica() {
			List<Narudzbenica> nar = rezervClient.getAllNarudzbenica();
			narRep.saveAll(nar);
			narRep.flush();
		}
		public void pullIzvestaj() {
			List<Izvestaj> izv = rezervClient.getAllIzvestaj();
			izvRep.saveAll(izv);
			izvRep.flush();
		}

}
