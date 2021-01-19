package com.team32.AgentApp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.DTO.AutomobilDetailsDTO;
import com.team32.AgentApp.DTO.AutomobilImgDTO;
import com.team32.AgentApp.DTO.CenovnikDTO;
import com.team32.AgentApp.DTO.OglasDTO;
import com.team32.AgentApp.DTO.OglasDetailsDTO;
import com.team32.AgentApp.DTO.OglasDetailsImgDTO;
import com.team32.AgentApp.DTO.SlikaVozilaDTO;
import com.team32.AgentApp.model.entitet.Cenovnik;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.repository.OglasRepository;

@Service
public class OglasService {

	@Autowired
	private OglasRepository oglasRepository;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private UserService userService;
	@Autowired
	private NarudzbenicaService narudzbService;
	
	@Autowired
	private AdresaService adresaService;
	@Autowired
	private CenovnikService cenovnikService;
	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	public List<Oglas> getAllOglas(){
		List<Oglas> oglasi = new ArrayList<>();
		oglasRepository.findAll().forEach(oglasi::add);
		return oglasi;
	}
	
	public Oglas findOne(Long id) {
		return oglasRepository.findById(id).orElse(null);
	}
	
	public Oglas addOglas(Oglas oglas) throws Exception{
		if(oglas.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Oglas savedOglas = oglasRepository.save(oglas);
		return savedOglas;
	}
	public Oglas updateOglas(Long id, Oglas oglas) throws Exception{
		Optional<Oglas> oglasToUpdate = oglasRepository.findById(id);
		if(oglasToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Oglas updateOglas = oglasRepository.save(oglas);
		return updateOglas;
	}
	public void deleteOglas(Long id) {
		oglasRepository.deleteById(id);
	}

	//Dodatne metode
	
	//Metoda koja vraca sve oglase napravljene od strane jednog agenta
	public List<Oglas> getAllOglasByAgentId(Long agentId) {
		List<Oglas> oglasi = new ArrayList<>();
		
		//Dobavim sve oglase iz baze
		List<Oglas> sviOglasi = oglasRepository.findAll();
		
		//Prolazim kroz oglase i proveravam da li je agentId = userId u commonData oglasa
		for(Oglas o : sviOglasi){
			if(comDataService.findOne(o.getCommonDataId()).getUserid() == agentId) {
				oglasi.add(o);
			}
		}
		return oglasi;
	}
	
	//POMOCNE METODE ovde su img
		public OglasDetailsImgDTO getOglasFullDetailsImg(Oglas o) throws Exception {
			OglasDetailsImgDTO oglasDTO = new OglasDetailsImgDTO();
			
			CommonData comData = comDataService.findOne(o.getCommonDataId());
			if(comData == null) {
				return null;
			}
			
			User user = userService.findOne(comData.getUserid());
			if(user == null) {
				return null;
			}
			
			Cenovnik cenovnik = cenovnikService.findOne(o.getCenovnikId());
			if(cenovnik == null) {
				return null;
			}
			
			AutomobilDTO automobilDTO = automobilService.findOneWithDetails(o.getAutomobilId());
			if(automobilDTO == null) {
				return null;
			}
			
			SlikaVozilaDTO slike = automobilService.getSlikeVozila(automobilDTO.getId());
			AutomobilImgDTO automobilImgDto = new AutomobilImgDTO(automobilDTO, slike); 

			Adresa adresa = adresaService.findOne(o.getAdresaId());
			if(adresa == null) {
				return null;
			}

			oglasDTO.setId(o.getId());
			oglasDTO.setOdDatuma(o.getOdDatuma());
			oglasDTO.setDoDatuma(o.getDoDatuma());
			
			oglasDTO.setAgentId(comData.getUserid());
			oglasDTO.setKorImeAgenta(user.getKorisnickoIme());

			oglasDTO.setPlaniranaKilometraza(o.getPlaniranaKilometraza());
			oglasDTO.setAdresa(new AdresaDTO(adresa));
			oglasDTO.setAutomobil(automobilImgDto);
			oglasDTO.setCenovnik(new CenovnikDTO(cenovnik));
			
			return oglasDTO;
		}
	
	
	//POMOCNE METODE ovde su 
	public OglasDTO getOglasFullDetails(Oglas o) {
		OglasDTO oglasDTO = new OglasDTO();
		
		CommonData comData = comDataService.findOne(o.getCommonDataId());
		if(comData == null) {
			return null;
		}
		
		User user = userService.findOne(comData.getUserid());
		if(user == null) {
			return null;
		}
		
		Cenovnik cenovnik = cenovnikService.findOne(o.getCenovnikId());
		if(cenovnik == null) {
			return null;
		}
		
		AutomobilDTO automobilDTO = automobilService.findOneWithDetails(o.getAutomobilId());
		if(automobilDTO == null) {
			return null;
		}
		
		Adresa adresa = adresaService.findOne(o.getAdresaId());
		if(adresa == null) {
			return null;
		}

		oglasDTO.setId(o.getId());
		oglasDTO.setCenovnikId(o.getCenovnikId());
		oglasDTO.setAutomobilId(o.getAutomobilId());
		oglasDTO.setAdresaId(o.getAdresaId());
		oglasDTO.setCommonDataId(o.getCommonDataId());
		oglasDTO.setOdDatuma(o.getOdDatuma());
		oglasDTO.setDoDatuma(o.getDoDatuma());
		
		oglasDTO.setAgentId(comData.getUserid());
		oglasDTO.setKorImeAgenta(user.getKorisnickoIme());

		oglasDTO.setPlaniranaKilometraza(o.getPlaniranaKilometraza());
		oglasDTO.setZauzetiTermini(getZauzetiTermini2(narudzbService.getAllNarudzbeniceByOglasId(o.getId())));
		oglasDTO.setAdresa(new AdresaDTO(adresa));
		oglasDTO.setAutomobil(automobilDTO);
		oglasDTO.setCenovnik(new CenovnikDTO(cenovnik));
		
		return oglasDTO;
	}
	
	public OglasDetailsDTO getOglasFullDetailsMilisec(Oglas o) {
		OglasDetailsDTO oglasDTO = new OglasDetailsDTO();
		
		CommonData comData = comDataService.findOne(o.getCommonDataId());
		if(comData == null) {
			return null;
		}
		
		User user = userService.findOne(comData.getUserid());
		if(user == null) {
			return null;
		}
		
		Cenovnik cenovnik = cenovnikService.findOne(o.getCenovnikId());
		if(cenovnik == null) {
			return null;
		}
		
		AutomobilDTO automobilDTO = automobilService.findOneWithDetails(o.getAutomobilId());
		if(automobilDTO == null) {
			return null;
		}
		
		Adresa adresa = adresaService.findOne(o.getAdresaId());
		if(adresa == null) {
			return null;
		}

		oglasDTO.setId(o.getId());
		oglasDTO.setOdDatuma(o.getOdDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
		oglasDTO.setDoDatuma(o.getDoDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
		
		oglasDTO.setAgentId(comData.getUserid());
		oglasDTO.setKorImeAgenta(user.getKorisnickoIme());

		oglasDTO.setPlaniranaKilometraza(o.getPlaniranaKilometraza());
		oglasDTO.setZauzetiTermini(getZauzetiTermini(narudzbService.getAllNotPandingNarudzbeniceByOglasId(o.getId())));
		oglasDTO.setAdresa(new AdresaDTO(adresa));
		oglasDTO.setAutomobil(automobilDTO);
		oglasDTO.setCenovnik(new CenovnikDTO(cenovnik));
		
		return oglasDTO;
	}

	//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
	public List<HashMap<String, Long>> getZauzetiTermini(List<Narudzbenica> narudzbenice) {
		List<HashMap<String, Long>> zauzetiTermini = new  ArrayList<HashMap<String, Long>>();
		for (Narudzbenica n : narudzbenice) {
			
			//vracamo samo one narudzbenice cije rezervacije nisu CANCELED
			//To je uradjeno zato da bi se u slucaju kada se status rezervacije promeni na caceled
			//oslobodio termin koji je ona drzala zauzetim u oglasu.
			if(!rezervacijaService.findOne(n.getRezervacijaId()).getStatusRezervacije().equals("CANCELED")) {
				HashMap<String, Long> hash_map = new HashMap<String, Long>();
				hash_map.put("from", n.getOdDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
				hash_map.put("to", n.getDoDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
				System.out.println("Initial Mappings are: " + hash_map);
				zauzetiTermini.add(hash_map);
			}
		
		}
		
		return zauzetiTermini;
	}
	
	
	//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
		public List<HashMap<String, LocalDateTime>> getZauzetiTermini2(List<Narudzbenica> narudzbenice) {
			List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
			for (Narudzbenica n : narudzbenice) {
				
				HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
				hash_map.put("from", n.getOdDatuma());
				hash_map.put("to", n.getDoDatuma());
				System.out.println("Initial Mappings are: " + hash_map);
				zauzetiTermini.add(hash_map);
			}
			
			return zauzetiTermini;
		}

		public List<Oglas> getAllOglasByAutomobilId(Long automobilId) {
			
			return oglasRepository.findAllByAutomobilId(automobilId);
		}

}
