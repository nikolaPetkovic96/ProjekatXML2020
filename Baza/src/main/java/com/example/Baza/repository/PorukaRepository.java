package com.example.Baza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Baza.model.Poruka;

public interface PorukaRepository extends JpaRepository <Poruka, Long> {

}
