package com.example.sync.dto.komentar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetKomentarResponse", propOrder = { "types" })
@XmlRootElement(name = "GetKomentarResponse")
public class KomentarResponse {

	public KomentarResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Komentar", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Komentar> types;

	public List<Komentar> getTypes() {
		if (types == null) {
			types = new ArrayList<Komentar>();
		}
		return this.types;
	}

	public void setTypes(List<Komentar> types) {
		this.types = types;
	}

}
