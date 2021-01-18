package com.example.commentandrating.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.model.Automobil;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Komentar;
import com.example.commentandrating.model.Ocena;
import com.example.commentandrating.repository.AutomobilRepository;
import com.example.commentandrating.repository.CommonDataRepository;
import com.example.commentandrating.repository.RatingRepository;
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
	private AutomobilRepository autoRepository;

	public List<OcenaDTO> getRatings(Long carId, Long reservationId) {

		return ratingRepository.findAll().stream().filter(rating -> carId == null || rating.getAutomobilId() == carId)
				.filter(rating -> reservationId == null || reservationId == rating.getRezervacijaId())
				.map(rating -> ratingMapper.toDTO(rating)).collect(Collectors.toList());
	}

	public OcenaDTO getRating(Long id) {
		return ratingRepository.findById(id).map(ocena -> ratingMapper.toDTO(ocena)).orElse(null);
	}

	public ResponseEntity<?> createRating(OcenaDTO ocena) {
		// TODO provere: da li je realizovana, da li auto priprada toj rezervaciji, da
		List<Ocena> ocene = ratingRepository.findAll();
		for(Ocena o : ocene) {
			if(ocena.getAutomobilId() == o.getAutomobilId() && ocena.getRezervacijaId() == o.getRezervacijaId()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Vec postoji ocena!");
			}
		}
	
		
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId=Long.parseLong(request.getHeader("userid"));
		
		Ocena o = ratingMapper.fromDto(ocena);
		
		CommonData cd=new CommonData();
		cd.setUserId(userId);
		cd.setDatumKreiranja(LocalDateTime.now());
		commonDataRepository.saveAndFlush(cd);
		
		updateAutomobilMark(o);
		
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		o.setAutor(name);
		o.setCommonDataId(cd.getId());
		ratingRepository.saveAndFlush(o);
	
		return new ResponseEntity<>(ratingMapper.toDTO(o), HttpStatus.CREATED);
	}
	
	public void updateAutomobilMark(Ocena o){
		//Promena ocene
		Automobil a = findOne(o.getAutomobilId());
		List<Ocena> ocene = ratingRepository.findAllByAutomobilId(a.getId());
		int brojOcena = ratingRepository.findAllByAutomobilId(a.getId()).size();
		float staraUkOcena = 0;
		
		for(Ocena ocena : ocene) {
			staraUkOcena += ocena.getVrednostOcene();
		}
		float novaUkOcena = (staraUkOcena + o.getVrednostOcene())/(brojOcena + 1);
		
		a.setUkupnaOcena(novaUkOcena);
		autoRepository.save(a);
	}
	
	public Automobil findOne(Long id) {
		return autoRepository.findById(id).orElse(null);
	}
}
