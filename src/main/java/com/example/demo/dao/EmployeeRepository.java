package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository
 <Employee, Integer>,JpaSpecificationExecutor<Employee> {
	List<Employee>findByDepart_departName(String name);
	
	@Query("select s from Employee s where s.depart.departName=?1")
	List<Employee>findEmployeesByDepartName(String dname);
	
	@Query("select s from Employee s where s.depart.departName=:departName and s.age<:age")
	List<Employee>findIdAndNameByDepartNameAndAge(@Param("departName") String dname, @Param("age") int age);
	
	@Query("select d.departName from Depart d inner join d.employees s where s.name=?1")
	String findDepartNameByEmployeeName(String employeeName);
	
	@Modifying
	@Query("delete from Employee s where s.name=?1")
	int deleteEmployeeByEmployeeName(String employeeName);
	
	
	//通过NamedQuery方式
	List<Employee>findUserByDepartNameAndAge(@Param("departName") String dname, @Param("age") int age);

	//基于Criteria对象Specification 
	@Query("select e from Employee e where e.age=(select min(age) from e where e.depart.departName=?1)")
	List<Employee> findEmployeeByDepartNameAndMinAgeLike(String dname, int age);
	
	
	

//	List<Employee>findIdAndNameByDepartNameAndAgeToJt(String dname, int age);
}
