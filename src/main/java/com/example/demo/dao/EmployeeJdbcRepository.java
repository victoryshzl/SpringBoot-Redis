package com.example.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.bean.Depart;
import com.example.demo.bean.Employee;
import com.example.demo.bean.Employee1;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeJdbcRepository {
	@Resource
	private JdbcTemplate jdbcTemplate;

	// JdbcTemplate
	public List<Employee1> selectEmployeeByDepartNameAndAge(String dname, int age) {
		String sql = "SELECT * FROM tb_employee,tb_depart WHERE tb_employee.depart_id = tb_depart.depart_no AND tb_depart.depart_name = ? AND tb_employee.age < ?";
		RowMapper<Employee1> rowMapper = new BeanPropertyRowMapper<>(Employee1.class);
		return jdbcTemplate.query(sql, new Object[] { dname, age }, rowMapper);
	}

	//Redis
	public List<Employee> findEmployees(String dname) {
		String sql="select * from tb_employee,tb_depart where tb_employee.depart_id=tb_depart.depart_no  and depart_name ='"+dname+"'   order by age limit 1  ";
		RowMapper<Employee> rowMapper= new BeanPropertyRowMapper<Employee>(Employee.class);
	
		return jdbcTemplate.query(sql, rowMapper);
		
		
	}
	
	public List<Depart> findEmployeess(String dname) {
		String sql="select * from tb_employee,tb_depart where tb_employee.depart_id=tb_depart.depart_no  and depart_name ='"+dname+"'   order by age limit 1  ";
		RowMapper<Depart> rowMapper= new BeanPropertyRowMapper<Depart>(Depart.class);
	
		
		
		return jdbcTemplate.query(sql, rowMapper);
		
		
	}

	//
	public Employee selectMinAgeEmployee(String dname) {
		String sql = "select id,name,min(age)as age from tb_employee "
				+ "where depart_id=?";
		Object[] arg=new Object[]{dname};
		RowMapper<Employee>rowMapper = new BeanPropertyRowMapper<>(
				Employee.class);
		return jdbcTemplate.queryForObject(sql, arg, rowMapper);
	}
	

}
