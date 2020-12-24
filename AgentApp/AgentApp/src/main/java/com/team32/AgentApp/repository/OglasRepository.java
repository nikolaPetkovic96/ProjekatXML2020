package com.team32.AgentApp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Oglas;

public interface OglasRepository extends JpaRepository<Oglas, Long>{

	List<Oglas> findAllByAutomobilId(Long automobilId);

	
}
