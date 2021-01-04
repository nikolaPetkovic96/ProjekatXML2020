package com.example.Oglas.repository.service.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.dto.OglasNewDTO;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.Narudzbenica;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.repository.AutomobilRepository;
import com.example.Oglas.repository.CenovnikRepository;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.NarudzbenicaRepository;
import com.example.Oglas.repository.TAdresaRepository;
import com.example.Oglas.repository.TUserRepository;

@Component
public class OglasMapper {
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private TUserRepository userRep;
	@Autowired 
	private TAdresaRepository adresaRep;
	@Autowired
	private CenovnikRepository cenRep;
	@Autowired 
	private AutomobilRepository autoRep;
	@Autowired
	private NarudzbenicaRepository narRep;
	
	public OglasDTO toDTO(Oglas o) {
		CommonData data=cmdRep.findById(o.getCommonDataId()).get();
		String username=userRep.findById(data.getUserid()).get().getKorisnickoIme();
		OglasDTO dto=new OglasDTO(	o.getId(),
									o.getOdDatuma(),
									o.getDoDatuma(),
									o.getCenovnikId(),
									o.getCommonDataId(),
									o.getAutomobilId(),username,
									o.getAdresaId());
		List<Narudzbenica> narForOglas=narRep.findAll().stream().filter(x->x.getOglasId().equals(dto.getId())).collect(Collectors.toList());
		
		
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
		cmdRep.save(data);
		cmdRep.flush();
		o.setCommonDataId(data.getId());
		return o;
	}
	
	public Oglas fromNewDTO(OglasNewDTO dto) {
		CommonData data=new CommonData();
		Oglas o=new Oglas();
		o.setAutomobilId(dto.getAutomobilId());
		o.setId(dto.getId());
		//o.setOdDatuma(dto.getOdDatuma());
		//o.setDoDatuma(dto.getOdDatuma());
		o.setCenovnikId(dto.getCenovnikId());
		cmdRep.save(data);
		cmdRep.flush();
		o.setCommonDataId(data.getId());
		return o;
	}
	
}
	