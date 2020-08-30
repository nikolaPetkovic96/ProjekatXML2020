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
									int cenaDanMin, 
									int cenaDanMax ,
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
			for(Oglas o: svi)
				sviDTO.add(oglasMapper.toDTO(o));
		//svi.forEach((o)->sviDTO.add(oglasMapper.toDTO(o)));	//kreiraj sve oglaseDTO, zatim cemo nad tim izvrsiti filtriranje
		
		//if(odDatum != null && doDatum !=null)
		//if(!odDatum.equals(doDatum))
			// ako su uneseni pocetni i krajnji datum proveri da li je oglas slobodan pre ili tacno od pocetnog dana i da li je slobodan do ili posle krajnjeg dana
			//sviDTO=sviDTO.stream().filter(o->(o.getOdDatuma().isBefore(odDatum) ||o.getOdDatuma().isEqual(odDatum)) && (o.getDoDatuma().isAfter(doDatum) ||o.getDoDatuma().isEqual(doDatum))).collect(Collectors.toList());
			//sviDTO=sviDTO.stream().filter(o->odDatum.isBefore(o.getOdDatuma())||odDatum.equals(o.getOdDatuma())).collect(Collectors.toList());
			//sviDTO=sviDTO.stream().filter(o->doDatum.isAfter(o.getDoDatuma())||odDatum.equals(o.getDoDatuma())).collect(Collectors.toList());

		if(cenaKmMin>-1)	// ako je -1 ne vrsi se poredjnje 
			//sviDTO.stream().filter().collect(Collectors.toList());
			sviDTO=sviDTO.stream().filter(o->o.getCenaPoKilometru()>=cenaKmMin).collect(Collectors.toList());
		if(cenaKmMax>-1 )	//
			sviDTO=sviDTO.stream().filter(o->o.getCenaPoKilometru()<=cenaKmMax).collect(Collectors.toList());
		if(cenaDanMin>-1)	// ako je -1 ne vrsi se poredjnje 
			//sviDTO.stream().filter().collect(Collectors.toList());
			sviDTO=sviDTO.stream().filter(o->o.getCenaPoDanu()>=cenaDanMin).collect(Collectors.toList());
		if(cenaDanMax>-1 )	//
			sviDTO=sviDTO.stream().filter(o->o.getCenaPoDanu()<=cenaDanMax).collect(Collectors.toList());
		if(collisiondamageWaiver!=null)	//da li je unesena specificna vrednost za collision waiver?
			sviDTO=sviDTO.stream().filter(o->o.isCollisionDamageWaiver()==collisiondamageWaiver).collect(Collectors.toList());
		if(predjenaKm>-1)
			sviDTO=sviDTO.stream().filter(o->o.getPredjenaKilometraza()<=predjenaKm).collect(Collectors.toList());
		if(planiranaKm>-1)		//za getPlaniranaKm jednako manje od 0 znaci da je getplaniranKm unlimited
			sviDTO=sviDTO.stream().filter(o->o.getPlaniranaKilometraza()>=planiranaKm ||o.getPlaniranaKilometraza()<0 ).collect(Collectors.toList());
		if(brojSedistaZaDecu>-1)
			sviDTO=sviDTO.stream().filter(o->o.getBrojSedistaZaDecu()>=brojSedistaZaDecu).collect(Collectors.toList());
		if(mesto!=null) {
			sviDTO=sviDTO.stream().filter(o->o.getMesto().toLowerCase().equals(mesto.toLowerCase())).collect(Collectors.toList());
			if(ulica!=null) {
				sviDTO=sviDTO.stream().filter(o->o.getUlica().toLowerCase().equals(ulica.toLowerCase())).collect(Collectors.toList());
			}
		}
		if(nazivKlase!=null)
			sviDTO=sviDTO.stream().filter(o->o.getNazivKlase().toLowerCase().equals(nazivKlase.toLowerCase())).collect(Collectors.toList());
		if(nazivMarke!=null)
			sviDTO=sviDTO.stream().filter(o->o.getNazivMarke().toLowerCase().equals(nazivMarke.toLowerCase())).collect(Collectors.toList());
		if(nazivModela!=null)
			sviDTO=sviDTO.stream().filter(o->o.getNazivModela().toLowerCase().equals(nazivModela.toLowerCase())).collect(Collectors.toList());
		if(nazivGoriva!=null)
			sviDTO=sviDTO.stream().filter(o->o.getNazivTipaGoriva().toLowerCase().equals(nazivGoriva.toLowerCase())).collect(Collectors.toList());
		if(nazivMenjaca!=null)
			sviDTO=sviDTO.stream().filter(o->o.getNazivMenjaca().toLowerCase().equals(nazivMenjaca.toLowerCase())).collect(Collectors.toList());
		return sviDTO;		
		
	}
	public List<OglasDTO> getAllOglas(){
		List<Oglas> svi=oglasRep.findAll().stream().collect(Collectors.toList());
		System.out.println("UKUPNO:  "+svi.size());
		List<OglasDTO> sviDTO= new ArrayList<>();
		svi.forEach((o)->sviDTO.add(oglasMapper.toDTO(o)));
		return sviDTO;		

	}

}
