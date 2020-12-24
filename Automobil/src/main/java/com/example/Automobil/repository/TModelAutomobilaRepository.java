package com.example.Automobil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Automobil.model.TModelAutomobila;

public interface TModelAutomobilaRepository extends JpaRepository<TModelAutomobila, Long> {
	public List<TModelAutomobila> findAllBymarkaAutomobilaId(Long model);
}
