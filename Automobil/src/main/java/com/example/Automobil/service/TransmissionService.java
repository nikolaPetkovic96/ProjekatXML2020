package com.example.Automobil.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Automobil.model.CommonData;
import com.example.Automobil.model.TTipMenjaca;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.TTipMenjacaRepository;

@Service
public class TransmissionService {
	@Autowired
	private TTipMenjacaRepository tipGorivaRepository;
	@Autowired
	private AutomobilRepository autoRepository;
	@Autowired
	private CommonDataRepository cmdRep;

	public List<TTipMenjaca> getAll() {
		return tipGorivaRepository.findAll();
	}

	public TTipMenjaca addNew(TTipMenjaca t) {
		CommonData d = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		d.setDatumIzmene(now);
		d.setDatumKreiranja(now);
		cmdRep.saveAndFlush(d);
		t.setCommonDataId(d.getId());
		try {
			tipGorivaRepository.saveAndFlush(t);
		}

		catch (Exception e) {try {
			cmdRep.delete(d);
		}catch (Exception exc) {
			// TODO: handle exception
		}
			throw new DataIntegrityViolationException("Type is not unique!");
		}

		return t;
	}

	public boolean deleteOne(Long id) {
		if (autoRepository.findAllByVrstaGorivaId(id).size() != 0) {
			throw new DataIntegrityViolationException("Type is in use!");
		}
		Optional<TTipMenjaca> tip = tipGorivaRepository.findById(id);
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Type not found!");

		tipGorivaRepository.deleteById(id);
		cmdRep.deleteById(id);
		return true;
	}

	public TTipMenjaca changeOne(TTipMenjaca t) {
		Optional<TTipMenjaca> tip = tipGorivaRepository.findById(t.getId());
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Type not found!");
		TTipMenjaca tt = tip.get();
		CommonData cd = cmdRep.getOne(tt.getCommonDataId());
		cd.setDatumIzmene(LocalDateTime.now());
		cmdRep.saveAndFlush(cd);
		tt.setNazivMenjaca(t.getNazivMenjaca());
		tipGorivaRepository.saveAndFlush(tt);
		return tt;
	}

}
