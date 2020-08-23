package com.example.Messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;

public interface RegistrovaniKorisnikRepository extends JpaRepository <RegistrovaniKorisnik, Long> {

}
