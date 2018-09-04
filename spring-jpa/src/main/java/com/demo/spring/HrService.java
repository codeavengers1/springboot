package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	EmpDao dao;

	public String register(int id, String name, String city, double salary) {
		return dao.save(new Emp(id, name, city, salary));
	}

	public List<Emp> getEmpList() {

		return dao.getEmpList();
	}
	
	@Transactional
	public String saveEmpList(List<Emp> elist) {
		for(Emp e:elist) {
			dao.save(e);
		}
		return "success";
	}
	
	@Transactional
	public String removeEmp(int id) {
		return dao.delete(id);
	}
}
