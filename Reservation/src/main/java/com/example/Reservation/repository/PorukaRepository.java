package com.example.Reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.Poruka;
 

public interface PorukaRepository extends JpaRepository <Poruka, Long> {

	List<Poruka> findAllByRezervacijaId(Long rezervId);

}
