package com.example.Baza.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Baza.dto.TAdresaDTO;
import com.example.Baza.model.TAdresa;
import com.example.Baza.repository.TAdresaRepository;

@Component
public class TAdresaMapper {

	@Autowired
	private TAdresaRepository adresaRep;
	
	public TAdresaDTO toDTO(TAdresa a) {
		String mesto=a.getMesto();
		String ulica=a.getUlica();
		String postanskiBroj=String.valueOf(a.getPostanskiBroj());
		String broj="";
		if(a.getBroj()==0 || a.getBroj()==1)
			broj="bb";
		else 
			broj=String.valueOf(a.getBroj());
		
		return  new TAdresaDTO(mesto,ulica,broj,postanskiBroj);
	}
	
}
