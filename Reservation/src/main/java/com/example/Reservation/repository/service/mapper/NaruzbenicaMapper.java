package com.example.Reservation.repository.service.mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.model.Izvestaj;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.repository.IzvestajRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.service.OglasService;

@Component
public class NaruzbenicaMapper {

	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired
	private IzvestajRepository izvRep;
	@Autowired
	private OglasService oglServ;
	
	public NarudzbenicaDTO toDTO(Narudzbenica n) {
		List<Izvestaj> all=izvRep.findAll().stream().collect(Collectors.toList());
		Long izvestajId=null;
		for(Izvestaj i : all) {
			if (i.getNarudzbenicaId()==n.getId()) {
				izvestajId=i.getId();
				break;
			}
		}
		
		NarudzbenicaDTO dto=new NarudzbenicaDTO(n.getId(),
												n.getAgentId(),
												n.getUserId(), 
												n.getOglasId(), 
												n.getRezervacijaId(), 
												n.getOdDatuma(), 
												n.getDoDatuma(), 
												izvestajId,
												n.getCommonDataId(), oglServ.getOglas(n.getOglasId()));
		return dto;
	}
	

}
