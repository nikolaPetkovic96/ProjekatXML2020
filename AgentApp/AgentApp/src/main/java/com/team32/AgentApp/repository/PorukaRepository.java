package com.team32.AgentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Poruka;

public interface PorukaRepository extends JpaRepository <Poruka, Long> {

}
