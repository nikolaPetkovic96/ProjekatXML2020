package com.example.Oglas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Oglas.model.Narudzbenica;


public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long>{

	List<Narudzbenica> findByRezervacijaId(Long rezervacijaId);
}
