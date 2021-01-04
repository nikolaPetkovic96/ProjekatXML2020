package com.example.Reservation.repository.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.dto.NarudzbenicaNewDTO;
import com.example.Reservation.model.Izvestaj;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.repository.IzvestajRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;

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
												n.getCommonDataId());
		return dto;
	}
	
}
}
