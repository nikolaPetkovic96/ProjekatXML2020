package com.example.Automobil.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Automobil.model.CommonData;
import com.example.Automobil.model.TModelAutomobila;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.TModelAutomobilaRepository;

@Service
public class CarModelService {
	@Autowired
	private TModelAutomobilaRepository carCalssRepositorz;
	@Autowired
	private AutomobilRepository autoRepository;
	@Autowired
	private CommonDataRepository cmdRep;

	public List<TModelAutomobila> getAll(Long model) {
		if (model == null)
			return carCalssRepositorz.findAll();
		return carCalssRepositorz.findAllBymarkaAutomobilaId(model);
	}

	public TModelAutomobila addNew(TModelAutomobila t) {
		CommonData d = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		d.setDatumIzmene(now);
		d.setDatumKreiranja(now);
		cmdRep.saveAndFlush(d);
		t.setCommonDataId(d.getId());
		try {
			carCalssRepositorz.saveAndFlush(t);
		}
		catch (Exception e) {try {
			cmdRep.delete(d);
		}catch (Exception exc) {
			// TODO: handle exception
		}
			throw new DataIntegrityViolationException("Car class is not unique!");
		}

		return t;
	}

	public boolean deleteOne(Long id) {
		if (autoRepository.findAllByModelAutomobilaId(id).size() != 0) {
			throw new DataIntegrityViolationException("Class is in use!");
		}
		Optional<TModelAutomobila> tip = carCalssRepositorz.findById(id);
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Class not found!");

		carCalssRepositorz.deleteById(id);
		cmdRep.deleteById(id);
		return true;
	}

	public TModelAutomobila changeOne(TModelAutomobila t) {
		Optional<TModelAutomobila> tip = carCalssRepositorz.findById(t.getId());
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Type not found!");
		TModelAutomobila tt = tip.get();
		CommonData cd = cmdRep.getOne(tt.getCommonDataId());
		cd.setDatumIzmene(LocalDateTime.now());
		cmdRep.saveAndFlush(cd);
		tt.setNazivModela(t.getNazivModela());
		carCalssRepositorz.saveAndFlush(tt);
		return tt;
	}

}
