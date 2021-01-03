package com.example.Automobil.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Automobil.model.CommonData;
import com.example.Automobil.model.TMarkaAutomobila;
import com.example.Automobil.model.TModelAutomobila;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.repository.TMarkaAutomobilaRepository;
import com.example.Automobil.repository.TModelAutomobilaRepository;

@Service
public class CarBrandService {
	@Autowired
	private TMarkaAutomobilaRepository carCalssRepositorz;
	@Autowired
	private AutomobilRepository autoRepository;
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private CarModelService modSer;
	
	@Autowired
	private TModelAutomobilaRepository modelRepo;



	public List<TMarkaAutomobila> getAll() {
		return carCalssRepositorz.findAll();
	}

	public TMarkaAutomobila addNew(TMarkaAutomobila t) {
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
	@Transactional(value=TxType.REQUIRED)
	public boolean deleteOne(Long id) {
		if (autoRepository.findAllByMarkaAutomobilaId(id).size() != 0) {
			throw new DataIntegrityViolationException("Class is in use!");
		}
		Optional<TMarkaAutomobila> tip = carCalssRepositorz.findById(id);
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Class not found!");

		
		List<TModelAutomobila> models=modelRepo.findAllBymarkaAutomobilaId(id);
		for(TModelAutomobila model : models) {
			modSer.deleteOne(model.getId());
		}
		carCalssRepositorz.deleteById(tip.get().getId());
		cmdRep.deleteById(tip.get().getCommonDataId());
		return true;
	}

	public TMarkaAutomobila changeOne(TMarkaAutomobila t) {
		Optional<TMarkaAutomobila> tip = carCalssRepositorz.findById(t.getId());
		if (!tip.isPresent())
			throw new DataIntegrityViolationException("Type not found!");
		TMarkaAutomobila tt = tip.get();
		CommonData cd = cmdRep.getOne(tt.getCommonDataId());
		cd.setDatumIzmene(LocalDateTime.now());
		cmdRep.saveAndFlush(cd);
		tt.setNazivMarke(t.getNazivMarke());
		carCalssRepositorz.saveAndFlush(tt);
		return tt;
	}

}
