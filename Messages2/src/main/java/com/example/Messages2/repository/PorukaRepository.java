package com.example.Messages2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages2.model.Poruka;


public interface PorukaRepository extends JpaRepository <Poruka, Long> {

	List<Poruka> findAllByRezervacijaId(Long rezervId);

}
