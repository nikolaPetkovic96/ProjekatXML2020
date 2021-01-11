package com.example.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.Poruka;

public interface PorukaRepository extends JpaRepository <Poruka, Long> {

}
