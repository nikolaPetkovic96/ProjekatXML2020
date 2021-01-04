package com.example.Automobil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Automobil.model.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Long>{

	List<Ocena> findByAutoId(Long autoId);
}
