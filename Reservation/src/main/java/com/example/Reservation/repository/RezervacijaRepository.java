package com.example.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.Rezervacija;


public interface RezervacijaRepository extends JpaRepository  <Rezervacija, Long>{

}
