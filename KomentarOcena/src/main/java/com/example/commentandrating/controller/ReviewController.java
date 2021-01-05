package com.example.commentandrating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentandrating.dto.ReviewDTO;
import com.example.commentandrating.service.ReviewService;

@RestController
@RequestMapping(value = "review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@GetMapping(value = "/{id}")
	public List<ReviewDTO> getRatings(@PathVariable("id") Long carId) {
		return reviewService.getReviews(carId);
	}
}
