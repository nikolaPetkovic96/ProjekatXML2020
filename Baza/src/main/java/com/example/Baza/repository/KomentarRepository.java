package com.example.Baza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Baza.model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {

}
