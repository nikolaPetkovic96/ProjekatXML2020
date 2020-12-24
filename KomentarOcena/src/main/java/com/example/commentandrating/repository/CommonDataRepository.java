package com.example.commentandrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commentandrating.model.CommonData;

@Repository
public interface CommonDataRepository extends JpaRepository<CommonData, Long> {

}
