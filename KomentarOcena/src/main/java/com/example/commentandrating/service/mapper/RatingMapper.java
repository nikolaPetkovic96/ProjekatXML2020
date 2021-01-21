package com.example.commentandrating.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Ocena;
import com.example.commentandrating.repository.CommonDataRepository;

@Component
public class RatingMapper {
	@Autowired
	private CommonDataRepository commonDataRepository;

	public OcenaDTO toDTO(Ocena o) {
		CommonData data = commonDataRepository.findById(o.getCommonDataId()).get();
		OcenaDTO kom = new OcenaDTO(o.getId(), o.getVrednostOcene(), o.getAutomobilId(), o.getRezervacijaId(), o.getAutor(),
				data.getDatumKreiranja(), data.getDatumIzmene());
		return kom;

	}

	public Ocena fromDto(OcenaDTO k) {
		CommonData data = new CommonData();
		Ocena kom = new Ocena();
		kom.setAutomobilId(k.getAutomobilId());
		kom.setRezervacijaId(k.getRezervacijaId());
		kom.setVrednostOcene(k.getVrednostOcene());
		commonDataRepository.save(data);
		commonDataRepository.flush();
		kom.setCommonDataId(data.getId());
//		kom.setAutor(k.getUsername());
		return kom;
	}
}