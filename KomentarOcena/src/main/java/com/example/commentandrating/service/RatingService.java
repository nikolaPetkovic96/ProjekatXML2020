package com.example.commentandrating.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.model.Ocena;
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
		Ocena k = ratingMapper.fromDto(kom);
		ratingRepository.saveAndFlush(k);
		return ratingMapper.toDTO(k);
	}

}
