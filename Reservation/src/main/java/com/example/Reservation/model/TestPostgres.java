package com.example.Reservation.model;

import javax.persistence.Entity;

@Entity
public class TestPostgres {

	private String test;

	public TestPostgres() {
		super();
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	} 
	
	
	
}
