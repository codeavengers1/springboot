package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class HrController {

	@Autowired
	HrService hr;

	@GetMapping(path = "/hr/get", produces="application/json")
	public ResponseEntity<Emp> getEmpDetails(@RequestParam("id") int id) {
		return hr.processGet(id);
		//return ResponseEntity.ok(e);
	}

	@GetMapping(path = "/hr/list", produces="application/json")
	public ResponseEntity<List<Emp>> getEmpList() {
		return hr.processList();
	}
}
