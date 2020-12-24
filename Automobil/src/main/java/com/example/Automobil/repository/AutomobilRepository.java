package com.example.Automobil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Automobil.model.Automobil;


public interface AutomobilRepository extends JpaRepository<Automobil, Long>{
	public List<Automobil> findAllByVrstaGorivaId(Long vrstaGorivaId);
}
