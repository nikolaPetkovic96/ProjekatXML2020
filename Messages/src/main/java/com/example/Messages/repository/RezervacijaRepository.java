package com.example.Messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;

public interface RezervacijaRepository extends JpaRepository  <Rezervacija, Long>{

}
