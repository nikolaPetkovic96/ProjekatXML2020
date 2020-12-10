package com.example.LoginReg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LoginReg.model.TUser;

public interface TUserRepository extends JpaRepository<TUser, Long> {

	public TUser findOneByKorisnickoIme(String username);

}
