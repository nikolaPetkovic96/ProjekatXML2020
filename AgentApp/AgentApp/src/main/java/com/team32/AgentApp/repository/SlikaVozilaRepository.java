package com.team32.AgentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.team32.AgentApp.model.tentitet.SlikaVozila;

public interface SlikaVozilaRepository extends JpaRepository<SlikaVozila, Long> {

	SlikaVozila findByAutomobilId(Long automobilId);

}
