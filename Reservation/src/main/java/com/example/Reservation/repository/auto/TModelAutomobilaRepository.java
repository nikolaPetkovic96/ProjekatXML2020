package com.example.Reservation.repository.auto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.auto.TModelAutomobila;


public interface TModelAutomobilaRepository extends JpaRepository<TModelAutomobila, Long> {
	public List<TModelAutomobila> findAllBymarkaAutomobilaId(Long model);
}
