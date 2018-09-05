package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpRestDataController {
	@Autowired
	EmpRepository repo;

	@RequestMapping(path = "/emp/find/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Emp findEmp(@PathVariable("id") int id) {
		Emp e = null;
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			e = o.get();
		} else {
			throw new RuntimeException("Emp Not Found");
		}
		return e;
	}

	// @RequestMapping(path = "/emp", method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getEmpList() {
		return repo.findAll();
	}

	@PostMapping(path = "/emp/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain")
	public String saveEmp(@RequestBody Emp e) {
		if (repo.existsById(e.getEmpId())) {
			return "Emp Already exists";
		} else {
			repo.save(e);
			return "saved";
		}
	}

}
