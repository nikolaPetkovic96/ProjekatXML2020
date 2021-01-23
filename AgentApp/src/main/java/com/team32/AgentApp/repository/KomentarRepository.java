package com.team32.AgentApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {

	List<Komentar> findAllByAutomobilId(Long autoId);

}
