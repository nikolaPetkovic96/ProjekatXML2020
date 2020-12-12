package com.team32.AgentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
//	TUser findByUsername(String username);
//
//	TUser findByRegistrationCode(String registrationCode);

}
