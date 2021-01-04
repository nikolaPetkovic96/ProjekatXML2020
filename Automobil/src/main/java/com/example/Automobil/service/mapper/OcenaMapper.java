package com.example.Automobil.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Automobil.dto.RecenzijaDTO;
import com.example.Automobil.model.Ocena;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.OcenaRepository;
import com.example.Automobil.repository.TUserRepository;

public class OcenaMapper {

	@Autowired
	private OcenaRepository ocenaRep;
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private TUserRepository userRep;
	
	public List<RecenzijaDTO> toListDTO(Long auto_id) {//vraca sve ocene za id kola
		//List<Ocena> ocene=ocenaRep.findByAutoId(auto_id).stream().collect(Collectors.toList());
		List<RecenzijaDTO> ocene=ocenaRep.findAll().stream().filter(x->x.getAutomobilId().equals(auto_id)).map(x->toDTO(x)).collect(Collectors.toList());
		return ocene;		
	}
	
	public RecenzijaDTO toDTO(Ocena o) {
		Long user_id=cmdRep.findById(o.getCommonDataId()).get().getUserid();
		String username=userRep.findById(user_id).get().getKorisnickoIme();
		return new RecenzijaDTO(o.getId(), username, o.getTekst(), o.getVrednostOcene(), o.getOdobren());
		}

}
