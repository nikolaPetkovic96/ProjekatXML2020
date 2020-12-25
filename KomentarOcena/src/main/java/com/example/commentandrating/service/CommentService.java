package com.example.commentandrating.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentandrating.dto.KomentarDTO;
import com.example.commentandrating.model.CommonData;
import com.example.commentandrating.model.Komentar;
import com.example.commentandrating.repository.CommentRepoitory;
import com.example.commentandrating.repository.CommonDataRepository;
import com.example.commentandrating.service.mapper.CommentMapper;

@Service
public class CommentService {
	@Autowired
	private CommentRepoitory commentRepoitory;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CommonDataRepository commonDataRepository;

	public List<KomentarDTO> getComments(Long carId, Long reservationId, Boolean approved) {

		return commentRepoitory.findAll().stream().filter(comment -> carId == null || comment.getAutomobilId() == carId)
				.filter(comment -> reservationId == null || reservationId == comment.getRezervacijaId())
				.filter(comment -> approved == null || approved == comment.isOdobren())
				.map(comment -> commentMapper.toDTO(comment)).collect(Collectors.toList());
	}

	public KomentarDTO getComment(Long id) {
		return commentRepoitory.findById(id).map(comment -> commentMapper.toDTO(comment)).orElse(null);
	}

	public KomentarDTO createComent(KomentarDTO kom) {
		//TODO provere: da li je realizovana, da li auto priprada toj rezervaciji, da li je vec unet komentar
		Komentar k = commentMapper.fromDto(kom);
		commentRepoitory.saveAndFlush(k);
		return commentMapper.toDTO(k);
	}

	public KomentarDTO approve(Long id) {
		Komentar k = commentRepoitory.findById(id).get();
		k.setOdobren(true);
		CommonData data = commonDataRepository.findById(k.getCommonDataId()).get();
		data.setDatumIzmene(LocalDateTime.now());
		commonDataRepository.saveAndFlush(data);
		commentRepoitory.saveAndFlush(k);
		return commentMapper.toDTO(k);
	}
}