package com.example.commentandrating.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentandrating.dto.KomentarDTO;
import com.example.commentandrating.dto.OcenaDTO;
import com.example.commentandrating.dto.ReviewDTO;

@Service
public class ReviewSercice {
	@Autowired
	private RatingService ratingService;
	@Autowired
	private CommentService commentService;

	public List<ReviewDTO> getReviews(Long carId) {
		List<OcenaDTO> ratings = ratingService.getRatings(carId, null);
		List<KomentarDTO> comments = commentService.getComments(carId, null, null);
		List<ReviewDTO> ret = new LinkedList<>();
		for (KomentarDTO k : comments) {
			OcenaDTO r = ratings.stream().filter(x -> x.getRezervacijaId() == k.getRezervacijaId()).findFirst()
					.orElse(null);
			ReviewDTO rdto = null;
			if (r == null)
				rdto = new ReviewDTO(k);
			else
				rdto = new ReviewDTO(r, k);
			ret.add(rdto);

		}
		return ret;
	}

}
