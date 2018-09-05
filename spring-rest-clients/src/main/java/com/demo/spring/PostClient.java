package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "text/plain");
		headers.set("Content-Type", "application/json");

		Emp entity = new Emp(501, "The Rock", "Holiwood", 89000);

		HttpEntity req = new HttpEntity(entity, headers);

		ResponseEntity<String> response = rt.exchange("http://localhost:8081/emp/save", HttpMethod.POST, req,
				String.class);

		System.out.println(response.getBody());

	}

}
