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

import com.example.commentandrating.dto.KomentarDTO;
import com.example.commentandrating.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentsController {
	@Autowired
	private CommentService commentService;

	@GetMapping(value = "")
	public List<KomentarDTO> getComments(@RequestParam(name = "car", required = false) Long carId,
			@RequestParam(required = false, name = "reservation") Long reservationId,
			@RequestParam(required = false, name = "approved") Boolean approved) {
		return commentService.getComments(carId, reservationId, approved);
	}

	@GetMapping(value = "/{id}")
	public KomentarDTO getCommentById(@PathVariable("id") Long id) {
		return commentService.getComment(id);
	}

	@PostMapping(value = "")
	public KomentarDTO addComment(@RequestBody KomentarDTO kom) {
		return commentService.createComent(kom);
	}
	
	@PostMapping(value = "/{id}")
	public KomentarDTO approve(@PathVariable("id") Long id,@RequestParam("approved") String approved) {
		return commentService.approve(id,Boolean.parseBoolean(approved));
	}

}
