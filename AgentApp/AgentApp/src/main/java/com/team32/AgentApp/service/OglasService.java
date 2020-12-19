package com.team32.AgentApp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.DTO.CenovnikDTO;
import com.team32.AgentApp.DTO.OglasDTO;
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
	
	//POMOCNE METODE
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
		oglasDTO.setZauzetiTermini(getZauzetiTermini(narudzbService.getAllNarudzbeniceByOglasId(o.getId())));
		oglasDTO.setAdresa(new AdresaDTO(adresa));
		oglasDTO.setAutomobil(automobilDTO);
		oglasDTO.setCenovnik(new CenovnikDTO(cenovnik));
		
		return oglasDTO;
	}

		//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
		public List<HashMap<String, LocalDateTime>> getZauzetiTermini(List<Narudzbenica> narudzbenice) {
			List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
			for (Narudzbenica n : narudzbenice) {
				//ovaj deo koda potencijalno izmeniti za TerminDTO:
				HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
				hash_map.put("odDatuma", n.getOdDatuma());
				hash_map.put("doDatuma", n.getDoDatuma());
				System.out.println("Initial Mappings are: " + hash_map);
				zauzetiTermini.add(hash_map);
			}
			
			return zauzetiTermini;
		}

}
