package com.example.Oglas.repository.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Oglas.dto.CenovnikDTO;
import com.example.Oglas.model.Cenovnik;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.repository.CenovnikRepository;
import com.example.Oglas.repository.service.mapper.CenovnikMapper;

@Service
public class CenovnikService {
	@Autowired
	private CenovnikRepository cenRep;
	@Autowired
	private CenovnikMapper cenMap;
	@Autowired
	private CommonDataService cmdServ;
	public List<CenovnikDTO> getAllCenovnik() {
		List<CenovnikDTO> svi=cenRep.findAll().stream().map(x->cenMap.toDTO(x)).collect(Collectors.toList());
		return svi;
	}
	public CenovnikDTO getOne(Long id) {
		CenovnikDTO dto=cenRep.findById(id).map(x->cenMap.toDTO(x)).orElse(null);
		return dto;
	}
	public Cenovnik createCenovnik(CenovnikDTO dto, Long userId) throws Exception {
		Cenovnik c=new Cenovnik();
		c.setCenaCollisionDamageWaiver(dto.getCenaCollisionDamageWaiver());
		c.setCenaPoDanu(dto.getCenaPoDanu());
		c.setCenaPoKilometru(dto.getCenaPoKilometru());
		c.setNazivCenovnika(dto.getNazivCenovnika());
		c.setPopustZaPreko30Dana(dto.getPopustZaPreko30Dana());
		
		CommonData cmd=new CommonData();
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd.setDatumKreiranja(LocalDateTime.now());
		cmd.setUserId(userId);
		
		cmd=cmdServ.addCommonData(cmd);
		c.setCommonDataId(cmd.getId());
		c=addCenovnik(c);
		
		return c;
		
	}
	private Cenovnik addCenovnik(Cenovnik c) throws Exception {
		if(c.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Cenovnik saved = cenRep.save(c);
		return saved;
	}
	public Cenovnik updateCenovnik(CenovnikDTO dto) throws Exception {
		Cenovnik updated=cenRep.findById(dto.getId()).orElse(null);
		if(updated==null)
			return null;
		CommonData cmd=cmdServ.findOne(updated.getCommonDataId());
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd=cmdServ.updateCommonData(cmd.getId(), cmd);
		
		updated.setId(dto.getId());
		updated.setCenaCollisionDamageWaiver(dto.getCenaCollisionDamageWaiver());
		updated.setCenaPoDanu(dto.getCenaPoDanu());
		updated.setCenaPoKilometru(dto.getCenaPoKilometru());
		updated.setNazivCenovnika(dto.getNazivCenovnika());
		updated.setPopustZaPreko30Dana(dto.getPopustZaPreko30Dana());
		updated.setCommonDataId(dto.getCommonDataId());
		
		updated=cenRep.save(updated);
		return updated;
	}
	public Cenovnik deleteCenovnik(Long id) {
		Cenovnik c= cenRep.findById(id).orElse(null);
		if(c==null)
			return null;
		cmdServ.deleteCommonData(c.getCommonDataId());
		cenRep.delete(c);
		return c;		
	}


}
