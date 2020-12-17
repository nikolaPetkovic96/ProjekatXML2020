package com.team32.AgentApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Narudzbenica;

public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long>{

	List<Narudzbenica> findAllByOglasId(Long oglasId);

	List<Narudzbenica> findAllByAgentId(Long agentId);

}
