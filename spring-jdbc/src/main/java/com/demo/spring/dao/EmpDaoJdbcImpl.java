package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {
	@Autowired
	JdbcTemplate jt;

	@Override
	public String save(Emp e) {
		String INSERT_STMT = "insert into EMP (empno,name,address,salary) values(?,?,?,?)";
		String response = "";
		try {
			int count = jt.update(new PreparedStatementCreator() {

				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(INSERT_STMT);
					pst.setInt(1, e.getEmpId());
					pst.setString(2, e.getName());
					pst.setString(3, e.getCity());
					pst.setDouble(4, e.getSalary());
					return pst;
				}
			});
			if (count == 1) {
				response = "saved";
			} else {
				response = "not saved";
			}
		} catch (DuplicateKeyException ex) {
			response = "emp already exists";
			throw ex;
		} catch (Exception e2) {
			response = "Problem in saving EMP";
			throw e2;
		}
		return response;
	}

	@Override
	public String delete(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getEmpList() {
		List<Emp> empList = jt.query("select * from EMP", (rs, rowNum) -> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));
		});
		return empList;
	}

	@Override
	public Emp findById(int empId) {
		Emp e = jt.queryForObject("select * from EMP where empno=" + empId, (rs, rowNum) -> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));
		});
		return e;
	}

}
