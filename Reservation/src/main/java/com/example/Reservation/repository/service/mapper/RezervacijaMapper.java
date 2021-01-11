package com.example.Reservation.repository.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.dto.PorukaDTO;
import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.dto.RezervacijaFullDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.PorukaRepository;
import com.example.Reservation.repository.service.NarudzbenicaService;
@Component
public class RezervacijaMapper {

	@Autowired
	private CommonDataRepository commonDataRepository;
	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired 
	public NarudzbenicaService narServ;
	@Autowired
	private PorukaRepository porRep;
	@Autowired
	private PorukaMapper porMap;
	
	public RezervacijaDTO toDTO(Rezervacija r, String username) {
		
		CommonData data = commonDataRepository.findById(r.getCommonDataId()).get();
		//String username = null;//tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		//List<Narudzbenica> narudzbenice=(List<Narudzbenica>) narRep.findByRezervacijaId(r.getId());
		//List<Long> narudzbenice_id=Collections.emptyList();
		//for(Narudzbenica n: narudzbenice) {
		//	narudzbenice_id.add(n.getId());
		//}
		
		return new RezervacijaDTO(r, username, data.getUserId());
	}

	public Rezervacija fromDTO(RezervacijaDTO rezDTO) { //nece raditi, dto nema napomenu
		// TODO Auto-generated method stub
		Rezervacija r=new Rezervacija();
		r.setBundle(rezDTO.getBundle());
		r.setUkupnaCena(rezDTO.getUkupnaCena());
		r.setStatusRezervacije(rezDTO.getStatusRezervacije());
		//r.setNapomena(rezDTO.get);
		CommonData data=new CommonData();
		commonDataRepository.save(data);
		commonDataRepository.flush();
		r.setCommonDataId(data.getId());
		return r;
	}
//	
//	public RezervacijaDTO toDTO(Rezervacija r) {
//		
//		CommonData data = commonDataRepository.findById(r.getCommonDataId()).get();
//		String username = tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
//		List<Long> automobili_id=new ArrayList<>();
//		List<Long> oglasi_id=new ArrayList<>();
//		for(Oglas o:r.getOglasi()) {
//			oglasi_id.add(o.getId());
//			automobili_id.add(o.getAutomobilId());
//			
//		}
//		
//		return new RezervacijaDTO(r.getId(), r.getUkupnaCena(), r.getOdDatuma(),r.getDoDatuma(), r.getBundle(), r.getCommonDataId(), r.getStatusRezervacije(), 
//				username, oglasi_id, automobili_id,
//				data.getDatumKreiranja(),data.getDatumIzmene());
//	}
//
//	public Rezervacija fromDTO(RezervacijaDTO rezDTO) {
//		// TODO Auto-generated method stub
//		Rezervacija r=new Rezervacija();
//		r.setBundle(rezDTO.getBundle());
//		r.setUkupnaCena(rezDTO.getUkupnaCena());
//		r.setOdDatuma(rezDTO.getOdDatuma());
//		r.setDoDatuma(rezDTO.getDoDatuma());
//		r.setStatusRezervacije(rezDTO.getStatusRezervacije());
//		List<Oglas> oglasi=new ArrayList<>();
//		for(Long id: rezDTO.getOglasi_id()) {
//			oglasi.add(oglasRepository.findById(id).get());
//		}
//		r.setOglasi(oglasi);
//		CommonData data=new CommonData();
//		commonDataRepository.save(data);
//		commonDataRepository.flush();
//		r.setCommonDataId(data.getId());
//		return r;
//	}


	public RezervacijaFullDTO toDTOFull(Rezervacija r) {
		CommonData data = commonDataRepository.findById(r.getCommonDataId()).get();
		String username = r.getUsername();
		List<NarudzbenicaDTO> narudzbenice=narServ.getAllByRez(r.getId());
		List<PorukaDTO> poruke=porRep.findAll().stream()
														.filter(x->x.getRezervacijaId().equals(r.getId()))
														//.sorted((x1,x2)->x1.getCommonDataId().compareTo(x2.getCommonDataId())) //sortiranje poruka, gleda samo vrednost idjeva
														.map(x->porMap.toDTO(x))
														.sorted((x1,x2)->x1.getCmdDTO().getDatumKreiranja().compareTo(x2.getCmdDTO().getDatumKreiranja()))
														.collect(Collectors.toList());
		RezervacijaFullDTO fullDTO=new RezervacijaFullDTO(r, username, narudzbenice, poruke);
		return fullDTO;
	}
}
