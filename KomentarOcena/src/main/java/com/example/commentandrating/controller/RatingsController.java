package com.example.commentandrating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.service.RatingService;

@RestController
@RequestMapping(value = "/rating")
public class RatingsController {
	@Autowired
	private RatingService ratingService;

	@GetMapping(value = "")
	public List<OcenaDTO> getRatings(@RequestParam(name = "car", required = false) Long carId,
			@RequestParam(required = false, name = "reservation") Long reservationId) {
		return ratingService.getRatings(carId, reservationId);
	}

	@GetMapping(value = "/{id}")
	public OcenaDTO getCommentById(@PathVariable("id") Long id) {
		return ratingService.getRating(id);
	}

	@PostMapping(value = "")
	public OcenaDTO addComment(@RequestBody OcenaDTO kom) {
		return ratingService.createRating(kom);
	}

}
