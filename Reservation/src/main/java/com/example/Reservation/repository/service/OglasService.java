package com.example.Reservation.repository.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reservation.dto.OglasDTO;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.TAdresa;
import com.example.Reservation.model.TUser;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.service.mapper.OglasMapper;


@Service
public class OglasService {
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired 
	private OglasMapper oglasMapper;
	@Autowired
	private OglasRepository oglasRep;
	@Autowired
	private UserService userServ;
	@Autowired
	private TAdresaService adrServ;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private NarudzbenicaService narServ;
	
	public OglasDTO getOglas(Long id) {
		return oglasRep.findById(id).map(oglas-> oglasMapper.toDTO(oglas)).orElse(null);
	}
	
	public List<OglasDTO> getOglaseForUser(Long userId){//user id
		return oglasRep.findAll().stream().
				filter(oglas-> oglas.getId()==userId).
				map(oglas->oglasMapper.toDTO(oglas))
				.collect(Collectors.toList());
	}
	
//	public Boolean deleteOglas(Long id) {
//		Oglas o=oglasRep.findById(id).orElse(null);
//		if(o!=null) {
//			List<HashMap<String, LocalDateTime>> imaZauzetihTermina = getZauzetiTermini(narServ.getAllByOglas(o.getId()));
//			
//			if(imaZauzetihTermina.size() == 0){
//				TAdresa adresa =  adrServ.findById(o.getAdresaId());
//				//obrise se adresa vezana za oglas
//				adrServ.deleteAdresa(adresa.getId());
//				//obrise se i commonData te adrese
//				cmdServ.deleteCommonData(adresa.getCommonDataId());
//				
//				//obrise se sam oglas
//				oglasRep.deleteById(id);
//				//obrise se commonData tog oglasa
//				cmdServ.deleteCommonData(o.getCommonDataId());
//				return true;
//			}else {
//				return false;
//			}
//
//		} else {
//		return false;
//		} 
//		
//	}
	public OglasDTO addOglas(OglasDTO dto) {
		Oglas o=oglasMapper.fromDTO(dto);
		oglasRep.saveAndFlush(o);
		return oglasMapper.toDTO(o);
	}

	public List<OglasDTO> getAll() {
		return oglasRep.findAll().stream().
				map(oglas->oglasMapper.toDTO(oglas))
				.collect(Collectors.toList());
	}

	public OglasDTO getOglasDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public OglasDTO addOglas(OglasNewDTO dto,String username) throws Exception {
//		TUser user=userServ.findByUsername(username);
//		
//		if(isIntervalSlobodan(user.getId(), dto)==false) {
//			throw new Exception("Za odabrani termin vec postoji oglas!");
//		}
//		CommonData cmd=new CommonData();
//		cmd.setDatumKreiranja(LocalDateTime.now());
//		cmd.setUserId(user.getId());
//		cmd.setDatumIzmene(LocalDateTime.now());
//		
//		TAdresa adresa=adrServ.addAdresa(dto.getAdresa(),user.getId());
//		
//		Oglas novi=new Oglas();
//		novi.setOdDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId()));
//		novi.setDoDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId()));
//		novi.setAutomobilId(dto.getAutomobilId());
//		novi.setCenovnikId(dto.getCenovnikId());
//		novi.setPlaniranaKm(dto.getPlaniranaKilometraza());
//		
//		cmd=cmdServ.addCommonData(cmd);
//		novi.setCommonDataId(cmd.getId());
//		
//		novi=oglasRep.save(novi);
//		return oglasMapper.toDTO(novi);
//	}
	
	//Provera da li se novi oglas poklapa sa neki drugi vec kreiranim oglasom za interval i utomobil 
			//(za razlicite automobile mogu postojati oglasi u istom terminu)... 
//			public boolean isIntervalSlobodan(Long agentId, OglasNewDTO dto){
//				List<Oglas> oglas = oglasRep.findAll().stream().filter(x->cmdRep.getOne(x.getCommonDataId()).getUserid().equals(agentId)).collect(Collectors.toList());
//				//Pocetak i kraj novog oglasa
//				LocalDateTime odDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId());
//				LocalDateTime doDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId());
//				//id automobila novo
//				Long automobilId = dto.getAutomobilId();
//				for(Oglas o:oglas) {
//					//Ovo pokriva kada su oba intervala novog u intervalu starog ili je pocetak ili kraj novog u intervalu starog...
//					//Pocetak novog je u intervalu postojeceg oglasa;
//					if(odDatuma.isAfter(o.getOdDatuma()) && odDatuma.isBefore(o.getDoDatuma()) &&  automobilId == o.getAutomobilId()) {
//						return false;
//					}
//					//Kraj novog je u intervalu postojeceg oglasa;
//					else if(doDatuma.isAfter(o.getOdDatuma()) && doDatuma.isBefore(o.getDoDatuma()) && automobilId == o.getAutomobilId()) {
//						return false;
//					}
//					//Stari interval je u intervalu novog oglasa; np|   sp|   |sk   |nk
//					else if(odDatuma.isBefore(o.getOdDatuma()) && doDatuma.isAfter(o.getDoDatuma()) &&  automobilId == o.getAutomobilId()) {
//						return false;
//					}
//				}
//				return true;
//	}
			
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