package com.acad.spring4Assignment4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate=jdbcTemplate;
	}

	
	public List<Employee> getAllEmployees()
	{
		return jdbcTemplate.query("Select * from Employee", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<Employee> employees=new ArrayList<Employee>();
				while (rs.next())
				{
					Employee emp=new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setSalary(rs.getInt(3));
					employees.add(emp);
		
				}
				return employees;
			}
		});
	}
}
