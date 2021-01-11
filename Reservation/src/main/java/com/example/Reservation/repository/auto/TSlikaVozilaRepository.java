package com.example.Reservation.repository.auto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.auto.TSlikaVozila;


public interface TSlikaVozilaRepository extends JpaRepository<TSlikaVozila, Long> {

	TSlikaVozila findByAutomobilId(Long automobilId);
}
