package com.example.Oglas.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Oglas.dto.AdresaDTO;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.TAdresa;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.TAdresaRepository;
@Service
public class TAdresaService {

	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private TAdresaRepository adrRep;
	
	public TAdresa addAdresa(AdresaDTO adresa, Long id) throws Exception {
		TAdresa nova= new TAdresa();
		nova.setBroj(adresa.getBroj());
		nova.setMesto(adresa.getMesto());
		nova.setPostanskiBroj(adresa.getPostanskiBroj());
		nova.setUlica(adresa.getUlica());
		
		adrRep.save(nova);
		
		//Sacekati sa brisanjem u slucaju da treba za soap
//		CommonData cmd=new CommonData();
//		cmd.setDatumKreiranja(LocalDateTime.now());
//		cmd.setDatumIzmene(LocalDateTime.now());
//		cmd.setUserId(id);
//		
//		cmd=cmdServ.addCommonData(cmd);
//		nova.setCommonDataId(cmd.getId());
		return nova;
	}
	
	
	
	
	
	
	public TAdresa findById(Long adresaId) {
		return adrRep.findById(adresaId).orElse(null);

	}
	public void deleteAdresa(Long id) {
		adrRep.deleteById(id);
	}

	

}
