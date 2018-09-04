package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {

	public String save(Emp e);

	public String delete(int empId);

	public List<Emp> getEmpList();

	public Emp findById(int empId);
}
