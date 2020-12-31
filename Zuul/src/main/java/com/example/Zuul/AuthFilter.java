package com.example.Zuul;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AuthFilter extends ZuulFilter {
	@Autowired
	private EurekaClient client;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		Application a = client.getApplication("LOGINREG-SERVICE");

		String url = a.getInstances().get(0).getHomePageUrl();
		HttpHeaders headers = new HttpHeaders();
		if (ctx.getRequest().getHeader("Authorization") != null) {
			headers.set("Authorization", ctx.getRequest().getHeader("Authorization"));
		}

		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		RestTemplate template = new RestTemplate();
		HttpEntity<HashMap> response = template.exchange(url + "/api/user/auth", HttpMethod.POST, entity,
				HashMap.class);

		HashMap resultString = response.getBody();
		ctx.addZuulRequestHeader("username", (String) resultString.get("username"));
		ctx.addZuulRequestHeader("userid", ((Integer) resultString.get("userid")).toString());

		
		List<String> xdxdxdd= (List<String>) resultString.get("roles");

		ctx.addZuulRequestHeader("roles", Arrays.toString(xdxdxdd.toArray(new String[0])));


		return null;
	}

}
