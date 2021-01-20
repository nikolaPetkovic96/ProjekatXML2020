package com.example.sync.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/soapWS/*");
	}
	
	@Bean
	public XsdSchema syncSchema() {
		return new SimpleXsdSchema(new ClassPathResource("syncData.xsd"));
	}

	@Bean(name = "syncData")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema syncSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setSchema(syncSchema);
		wsdl11Definition.setLocationUri("/soapWS");
		wsdl11Definition.setPortTypeName("SyncServicePort");
		wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/sync");	
		return wsdl11Definition;
	}
	
}

