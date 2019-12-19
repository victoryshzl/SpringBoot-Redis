package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Employee1;
import com.example.demo.bean.User;
import com.example.demo.dao.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Resource
	private UserRepository userRespository;
	@Resource 
	private UserPSRepository userPSRepository;
	@Resource
	private UserJpaRepository userJpaRepository;
	@Resource
	private UserJdbcRepository userJdbcRepository;
	@Resource
	private EmployeeRepository employeeRepository;
	@Resource
	private DepartRepository departRepository;
	@Resource
	private EmployeeJdbcRepository employeeJdbcRepository;
	@Resource
	private EmployeeRedisDAO employeeRedisDAO;
	@Resource
	private EmployeeJpaRepository employeeJpaRepository;
	@Resource
	private UserRedisDao userRedisDao;
	
	@Transactional
	public User save(User user) {
		return userRespository.save(user);
	}
	public User findById(String id) {
		return userRespository.findById(id).get();
	}
	public Iterable<User>finaAllSort(Sort sort){
		return userPSRepository.findAll(sort);
	}

	@Transactional
	public List<Map<String, Object>>getEmployeeByDepartName(String dname){
		List<Employee> es=employeeRepository.findByDepart_departName(dname);
		List<Map<String, Object>>results=new ArrayList<>();
		for(Employee e:es) {
			Map<String, Object> m=new HashMap<>();
			m.put("id", e.getId());
			m.put("name", e.getName());
			m.put("age", e.getAge());
			results.add(m);
		}
		return results;
	}
	
	public List<Map<String, Object>> getIdAndNameBydepartNameAndAge(String dname,int age){
		List<Employee> es=employeeRepository.findIdAndNameByDepartNameAndAge(dname, age);
		List<Map<String, Object>>results=new ArrayList<>();
		for(Employee e:es) {
			Map<String, Object> m=new HashMap<>();
			m.put("id", e.getId());
			m.put("name", e.getName());
			m.put("age", e.getAge());
			results.add(m);
		}
		return results;
	}
	
	public String getDepartNameByEmployeeName(String employeeName) {
		return employeeRepository.findDepartNameByEmployeeName(employeeName);	}

	@Transactional
	public int deleteEmployeeByEmployeeName(String employeeName) {
		return employeeRepository.deleteEmployeeByEmployeeName(employeeName);
	}

	//使用@NamedQuery方式
	@Transactional
	public List<Map<String, Object>> getUserByDepartNameAndAge(String dname,int age){
		List<Employee> es=userJpaRepository.findUserByDepartNameAndAge(dname, age);
		List<Map<String, Object>>results=new ArrayList<>();
		for(Employee e:es) {
			Map<String, Object> m=new HashMap<>();
			m.put("id", e.getId());
			m.put("name", e.getName());
			m.put("age", e.getAge());
			results.add(m);
		}
		return results;
	}

	//Criteria对象Specification 
	@SuppressWarnings("serial")
	public List<Employee> getIdAndNameByDepartNameAndAgeLikeSpecifition(String dname,int age){
		List<Employee>employees=employeeRepository.findAll(new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate p1=criteriaBuilder.equal(root.get("depart").get("departName"),dname);
				Predicate p2=criteriaBuilder.lt(root.get("age"), age);
				Predicate pl=criteriaBuilder.and(p1,p2);
				return p1;
			}
		});
		return employees;
	}

	//使用JdbcTemplate
	public List<Employee1> selectEmployee(String dname, int age) {
		return employeeJdbcRepository.selectEmployeeByDepartNameAndAge
				(dname, age);
	}

	//Redis
	public int  insert(String dnames,String dname) {
		employeeRedisDAO.insertUserByRedis(dnames,employeeJdbcRepository.findEmployees(dname).get(0));
		return 1;
	}

	public Employee get(String dname) {
		return employeeRedisDAO.getUserByRedis(dname);
	}

	public void insertUserByRedis(Employee employee) {
		employeeRedisDAO.insertUserByRedis(employee);
		
	}
	public Employee findUserByRedis(int id) {
		return employeeRedisDAO.findUserByRedis(id);
	}

	public Employee selectMinAgeEmployee(String dname) {
		Employee employee = employeeJdbcRepository.selectMinAgeEmployee(dname);
		employeeRedisDAO.setEmployee(employee);
		Employee employeeRedis = employeeRedisDAO.findEmployeeByRedis();
		return employeeRedis;
	}

	public String getStrByRedis(){
		userRedisDao.stringRedisTemplateDemo();
		return userRedisDao.getStringByRedis();
	}

	public void insertUserByRedis(User user){
		userRedisDao.insertUserByRedis(user);
	}

	public User findUserByRedis(String uid){
		return userRedisDao.findUserByRedis(uid);
	}
}
