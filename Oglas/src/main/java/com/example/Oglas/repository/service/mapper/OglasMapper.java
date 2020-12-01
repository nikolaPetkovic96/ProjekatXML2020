package com.example.Oglas.repository.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.TUserRepository;

@Component
public class OglasMapper {
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private TUserRepository userRep;
	
	public OglasDTO toDTO(Oglas o) {
		CommonData data=cmdRep.findById(o.getCommonDataId()).get();
		String username=userRep.findById(data.getUserid()).get().getKorisnickoIme();
		OglasDTO dto=new OglasDTO(	o.getId(),
									o.getOdDatuma(),
									o.getDoDatuma(),
									o.getCenovnikId(),
									o.getCommonDataId(),
									o.getAutomobilId(),username);		
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
}
	