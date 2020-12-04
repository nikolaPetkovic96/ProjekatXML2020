package com.example.Baza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Baza.model.TUser;



public interface TUserRepository extends JpaRepository<TUser, Long>{
	
//	TUser findByUsername(String username);
//
//	TUser findByRegistrationCode(String registrationCode);

}
