package com.example.Automobil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Automobil.model.Oglas;


public interface OglasRepository extends JpaRepository<Oglas, Long>{

		public List<Oglas> findAllByAutomobilId(Long id);
}
