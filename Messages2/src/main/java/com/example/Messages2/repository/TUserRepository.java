package com.example.Messages2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages2.model.TUser;



public interface TUserRepository extends JpaRepository<TUser, Long>{
	
//	TUser findByUsername(String username);
//
//	TUser findByRegistrationCode(String registrationCode);

}
