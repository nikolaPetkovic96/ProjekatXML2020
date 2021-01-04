package com.example.Automobil.dto;

import java.util.List;

public class AutomobilDTOReviews extends AutomobilDTO {
	
	List<RecenzijaDTO> recenzije;
	
	public AutomobilDTOReviews(List<RecenzijaDTO> recenzije,AutomobilDTO auto)  {
		super(auto);
		this.recenzije=recenzije;
	}

	public List<RecenzijaDTO> getRecenzije() {
		return recenzije;
	}

	public void setRecenzije(List<RecenzijaDTO> recenzije) {
		this.recenzije = recenzije;
	}

}
