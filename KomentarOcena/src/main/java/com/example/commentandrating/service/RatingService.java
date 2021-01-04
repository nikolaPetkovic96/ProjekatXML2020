package com.example.commentandrating.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Ocena;
import com.example.commentandrating.model.Rezervacija;
import com.example.commentandrating.repository.CommonDataRepository;
import com.example.commentandrating.repository.RatingRepository;
import com.example.commentandrating.repository.RezervacijaRepository;
import com.example.commentandrating.service.mapper.RatingMapper;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private RatingMapper ratingMapper;
	@Autowired
	private CommonDataRepository commonDataRepository;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired 
	private RezervacijaRepository rezRep;
	
 	public List<OcenaDTO> getRatings(Long carId, Long reservationId) {

		return ratingRepository.findAll().stream().filter(rating -> carId == null || rating.getAutomobilId() == carId)
				.filter(rating -> reservationId == null || reservationId == rating.getRezervacijaId())
				.map(rating -> ratingMapper.toDTO(rating)).collect(Collectors.toList());
	}

	public OcenaDTO getRating(Long id) {
		return ratingRepository.findById(id).map(ocena -> ratingMapper.toDTO(ocena)).orElse(null);
	}

	public OcenaDTO createRating(OcenaDTO kom) {
		// TODO provere: da li je realizovana, da li auto priprada toj rezervaciji, da
		// li je vec unet komentar
		//Rezervacija r=rezRep.findById(kom.getRezervacijaId()).orElse(null);
		if(isReservationRated(kom.getRezervacijaId())>0 ) {
			//vec postoji ocena
			return null;
		}
		
		Ocena k = ratingMapper.fromDto(kom);
		ratingRepository.saveAndFlush(k);
		return ratingMapper.toDTO(k);
	}

	public List<OcenaDTO> getAllRatings() {
		return ratingRepository.findAll().stream().map(r->ratingMapper.toDTO(r)).collect(Collectors.toList());
	}

	public OcenaDTO updateOcena(OcenaDTO dto) throws Exception {
		Ocena o=ratingRepository.findById(dto.getId()).orElse(null);
		if (o==null) {
			return null;			
		}
		CommonData cmd=commonDataRepository.findById(o.getCommonDataId()).orElse(null);
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd=cmdServ.updateCommonData(cmd.getId(),cmd);
		
		o.setId(dto.getId());
		o.setVrednostOcene(dto.getVrednostOcene());
		o.setCommonDataId(cmd.getId());
		o=ratingRepository.save(o);
		return ratingMapper.toDTO(o);
	}
	public int isReservationRated(Long rez_id) {	//da li je rezervacija vec ocenjena, i koliko puta
		List<Ocena> ocene=ratingRepository.findAll().stream().filter(x->x.getRezervacijaId().equals(rez_id)).collect(Collectors.toList());
		return ocene.size();
	}
}
