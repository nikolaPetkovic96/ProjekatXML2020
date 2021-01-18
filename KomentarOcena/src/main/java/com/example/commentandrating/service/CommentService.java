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

	public ResponseEntity<?> createComent(KomentarDTO kom) {
		//TODO provere: da li je realizovana, da li auto priprada toj rezervaciji, da li je vec unet komentar
		List<Komentar> komentari = commentRepoitory.findAll();
		for(Komentar k : komentari) {
			if(kom.getAutomobilId() == k.getAutomobilId() && kom.getRezervacijaId() == k.getRezervacijaId()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Vec postoji oglas!");
			}
		}
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId=Long.parseLong(request.getHeader("userid"));
		
		Komentar k = commentMapper.fromDto(kom);
		
		CommonData cd=new CommonData();
		cd.setUserId(userId);
		cd.setDatumKreiranja(LocalDateTime.now());
		commonDataRepository.saveAndFlush(cd);
		
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		k.setAutor(name);
		k.setCommonDataId(cd.getId());
		commentRepoitory.saveAndFlush(k);
		
		return new ResponseEntity<>(commentMapper.toDTO(k), HttpStatus.CREATED);
	}

	public KomentarDTO approve(Long id, boolean b) {
		Komentar k = commentRepoitory.findById(id).get();
		k.setOdobren(b);
		CommonData data = commonDataRepository.findById(k.getCommonDataId()).get();
		data.setDatumIzmene(LocalDateTime.now());
		commonDataRepository.saveAndFlush(data);
		commentRepoitory.saveAndFlush(k);
		return commentMapper.toDTO(k);
	}

}
