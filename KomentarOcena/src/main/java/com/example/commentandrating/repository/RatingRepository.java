package com.example.commentandrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commentandrating.model.Ocena;

@Repository
public interface RatingRepository extends JpaRepository<Ocena, Long> {

}