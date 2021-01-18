package com.example.commentandrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentandrating.model.Automobil;

public interface AutomobilRepository extends JpaRepository<Automobil, Long>{
	
}
