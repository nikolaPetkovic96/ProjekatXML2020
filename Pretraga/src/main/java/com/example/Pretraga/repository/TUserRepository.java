package com.example.Pretraga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Pretraga.model.TUser;



public interface TUserRepository extends JpaRepository<TUser, Long>{
	
//	TUser findByUsername(String username);
//
//	TUser findByRegistrationCode(String registrationCode);

}
