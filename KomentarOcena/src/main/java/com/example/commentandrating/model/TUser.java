package com.example.commentandrating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.aspectj.weaver.loadtime.Agent;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "TUser")
@Immutable
public /* abstract */ class TUser /* implements UserDetails */ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "korisnicko_ime", unique = true, nullable = false)
	@XmlElement(name = "Korisnicko_ime", required = true)
	protected String korisnickoIme;

	public Long getId() {
		return id;
	}

	public TUser() {
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

}
