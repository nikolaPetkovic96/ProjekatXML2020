package com.example.Messages2.service.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Messages2.dto.CommonDataDTO;
import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.CommonData;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.CommonDataRepository;

@Component
public class PorukaMapper {

	@Autowired
	private CommonDataRepository commonDataRepository;
	
	public PorukaDTO toDTO(Poruka p) {
		CommonData comData = commonDataRepository.findById(p.getCommonDataId()).get();
		PorukaDTO pDTO = new PorukaDTO(p, new CommonDataDTO(comData));
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
		p.setUsername(dto.getUsername());
		return p;
	}
}
