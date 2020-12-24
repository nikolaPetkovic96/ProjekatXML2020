package com.example.commentandrating.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Ocena;
import com.example.commentandrating.repository.CommonDataRepository;
import com.example.commentandrating.repository.TUserRepository;

@Component
public class RatingMapper {
	@Autowired
	private CommonDataRepository commonDataRepository;

	@Autowired
	private TUserRepository tUserRepository;

	public OcenaDTO toDTO(Ocena o) {
		CommonData data = commonDataRepository.findById(o.getCommonDataId()).get();
		String username = tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		OcenaDTO kom = new OcenaDTO(o.getId(), o.getVrednostOcene(), o.getAutomobilId(), o.getRezervacijaId(), username,
				data.getDatumKreiranja(), data.getDatumIzmene());
		return kom;

	}

	public Ocena fromDto(OcenaDTO k) {
		CommonData data = new CommonData();
		// data.setUserId(userId); //TODO izvuci iz security kntexta
		// String username =
		// tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		Ocena kom = new Ocena();
		kom.setAutomobilId(k.getAutomobilId());
		kom.setRezervacijaId(k.getRezervacijaId());
		kom.setVrednostOcene(k.getVrednostOcene());
		commonDataRepository.save(data);
		commonDataRepository.flush();
		kom.setCommonDataId(data.getId());
		return kom;
	}
}
