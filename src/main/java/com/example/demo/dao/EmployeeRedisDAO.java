package com.example.demo.dao;

import javax.annotation.Resource;

import com.example.demo.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRedisDAO {
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valueOperations;
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valueOperations2;
	
	
	public void insertUserByRedis(String dname, Employee employee) {
				
		       valueOperations2.set(dname, employee);
		       
		
		       
		       
	}
	
//	public void insertUserByRediss(Depart employee) {
//		
//	       valueOperations2.set(employee.getDepartName(), employee);
//	       
//	
//	       
//	       
//}
	public Employee getUserByRedis(String dname) {
		
	     return (Employee)valueOperations2.get(dname);
	       
	}
//	public Depart getUserByRediss(		String dname) {
//		
//	     return   (Depart)valueOperations2.get(dname);
//	       
//	}
	
	public void insertUserByRedis(Employee employee) {
		valueOperations2.set(employee.getId(), employee);
	}
	
	public Employee findUserByRedis(int id) {
		return (Employee)valueOperations2.get(id);
	}
    
	
	///
	public void setEmployee(Employee employee) {
		valueOperations2.set("db0",employee);
	}
	public Employee findEmployeeByRedis() {
		return (Employee) valueOperations2.get("db0");
	}


}
