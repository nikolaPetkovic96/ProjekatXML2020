package com.team32.AgentApp.soap;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;

import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.repository.UserRepository;

@Component
public class SoapMessageSender extends WebServiceGatewaySupport {
	
	private String url = "http://localhost:2020/sync-service/soapWS";
	
	@Autowired
	UserRepository userRepository;
	private boolean refreshToken = false;
	public Object sendMessage(Object request) {
		Object response = getWebServiceTemplate().marshalSendAndReceive(url,
				request, new WebServiceMessageCallback() {
					@Override
					public void doWithMessage(WebServiceMessage message)
							throws IOException, TransformerException {
						Authentication authentication = SecurityContextHolder
								.getContext().getAuthentication();
						String currentPrincipalName = authentication == null
								? null
								: authentication.getName();
						if (currentPrincipalName == null)
							currentPrincipalName = "";
						User a = userRepository
								.findByKorisnickoIme(currentPrincipalName);
						if (a == null)
							return;
						TransportContext context = TransportContextHolder
								.getTransportContext();
						HttpUrlConnection connection = (HttpUrlConnection) context
								.getConnection();
						if (!refreshToken)
							connection.getConnection().addRequestProperty(
									"Authorization", "Bearer " + a.getToken());
//						else {
//							refreshToken = false;
//							connection.getConnection().addRequestProperty(
//									"Authorization",
//									"Bearer " + a.getRefreshToken());
//						}
					}
				});

		return response;
	}
	public void setRefresh(boolean b) {
		refreshToken=true;
	}
}
