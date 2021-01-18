package com.example.commentandrating.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commentandrating.dto.KomentarDTO;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Komentar;
import com.example.commentandrating.repository.CommonDataRepository;


@Component
public class CommentMapper {
	@Autowired
	private CommonDataRepository commonDataRepository;

	public KomentarDTO toDTO(Komentar k) {
		CommonData data = commonDataRepository.findById(k.getCommonDataId()).get();
		KomentarDTO kom = new KomentarDTO(k.getId(), k.getTekstKomentara(), k.getAutor(), k.isOdobren(), k.getAutomobilId(),
				k.getRezervacijaId(), data.getDatumKreiranja(), data.getDatumIzmene(), data.getUserid());
		return kom;

	}

	public Komentar fromDto(KomentarDTO k) {
		CommonData data = new CommonData();
		
		Komentar kom = new Komentar();
		kom.setAutomobilId(k.getAutomobilId());
		kom.setOdobren(false);
		
		kom.setRezervacijaId(k.getRezervacijaId());
		kom.setTekstKomentara(k.getTekstKomentara());
		commonDataRepository.save(data);
		commonDataRepository.flush();
		kom.setCommonDataId(data.getId());
//		kom.setAutor(k.getAutor());
		return kom;
	}
}
