package com.example.Oglas.service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.dto.OglasNewDTO;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.Narudzbenica;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.model.TAdresa;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.OglasRepository;
import com.example.Oglas.service.mapper.OglasMapper;

@Service
public class OglasService {
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired 
	private OglasMapper oglasMapper;
	@Autowired
	private OglasRepository oglasRep;
//	@Autowired
//	private UserService userServ;
	@Autowired
	private TAdresaService adrServ;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private NarudzbenicaService narServ;
	
	
	//GET ALL
	public List<OglasDTO> getAll() {
		List<Oglas> pom = oglasRep.findAll();
		List<OglasDTO> retDTO = new ArrayList<>();
		for(Oglas p:pom) {
			retDTO.add(oglasMapper.toDTO(p));
		}
		return retDTO;
//		return oglasRep.findAll().stream().
//				map(oglas->oglasMapper.toDTO(oglas))
//				.collect(Collectors.toList());
	}
	
	//GET ONE
	public OglasDTO getOglas(Long id) {
		return oglasRep.findById(id).map(oglas-> oglasMapper.toDTO(oglas)).orElse(null);
	}
	
	
	//GET ALL USERS
	public List<OglasDTO> getOglaseForUser() {
		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		List<Oglas> pom = oglasRep.findAll();
		List<OglasDTO> retDTO = new ArrayList<>();
		for(Oglas p:pom) {
			CommonData comData = cmdServ.findOne(p.getCommonDataId());
			if(comData.getUserId() == userId) {
				retDTO.add(oglasMapper.toDTO(p));
			}
		}
		return retDTO;
		
	}
	
	public ResponseEntity<String> deleteOglas(Long id) {
		Oglas o=oglasRep.findById(id).orElse(null);
		if(o!=null) {
			List<HashMap<String, LocalDateTime>> imaZauzetihTermina = getZauzetiTermini(narServ.getAllByOglas(o.getId()));
			//Ako nema rezervacija vezanih za sebe
			if(imaZauzetihTermina.size() == 0){
				TAdresa adresa =  adrServ.findById(o.getAdresaId());
				//obrise se adresa vezana za oglas
				adrServ.deleteAdresa(adresa.getId());
				//obrise se i commonData te adrese
//				cmdServ.deleteCommonData(adresa.getCommonDataId());
				
				//obrise se sam oglas
				oglasRep.deleteById(id);
				//obrise se commonData tog oglasa
				cmdServ.deleteCommonData(o.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				//Zbog ovog rucnog errora moramo imati return type Response entity;
				return  ResponseEntity
			            .status(HttpStatus.NOT_FOUND)
			            .body("There are reservations connected to this ad!");
			}

		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		
	}


	public OglasDTO getOglasDetails(Long id) {
		// TODO Auto-generated method stub
		//GETOVATI OGLAS KOJI SADRZI AUTOMOBIL SA SLIKAMA
		return null;
	}

	public ResponseEntity<?> addOglas(OglasNewDTO dto, String username) throws Exception {
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		if(isIntervalSlobodan(userId, dto)==false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Za odabrani termin vec postoji oglas!");
		}
		
		CommonData cmd = new CommonData();
		cmd.setDatumKreiranja(LocalDateTime.now());
		cmd.setUserId(userId);
		cmd.setDatumIzmene(LocalDateTime.now());
		
		TAdresa adresa = adrServ.addAdresa(dto.getAdresa(),userId);
		
		Oglas novi=new Oglas();
		novi.setUsername(username);
		novi.setOdDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId()));
		novi.setDoDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId()));
		novi.setAutomobilId(dto.getAutomobilId());
		novi.setCenovnikId(dto.getCenovnikId());
		novi.setPlaniranaKm(dto.getPlaniranaKilometraza());
		novi.setAdresaId(adresa.getId());
		
		cmd=cmdServ.addCommonData(cmd);
		novi.setCommonDataId(cmd.getId());
		
		novi = oglasRep.save(novi);
	
		return new ResponseEntity<>(oglasMapper.toDTO(novi), HttpStatus.CREATED);
	}
	
	//Provera da li se novi oglas poklapa sa neki drugi vec kreiranim oglasom za interval i utomobil 
			//(za razlicite automobile mogu postojati oglasi u istom terminu)... 
			public boolean isIntervalSlobodan(Long agentId, OglasNewDTO dto){
				List<Oglas> oglas = oglasRep.findAll().stream().filter(x->cmdRep.getOne(x.getCommonDataId()).getUserId().equals(agentId)).collect(Collectors.toList());
				//Pocetak i kraj novog oglasa
				LocalDateTime odDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId());
				LocalDateTime doDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId());
				//id automobila novo
				Long automobilId = dto.getAutomobilId();
				for(Oglas o:oglas) {
					//Ovo pokriva kada su oba intervala novog u intervalu starog ili je pocetak ili kraj novog u intervalu starog...
					//Pocetak novog je u intervalu postojeceg oglasa;
					if(odDatuma.isAfter(o.getOdDatuma()) && odDatuma.isBefore(o.getDoDatuma()) &&  automobilId == o.getAutomobilId()) {
						return false;
					}
					//Kraj novog je u intervalu postojeceg oglasa;
					else if(doDatuma.isAfter(o.getOdDatuma()) && doDatuma.isBefore(o.getDoDatuma()) && automobilId == o.getAutomobilId()) {
						return false;
					}
					//Stari interval je u intervalu novog oglasa; np|   sp|   |sk   |nk
					else if(odDatuma.isBefore(o.getOdDatuma()) && doDatuma.isAfter(o.getDoDatuma()) &&  automobilId == o.getAutomobilId()) {
						return false;
					}
				}
				return true;
	}
			
	//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
	public List<HashMap<String, LocalDateTime>> getZauzetiTermini(List<Narudzbenica> narudzbenice) {
		List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
		for (Narudzbenica n : narudzbenice) {
			
			HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
			hash_map.put("odDatuma", n.getOdDatuma());
			hash_map.put("doDatuma", n.getDoDatuma());
			System.out.println("Initial Mappings are: " + hash_map);
			zauzetiTermini.add(hash_map);
		}
		
		return zauzetiTermini;
	}
			
			
}
