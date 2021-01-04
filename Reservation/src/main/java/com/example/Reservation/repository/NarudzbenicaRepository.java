package com.example.Reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;


public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long>{

	List<Narudzbenica> findByRezervacijaId(Long rezervacijaId);
}
