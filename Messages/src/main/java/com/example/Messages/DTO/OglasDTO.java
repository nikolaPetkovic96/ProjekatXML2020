package com.example.Messages.DTO;

import java.util.Date;

import com.example.Messages.SchemaToJava2.model.entitet.Oglas;

public class OglasDTO {

	private long id;
	private Date odDatuma;
	private Date doDatuma;
	
	public OglasDTO() {
		
	}
	
	
	public OglasDTO(long id, Date odDatuma, Date doDatuma) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
	}
 
	public OglasDTO(Oglas o) {
		this(o.getId(), o.getOdDatuma(), o.getDoDatuma());
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getOdDatuma() {
		return odDatuma;
	}
	public void setOdDatuma(Date odDatuma) {
		this.odDatuma = odDatuma;
	}
	public Date getDoDatuma() {
		return doDatuma;
	}
	public void setDoDatuma(Date doDatuma) {
		this.doDatuma = doDatuma;
	}
	
	
	
}
