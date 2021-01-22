package com.team32.AgentApp.soap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{

	@Override
	public String marshal(LocalDateTime v) throws Exception {
	    //return arg0.toString();	
		//return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return v.format(formatter);
	}

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
	   // return LocalDateTime.parse(arg0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(v, formatter);
		return dateTime;
	}

}
