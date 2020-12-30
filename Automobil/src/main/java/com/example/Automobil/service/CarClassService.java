package com.example.Automobil.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Automobil.model.CommonData;
import com.example.Automobil.model.TKlasaAutomobila;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.TKlasaAutomobilaRepository;

@Service
public class CarClassService {
	@Autowired
	private TKlasaAutomobilaRepository carCalssRepositorz;
	@Autowired
	private AutomobilRepository autoRepository;
	@Autowired
	private CommonDataRepository cmdRep;

	public List<TKlasaAutomobila> getAll() {
		return carCalssRepositorz.findAll();
	}

	public TKlasaAutomobila addNew(TKlasaAutomobila t) {
		CommonData d = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		d.setDatumIzmene(now);
		d.setDatumKreiranja(now);
		cmdRep.saveAndFlush(d);
		t.setCommonDataId(d.getId());
		try {
			carCalssRepositorz.saveAndFlush(t);
		}

		catch (Exception e) {
			try {
				cmdRep.delete(d);
			}catch (Exception exc) {
				// TODO: handle exception
			}
			throw new DataIntegrityViolationException("Car class is not unique!");
		}

		return t;
	}

	public boolean deleteOne(Long id) {
		if (autoRepository.findAllByKlasaAutomobilaId(id).size() != 0) {
			throw new DataIntegrityViolationException("Class is in use!");
		}
		Optional<TKlasaAutomobila> tip = carCalssRepositorz.findById(id);
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Class not found!");

		carCalssRepositorz.deleteById(id);
		cmdRep.deleteById(id);
		return true;
	}

	public TKlasaAutomobila changeOne(TKlasaAutomobila t) {
		Optional<TKlasaAutomobila> tip = carCalssRepositorz.findById(t.getId());
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Type not found!");
		TKlasaAutomobila tt = tip.get();
		CommonData cd = cmdRep.getOne(tt.getCommonDataId());
		cd.setDatumIzmene(LocalDateTime.now());
		cmdRep.saveAndFlush(cd);
		tt.setNazivKlase(t.getNazivKlase());
		carCalssRepositorz.saveAndFlush(tt);
		return tt;
	}

}
