package com.example.Oglas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Oglas.model.CommonData;

public interface CommonDataRepository extends JpaRepository<CommonData, Long> {

//	CommonData findById(Long commonDataId);

}
