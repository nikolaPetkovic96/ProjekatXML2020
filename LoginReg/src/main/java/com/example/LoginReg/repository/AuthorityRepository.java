package com.example.LoginReg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginReg.model.Authority;

@Repository
public interface AuthorityRepository
		extends
			JpaRepository<Authority, Long> {

	
	public Authority findOneByName(String name);

}
