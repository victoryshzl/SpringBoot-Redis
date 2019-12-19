package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> ,JpaSpecificationExecutor<Employee>{
//	List<Employee>findEmployeeByDepartnameAndAge(String dname,int age);
//	
//	@Query("select s from Example s where s.age=(select min(s.age) from s where s.depart.departName=?1)")
//	Employee findEmployeeByDepartNameandMinage(String name);
}
