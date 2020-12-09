package com.team32.AgentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {

}
