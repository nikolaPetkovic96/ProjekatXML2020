package com.example.Pretraga.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pretraga.dto.OglasDTO;
import com.example.Pretraga.model.Oglas;
import com.example.Pretraga.repository.OglasRepository;
import com.example.Pretraga.service.mapper.OglasMapper;
@Service
public class PretragaService {
	@Autowired
	private OglasRepository oglasRep;
	@Autowired 
	private OglasMapper oglasMapper;
	
	
	public List<OglasDTO> getOglase(LocalDateTime odDatum,
									LocalDateTime doDatum,
									int cenaKmMin, 
									int cenaKmMax ,
									Boolean collisiondamageWaiver, 
									int popustPreko30dana,
									float predjenaKm, 
									float planiranaKm,									
									int brojSedistaZaDecu,
									String mesto,
									String ulica,
									String nazivKlase,
									String nazivMarke, 
									String nazivModela,
									String nazivGoriva,
									String nazivMenjaca){
		List<Oglas> svi=oglasRep.findAll().stream().collect(Collectors.toList());
		List<OglasDTO> sviDTO= new ArrayList<>();
		svi.forEach((o)->sviDTO.add(oglasMapper.toDTO(o)));	//kreiraj sve oglaseDTO, zatim cemo nad tim izvrsiti filtriranje
		
		if(!odDatum.equals(null) && !doDatum.equals(null))
			// ako su uneseni pocetni i krajnji datum proveri da li je oglas slobodan pre ili tacno od pocetnog dana i da li je slobodan do ili posle krajnjeg dana
			sviDTO.stream().filter(o->(o.getOdDatuma().isBefore(odDatum) ||o.getOdDatuma().isEqual(odDatum)) && (o.getDoDatuma().isAfter(doDatum) ||o.getDoDatuma().isEqual(doDatum))).collect(Collectors.toList());
		if(cenaKmMin>-1)	// ako je -1 ne vrsi se poredjnje 
			//sviDTO.stream().filter().collect(Collectors.toList());
			sviDTO.stream().filter(o->o.getCenaPoKilometru()>=cenaKmMin).collect(Collectors.toList());
		if(cenaKmMax>-1 )	//
			sviDTO.stream().filter(o->o.getCenaPoKilometru()<=cenaKmMax).collect(Collectors.toList());
		if(!collisiondamageWaiver.equals(null))	//da li je unesena specificna vrednost za collision waiver?
			sviDTO.stream().filter(o->o.isCollisionDamageWaiver()==collisiondamageWaiver).collect(Collectors.toList());
		if(predjenaKm>-1)
			sviDTO.stream().filter(o->o.getPredjenaKilometraza()<=predjenaKm).collect(Collectors.toList());
		if(planiranaKm>-1)		//za getPlaniranaKm jednako manje od 0 znaci da je getplaniranKm unlimited
			sviDTO.stream().filter(o->o.getPlaniranaKilometraza()<=planiranaKm ||o.getPlaniranaKilometraza()<0 ).collect(Collectors.toList());
		if(brojSedistaZaDecu>-1)
			sviDTO.stream().filter(o->o.getBrojSedistaZaDecu()>=brojSedistaZaDecu).collect(Collectors.toList());
		if(!mesto.equals(null)) {
			sviDTO.stream().filter(o->o.getMesto().equals(mesto)).collect(Collectors.toList());
			if(!ulica.equals(null)) {
				sviDTO.stream().filter(o->o.getUlica().equals(ulica)).collect(Collectors.toList());
			}
		}
		if(!nazivKlase.equals(null))
			sviDTO.stream().filter(o->o.getNazivKlase().equals(nazivKlase)).collect(Collectors.toList());
		if(!nazivMarke.equals(null))
			sviDTO.stream().filter(o->o.getNazivMarke().equals(nazivMarke)).collect(Collectors.toList());
		if(!nazivModela.equals(null))
			sviDTO.stream().filter(o->o.getNazivModela().equals(nazivModela)).collect(Collectors.toList());
		if(!nazivGoriva.equals(null))
			sviDTO.stream().filter(o->o.getNazivTipaGoriva().equals(nazivGoriva)).collect(Collectors.toList());
		if(!nazivMenjaca.equals(null))
			sviDTO.stream().filter(o->o.getNazivMenjaca().equals(nazivMenjaca)).collect(Collectors.toList());
		
		return sviDTO;		
		
	}
}
