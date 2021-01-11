package com.example.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.Cenovnik;



public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

}
