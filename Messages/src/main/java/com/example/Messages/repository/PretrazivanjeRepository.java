package com.example.Messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages.SchemaToJava2.model.entitet.Pretrazivanje;

public interface PretrazivanjeRepository extends JpaRepository <Pretrazivanje, Long> {

}
