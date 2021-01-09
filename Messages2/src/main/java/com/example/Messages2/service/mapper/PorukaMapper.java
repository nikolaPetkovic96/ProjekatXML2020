package com.example.Messages2.service.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.CommonData;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.CommonDataRepository;
import com.example.Messages2.repository.TUserRepository;

public class PorukaMapper {

	@Autowired
	private CommonDataRepository commonDataRepository;

	@Autowired
	private TUserRepository tUserRepository;
	
	public PorukaDTO toDTO(Poruka p) {
		CommonData data = commonDataRepository.findById(p.getCommonDataId()).get();
		String username = tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		
		PorukaDTO pDTO=new PorukaDTO(p.getId(), p.getTekstPoruke(), p.getRezervacijaId(), data.getId(), p.getAutomobilId(), username);
		return pDTO;		
	}
	
	public Poruka fromDTO(PorukaDTO dto) {
		CommonData data = dto.getCommonDataId()!=null ? commonDataRepository.findById(dto.getCommonDataId()).get():new CommonData();
		Poruka p=new Poruka();
		p.setRezervacijaId(dto.getRezervacijaId());
		p.setTekstPoruke(dto.getTekstPoruke());
		data.setDatumIzmene(LocalDateTime.now());
		commonDataRepository.save(data);
		commonDataRepository.flush();
		p.setCommonDataId(data.getId());
		return p;
	}
}
