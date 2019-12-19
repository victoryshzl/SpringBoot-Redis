package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends JpaRepository<Employee, String>,JpaSpecificationExecutor<Employee>{
	List<Employee>findUserByDepartNameAndAge(@Param("departName") String dname, @Param("age") int age);
	
	@Query("select e from Employee e where e.age=(select min(age) from e where e.depart.departName=?1)")
	Employee findEmployeeByDepartNameAndMinAge(String name);
	
		
		
}
