package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetClient {

	public static void main(String[] args) {
		String plainTextCred = "shantanu:welcome1";

		String encodedCred = new String(Base64.encodeBase64(plainTextCred.getBytes()));
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/xml");
		headers.set("Authorization", "Basic " +encodedCred);

		HttpEntity req = new HttpEntity(headers);

		ResponseEntity<Emp> response = rt.exchange("http://localhost:8081/emp/find/" + 105, HttpMethod.GET, req,
				Emp.class);
		 System.out.println(response.getBody());
		 
		/* 
		 * ResponseEntity<List<Emp>> response1=rt.exchange( "http://localhost:8081/emp",
		 * HttpMethod.GET, req, new ParameterizedTypeReference<List<Emp>>() { });
		 * 
		 * response1.getBody().stream().forEach(System.out::println);
		 * 
		 */
	}

}
