package com.demo.spring;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {
	@Autowired
	RestTemplate rt;

	/*
	 * @Autowired LoadBalancerClient lbClient;
	 */

	//@HystrixCommand(fallbackMethod = "handleGet")
	public ResponseEntity processGet(int id) {
		String plainTextCred = "shantanu:welcome1";

		String encodedCred = new String(Base64.encodeBase64(plainTextCred.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic " + encodedCred);

		HttpEntity req = new HttpEntity(headers);

		/*
		 * ServiceInstance instance=lbClient.choose("demo"); String
		 * baseUri=instance.getHost()+":"+instance.getPort();
		 */
		ResponseEntity<String> response = rt.exchange("http://emp-service/emp/find/" + id, HttpMethod.GET, req, String.class);
		System.out.println(response.getBody());
		return response;
	}

	@HystrixCommand(fallbackMethod = "handleList")
	public ResponseEntity processList() {
		String plainTextCred = "shantanu:welcome1";

		String encodedCred = new String(Base64.encodeBase64(plainTextCred.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic " + encodedCred);

		HttpEntity req = new HttpEntity(headers);
		/*
		 * ServiceInstance instance=lbClient.choose("demo"); String
		 * baseUri=instance.getHost()+":"+instance.getPort();
		 */

		ResponseEntity<String> response = rt.exchange("http://emp-service/emp", HttpMethod.GET, req,
				String.class);
		return response;
	}

	public ResponseEntity handleGet(int id) {
		return ResponseEntity.ok("Employee Finder Service is Down, Try after Some time");
	}

	public ResponseEntity handleList() {
		return ResponseEntity.ok("Employee List Service is Down, Try after Some time");
	}
}
