package com.example.Oglas.repository;

import org.aspectj.lang.JoinPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Oglas.model.TUser;

public interface UserRepository extends JpaRepository<TUser, Long> {

	TUser findByKorisnickoIme(String username);


}
