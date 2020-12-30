package com.example.Automobil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Automobil.model.Automobil;
import com.example.Automobil.model.TKlasaAutomobila;
import com.example.Automobil.model.TMarkaAutomobila;
import com.example.Automobil.model.TModelAutomobila;
import com.example.Automobil.model.TTipMenjaca;


public interface AutomobilRepository extends JpaRepository<Automobil, Long>{
	public List<Automobil> findAllByVrstaGorivaId(Long vrstaGorivaId);

	public List<Automobil> findAllByTipMenjacaId(Long id);

	public List<Automobil> findAllByModelAutomobilaId(Long id);

	public List<Automobil> findAllByKlasaAutomobilaId(Long id);

	public List<Automobil> findAllByMarkaAutomobilaId(Long id);
}
