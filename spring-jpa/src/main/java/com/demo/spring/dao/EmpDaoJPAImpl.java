package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJPAImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "success";
	}

	@Override
	public String delete(int empId) {

		Emp e = em.find(Emp.class, empId);
		if (e != null) {
			em.remove(e);
			return "deleted";
		} else {
			return "not deleted";
		}

	}

	@Override
	public List<Emp> getEmpList() {
		Query query = em.createQuery("select e from Emp e");

		return query.getResultList();
	}

	@Override
	public Emp findById(int empId) {
		Emp e = em.find(Emp.class, empId);
		return e;
	}

}
