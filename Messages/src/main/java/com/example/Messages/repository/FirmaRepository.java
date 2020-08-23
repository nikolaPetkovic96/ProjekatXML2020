package com.example.Messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages.SchemaToJava2.model.user.Firma;

public interface FirmaRepository extends JpaRepository<Firma, Long> {

}
