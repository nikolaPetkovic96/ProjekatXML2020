package com.example.Oglas.repository.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.dto.NarudzbenicaDTO;
import com.example.Oglas.model.Izvestaj;
import com.example.Oglas.model.Narudzbenica;
import com.example.Oglas.repository.IzvestajRepository;
import com.example.Oglas.repository.NarudzbenicaRepository;

@Component
public class NaruzbenicaMapper {

	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired
	private IzvestajRepository izvRep;
	
	public NarudzbenicaDTO toDTO(Narudzbenica n) {
		List<Izvestaj> all=izvRep.findAll().stream().filter(x->x.getNarudzbenicaId().equals(n.getId())).collect(Collectors.toList());
		Long izvestajId=all.get(0).getId();
		NarudzbenicaDTO dto=new NarudzbenicaDTO(n.getId(),
												n.getAgentId(),
												n.getUserId(), 
												n.getOglasId(), 
												n.getRezervacijaId(), 
												n.getOdDatuma(), 
												n.getDoDatuma(), 
												izvestajId,
												n.getCommonDataId(), null);
		return dto;
	}
	

}
