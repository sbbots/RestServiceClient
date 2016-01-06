package com.sbbots.rest.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import junit.framework.Assert;

public class TestClient {

	public static void main(String[] args) {

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		WebTarget webTarget = client.target(getBaseURI());

		String response = webTarget.path("hello").path("textPlain").request().accept(MediaType.TEXT_PLAIN)
				.get(Response.class).toString();

		String plainAnswer = webTarget.path("hello").path("Hello").request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		String xmlAnswer = webTarget.path("hello").path("Hello").request().accept(MediaType.TEXT_XML)
				.get(String.class);
		String htmlAnswer = webTarget.path("hello").path("Hello").request().accept(MediaType.TEXT_HTML)
				.get(String.class);
		
		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
		System.out.println(htmlAnswer);

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RestService/rest").build();
	}
}
