package com.example.Reservation.repository.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.TUserRepository;

public class RezervacijaMapper {

	@Autowired
	private CommonDataRepository commonDataRepository;

	@Autowired
	private TUserRepository tUserRepository;
	@Autowired
	private OglasRepository oglasRepository;
	public RezervacijaDTO toDTO(Rezervacija r) {
		
		CommonData data = commonDataRepository.findById(r.getCommonDataId()).get();
		String username = tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		List<Long> automobili_id=new ArrayList<>();
		List<Long> oglasi_id=new ArrayList<>();
		for(Oglas o:r.getOglasi()) {
			oglasi_id.add(o.getId());
			automobili_id.add(o.getAutomobilId());
			
		}
		
		return new RezervacijaDTO(r.getId(), r.getUkupnaCena(), r.getOdDatuma(),r.getDoDatuma(), r.getBundle(), r.getCommonDataId(), r.getStatusRezervacije(), 
				username, oglasi_id, automobili_id,
				data.getDatumKreiranja(),data.getDatumIzmene());
	}

	public Rezervacija fromDTO(RezervacijaDTO rezDTO) {
		// TODO Auto-generated method stub
		Rezervacija r=new Rezervacija();
		r.setBundle(rezDTO.getBundle());
		r.setUkupnaCena(rezDTO.getUkupnaCena());
		r.setOdDatuma(rezDTO.getOdDatuma());
		r.setDoDatuma(rezDTO.getDoDatuma());
		r.setStatusRezervacije(rezDTO.getStatusRezervacije());
		List<Oglas> oglasi=new ArrayList<>();
		for(Long id: rezDTO.getOglasi_id()) {
			oglasi.add(oglasRepository.findById(id).get());
		}
		r.setOglasi(oglasi);
		CommonData data=new CommonData();
		commonDataRepository.save(data);
		commonDataRepository.flush();
		r.setCommonDataId(data.getId());
		return r;
	}
}
