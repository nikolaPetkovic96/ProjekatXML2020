package com.team32.AgentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team32.AgentApp.model.entitet.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByKorisnickoIme(String username);

	User findByRegistrationCode(String registrationCode);

}
