package com.team32.AgentApp.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.team32.AgentApp.soap.dto.token.TokenRequest;

@Configuration
public class SoapConfig {

	@Bean
	public SecureMarshaller marshaller() {
		SecureMarshaller marshaller = new SecureMarshaller();
		//marshaller.setClassesToBeBound(Reservation.class);	
		//marshaller.setClassesToBeBound(TokenRequest.class);
		//marshaller.setPackagesToScan("com.team32.AgentApp.model");//,"com.team32.AgentApp.soap.dto");
		marshaller.setPackagesToScan("com.team32.AgentApp.soap.dto","com.team32.AgentApp.model");//,"com.team32.AgentApp.soap.dto");
		
		return marshaller;
	}

	@Bean
	public SoapMessageSender soapMessageSender(SecureMarshaller marshaller) {
		SoapMessageSender client = new SoapMessageSender();
		//client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
}