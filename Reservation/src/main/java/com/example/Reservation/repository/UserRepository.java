package com.example.Reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reservation.model.TUser;

public interface UserRepository extends JpaRepository<TUser, Long>{

	TUser findByKorisnickoIme(String username);

}
