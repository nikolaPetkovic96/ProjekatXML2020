package com.example.commentandrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentandrating.model.Rezervacija;

public interface RezervacijaRepository extends JpaRepository  <Rezervacija, Long>{

}
