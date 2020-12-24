package com.example.commentandrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentandrating.model.TUser;


public interface TUserRepository extends JpaRepository<TUser, Long>{
	
//	TUser findByUsername(String username);
//
//	TUser findByRegistrationCode(String registrationCode);

}
