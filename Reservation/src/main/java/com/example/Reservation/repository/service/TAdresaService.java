package com.example.Reservation.repository.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reservation.dto.AdresaDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.TAdresa;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.TAdresaRepository;
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
