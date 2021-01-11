package com.example.Reservation.repository.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


//TODO prosiriti klasu da podrzava query parametre, path variable,... (ako za to ima potrebe xd)
public class RESTClient {
	private HttpMethod method;
	private String service;
	private Object body;
	private String path;


	private RESTClient() {
	}

	public static RESTClient getClient() {
		return new RESTClient();
	}

	public RESTClient withMethod(HttpMethod method) {
		this.method = method;
		return this;
	}
	
	public RESTClient withPath(String p) {
		this.path = p;
		return this;
	}


	public RESTClient witBbody(Object body) {
		this.body = body;
		return this;
	}

	public RESTClient forService(Services s) {
		this.service = s.getUrl();
		return this;
	}

	public Object send() {
		HttpServletRequest request = 
        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getRequest();
		HttpHeaders headers = new HttpHeaders();
		if (request.getHeader("Authorization") != null) {
			headers.set("Authorization", request.getHeader("Authorization"));
		}
		String rBody = null;
		if (body != null) {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			try {
				rBody = ow.writeValueAsString(body);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		HttpEntity<String> entity = new HttpEntity<>(rBody, headers);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Object> response = template.exchange("http://localhost:2020/"+service+path, method, entity,
				Object.class);
		return response.getBody();
	}

}
//TODO dodati ostale servise
enum Services {
	CAR("automobil-service"), LOGIN("loginreg-service"),
	OGLAS("oglas-service"),RESERVATION("reservation-service"),
	MESSAGE("message-service"), KOMENTAROCENA("rating-service");
	
	
	

	private String url;

	Services(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
