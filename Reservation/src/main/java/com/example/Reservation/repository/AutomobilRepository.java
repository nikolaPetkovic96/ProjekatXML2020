package com.example.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.Automobil;



public interface AutomobilRepository extends JpaRepository<Automobil, Long>{

}