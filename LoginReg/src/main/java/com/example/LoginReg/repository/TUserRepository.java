package com.example.LoginReg.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.LoginReg.model.Authority;
import com.example.LoginReg.model.TUser;

public interface TUserRepository extends JpaRepository<TUser, Long> {

	public TUser findOneByKorisnickoIme(String username);

	public List<TUser> findAllByAuthorities_Name(String name);


}
