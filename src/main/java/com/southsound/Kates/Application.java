package com.southsound.Kates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public String helloCall(String firstName, String lastName) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> restExchange =
				restTemplate.exchange("http://localhost/services" + "{firstName}/{lastName}",
						HttpMethod.GET, null, String.class, firstName);

		return restExchange.getBody();
	}

	@RequestMapping(value = "/{ctxName}", method = RequestMethod.GET)
	public String hello(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return helloCall(firstName, lastName);
	}
}
