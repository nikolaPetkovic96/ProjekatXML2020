package com.example.Oglas.repository.auto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Oglas.model.auto.TSlikaVozila;


public interface TSlikaVozilaRepository extends JpaRepository<TSlikaVozila, Long> {

	TSlikaVozila findByAutomobilId(Long automobilId);
}
