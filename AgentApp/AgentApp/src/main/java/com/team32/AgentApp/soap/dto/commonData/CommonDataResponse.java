package com.team32.AgentApp.soap.dto.commonData;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.CommonData;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCommonDataResponse", propOrder = { "types" })
@XmlRootElement(name = "GetCommonDataResponse")
public class CommonDataResponse {

	public CommonDataResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "CommonData", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<CommonData> types;

	public List<CommonData> getCommonDatas() {
		if (types == null) {
			types = new ArrayList<CommonData>();
		}
		return this.types;
	}

	public void setCommonData(List<CommonData> types) {
		this.types = types;
	}
}
