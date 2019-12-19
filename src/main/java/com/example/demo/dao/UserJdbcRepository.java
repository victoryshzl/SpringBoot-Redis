package com.example.demo.dao;

import javax.annotation.Resource;

import com.example.demo.bean.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
	@Resource
	private JdbcTemplate jdbcTemplate;
	public Employee selectUserByDepartNameAndAge(String dname, int age) {
		String sql="select s from Employee s where s.depart.departName=:departName and s.age<:age ";
		RowMapper<Employee>rowMapper=new BeanPropertyRowMapper<>(Employee.class);
		return jdbcTemplate.queryForObject(sql, new Object[] {dname,age},rowMapper);
	}

}
