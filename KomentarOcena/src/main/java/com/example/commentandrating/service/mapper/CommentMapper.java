package com.example.commentandrating.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commentandrating.dto.KomentarDTO;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Komentar;
import com.example.commentandrating.repository.CommonDataRepository;
import com.example.commentandrating.repository.TUserRepository;

@Component
public class CommentMapper {
	@Autowired
	private CommonDataRepository commonDataRepository;

	@Autowired
	private TUserRepository tUserRepository;

	public KomentarDTO toDTO(Komentar k) {
		CommonData data = commonDataRepository.findById(k.getCommonDataId()).get();
		String username = tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		KomentarDTO kom = new KomentarDTO(k.getId(), k.getTekstKomentara(), username, k.isOdobren(), k.getAutomobilId(),
				k.getRezervacijaId(), data.getDatumKreiranja(), data.getDatumIzmene());
		return kom;

	}

	public Komentar fromDto(KomentarDTO k) {
		CommonData data = new CommonData();
		// data.setUserId(userId); //TODO izvuci iz security kntexta
		// String username =
		// tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		Komentar kom = new Komentar();
		kom.setAutomobilId(k.getAutomobilId());
		kom.setOdobren(false);
		kom.setRezervacijaId(k.getRezervacijaId());
		kom.setTekstKomentara(k.getTekstKomentara());
		commonDataRepository.save(data);
		commonDataRepository.flush();
		kom.setCommonDataId(data.getId());
		return kom;
	}
}