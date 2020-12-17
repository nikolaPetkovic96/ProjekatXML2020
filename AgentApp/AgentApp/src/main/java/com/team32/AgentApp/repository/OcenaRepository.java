package com.team32.AgentApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {

	List<Ocena> findAllByAutomobilId(Long autoId);

}
