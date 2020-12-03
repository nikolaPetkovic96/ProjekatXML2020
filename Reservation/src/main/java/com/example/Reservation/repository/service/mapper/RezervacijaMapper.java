package com.example.Reservation.repository.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.TUserRepository;
@Component
public class RezervacijaMapper {

	@Autowired
	private CommonDataRepository commonDataRepository;

	@Autowired
	private TUserRepository tUserRepository;
	@Autowired
	private NarudzbenicaRepository narRepository;
	@Autowired
	private OglasRepository oglasRep;
	public RezervacijaDTO toDTO(Rezervacija r) {
		
		CommonData data = commonDataRepository.findById(r.getCommonDataId()).get();
		String username = tUserRepository.findById(data.getUserid()).get().getKorisnickoIme();
		List<Long> automobili_id=new ArrayList<>();
		List<Long> oglasi_id=new ArrayList<>();
		for(Narudzbenica n:r.getNarudbenice()) {
			oglasi_id.add(n.getId());
			automobili_id.add(oglasRep.findById(n.getOglasId()).get().getAutomobilId());			
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
		List<Narudzbenica> narudzbenice=new ArrayList<>();
		for(Long id: rezDTO.getNarudzbenice_id()) {
			narudzbenice.add(narRepository.findById(id).get());
		}
		r.setNarudbenice(narudzbenice);
		CommonData data=new CommonData();
		commonDataRepository.save(data);
		commonDataRepository.flush();
		r.setCommonDataId(data.getId());
		return r;
	}
}
