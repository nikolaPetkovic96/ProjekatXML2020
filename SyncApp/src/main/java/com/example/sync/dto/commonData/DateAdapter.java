package com.example.sync.dto.commonData;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sun.el.parser.ParseException;

public class DateAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    @Override
    public String marshal(LocalDateTime v) {
        //return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return v.format(formatter);
    }

    @Override
    public LocalDateTime unmarshal(String v) throws ParseException {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(v.replace('T',' ' ), formatter);
		return dateTime;
        //return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(v);
    }

}
