package com.example.Messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages.SchemaToJava2.model.entitet.CommonData;

public interface CommonDataRepository extends JpaRepository<CommonData, Long>{

}
