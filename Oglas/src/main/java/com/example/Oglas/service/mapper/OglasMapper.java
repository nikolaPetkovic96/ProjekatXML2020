package com.example.Oglas.service.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.dto.AdresaDTO;
import com.example.Oglas.dto.CenovnikDTO;
import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.dto.OglasNewDTO;
import com.example.Oglas.model.Automobil;
//import com.example.Oglas.model.Automobil;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.Narudzbenica;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.repository.AutomobilRepository;
//import com.example.Oglas.repository.AutomobilRepository;
import com.example.Oglas.repository.CenovnikRepository;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.NarudzbenicaRepository;
import com.example.Oglas.repository.TAdresaRepository;
import com.example.Oglas.service.TAdresaService;

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
		System.out.println(narForOglas.size());
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
	
	public Oglas fromNewDTO(OglasNewDTO dto,String username) {
		CommonData data=new CommonData();
		Oglas o=new Oglas();
		o.setAutomobilId(dto.getAutomobilId());
		o.setId(dto.getId());
		o.setUsername(username);
		//o.setOdDatuma(dto.getOdDatuma());
		//o.setDoDatuma(dto.getOdDatuma());
		o.setCenovnikId(dto.getCenovnikId());
		cmdRep.save(data);
		cmdRep.flush();
		o.setCommonDataId(data.getId());
		return o;
	}
}
	