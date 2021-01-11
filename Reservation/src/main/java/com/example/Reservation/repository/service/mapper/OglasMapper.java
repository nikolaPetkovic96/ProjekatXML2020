package com.example.Reservation.repository.service.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Reservation.dto.AdresaDTO;
import com.example.Reservation.dto.CenovnikDTO;
import com.example.Reservation.dto.OglasDTO;

import com.example.Reservation.model.Automobil;
import com.example.Reservation.model.Cenovnik;
//import com.example.Oglas.model.Automobil;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.repository.AutomobilRepository;
//import com.example.Oglas.repository.AutomobilRepository;
import com.example.Reservation.repository.CenovnikRepository;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.TAdresaRepository;
import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.TAdresaService;

@Component
public class OglasMapper {
	@Autowired
	private CommonDataRepository cmdRep;
//	@Autowired
//	private TUserRepository userRep;
	@Autowired 
	private TAdresaRepository adresaRep;
	@Autowired
	private CenovnikRepository cenRep;
	@Autowired 
	private AutomobilRepository autoRep;
	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired
	private TAdresaService adrServ;
	@Autowired
	private AutomobilMapper autMapper;
	@Autowired
	private CommonDataService cmdServ;
	
	public OglasDTO toDTO(Oglas o) {
		CommonData data=cmdRep.findById(o.getCommonDataId()).get();
		OglasDTO dto=new OglasDTO(	o.getId(),
									o.getOdDatuma(),
									o.getDoDatuma(),
									o.getCenovnikId(),
									o.getCommonDataId(),
									o.getAutomobilId(),
									o.getUsername(),
									o.getAdresaId(),
									o.getPlaniranaKm());
		List<Narudzbenica> narForOglas=narRep.findAll().stream().filter(x->x.getOglasId().equals(dto.getId())).collect(Collectors.toList());
		//System.out.println(narForOglas.size());
		List<HashMap<String, LocalDateTime>> termini=new  ArrayList<HashMap<String, LocalDateTime>>();
		for(Narudzbenica n : narForOglas) {
			HashMap<String,LocalDateTime> termin=new HashMap<String, LocalDateTime>();
			termin.put("odDatuma", n.getOdDatuma());
			termin.put("doDatuma", n.getDoDatuma());
			termini.add(termin);
			
		}
		dto.setZauzetiTermini(termini);
		dto.setAdresa(new AdresaDTO(adrServ.findById(o.getAdresaId())));
		Automobil a=autoRep.getOne(o.getAutomobilId());
		dto.setAutomobil(autMapper.toDTO(a));
		dto.setCenovnik(new CenovnikDTO(cenRep.getOne(o.getCenovnikId())));
		return dto;
	}	
	public Oglas fromDTO(OglasDTO dto) {
		CommonData data=new CommonData();
		Oglas o=new Oglas();
		o.setUsername(dto.getUsername());
		o.setAutomobilId(dto.getAutomobilId());
		o.setId(dto.getId());
		o.setOdDatuma(dto.getOdDatuma());
		o.setDoDatuma(dto.getOdDatuma());
		o.setCenovnikId(dto.getCenovnikId());
		o.setUsername(dto.getUsername());
		cmdRep.save(data);
		cmdRep.flush();
		o.setCommonDataId(data.getId());
		return o;
	}
	
//	public Oglas fromNewDTO(OglasNewDTO dto,String username) {
//		CommonData data=new CommonData();
//		Oglas o=new Oglas();
//		o.setAutomobilId(dto.getAutomobilId());
//		o.setId(dto.getId());
//		o.setUsername(username);
//		//o.setOdDatuma(dto.getOdDatuma());
//		//o.setDoDatuma(dto.getOdDatuma());
//		o.setCenovnikId(dto.getCenovnikId());
//		cmdRep.save(data);
//		cmdRep.flush();
//		o.setCommonDataId(data.getId());
//		return o;
//	}
//	public OglasDetailsImgDTO toImgDTO(Oglas o, Automobil a, Cenovnik c, String username) throws Exception {
//		List<HashMap<String, Long>> zauzetiTermini = getZauzetiTermini(o.getId());
//		AdresaDTO adresa = new AdresaDTO(adrServ.findById(o.getAdresaId()));
//		 AutomobilImgDTO automobil=autMapper.toImgDTO(a);
//		 CenovnikDTO cenovnik=new CenovnikDTO(c);
//		 String korImeAgenta = o.getUsername();
//		 Long agentId = cmdServ.findOne(o.getCommonDataId()).getUserId();
//		OglasDetailsImgDTO dto=new OglasDetailsImgDTO(o, korImeAgenta, agentId, zauzetiTermini, adresa, automobil, cenovnik);
//		return dto;
//	}
	
	public List<HashMap<String, Long>> getZauzetiTermini(Long oglasId){
		List<Narudzbenica> narForOglas=narRep.findAll().stream().filter(x->x.getOglasId().equals(oglasId)).collect(Collectors.toList());
		List<HashMap<String, Long>> termini=new  ArrayList<HashMap<String, Long>>();
		for(Narudzbenica n : narForOglas) {
			HashMap<String,Long> termin=new HashMap<String, Long>();
			termin.put("odDatuma", n.getOdDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
			termin.put("doDatuma", n.getDoDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
			termini.add(termin);
		}
		return termini;
	}
	
	
}
	