package com.example.Oglas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Oglas.model.Automobil;


public interface AutomobilRepository extends JpaRepository<Automobil, Long>{
	public List<Automobil> findAllByVrstaGorivaId(Long vrstaGorivaId);

	public List<Automobil> findAllByTipMenjacaId(Long id);

	public List<Automobil> findAllByModelAutomobilaId(Long id);

	public List<Automobil> findAllByKlasaAutomobilaId(Long id);

	public List<Automobil> findAllByMarkaAutomobilaId(Long id);
}