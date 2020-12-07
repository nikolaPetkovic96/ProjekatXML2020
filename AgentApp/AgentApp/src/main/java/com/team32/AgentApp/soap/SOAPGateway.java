package com.team32.AgentApp.soap;
/*
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPGateway extends WebServiceGatewaySupport {
	
	@Value("${syncAppPath}")
	private String syncUrl;
	
	private WebServiceMessageCallback callback=new MessageCallback();
	
	public Object send(Object message) {
		return getWebServiceTemplate().marshalSendAndReceive(syncUrl,message,callback);
	}
	
	private class MessageCallback implements WebServiceMessageCallback{

		@Override
		public void doWithMessage(WebServiceMessage arg0) throws IOException, TransformerException {
			//TODO add auth headers
		}
		
	}
	
}
*/