package com.team32.AgentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Rezervacija;

public interface RezervacijaRepository extends JpaRepository  <Rezervacija, Long>{

}
