package com.example.Automobil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Automobil.model.CommonData;

public interface CommonDataRepository extends JpaRepository<CommonData, Long> {

//	CommonData findById(Long commonDataId);

}
