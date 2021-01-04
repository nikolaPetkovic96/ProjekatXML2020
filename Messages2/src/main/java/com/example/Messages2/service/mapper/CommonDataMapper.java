package com.example.Messages2.service.mapper;

import org.springframework.stereotype.Component;

import com.example.Messages2.dto.CommonDataDTO;
import com.example.Messages2.model.CommonData;
@Component
public class CommonDataMapper {

	public CommonDataMapper() {
		
	}
	
	public CommonDataDTO toDTO(CommonData cmd) {
		return new CommonDataDTO(cmd);
	}
	public CommonData fromDTO(CommonDataDTO dto) {
		CommonData cmd=new CommonData();
		cmd.setId(dto.getId());
		cmd.setUserId(dto.getUserId());
		cmd.setDatumIzmene(dto.getDatumIzmene());
		cmd.setDatumKreiranja(dto.getDatumKreiranja());
		return cmd;
	}

}
