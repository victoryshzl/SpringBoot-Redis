package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Employee1;
import com.example.demo.bean.User;
import com.example.demo.dao.EmployeeRedisDAO;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	@Resource
	private EmployeeRedisDAO employeeRedisDAO;

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String hello() {
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String doSave(@ModelAttribute User user, HttpSession session) {
		user.setUsername(user.getUsername().toUpperCase());
		session.setAttribute("user", user);
		userService.save(user);
		return "r";		
	}
	
	
	@RequestMapping(value="/find")
	public String findById(@RequestParam(value="uid",required=true)
	String uid,HttpSession session) {
	User user=userService.findById(uid);
	session.setAttribute("user", user);
	return "s";
	
	}

	@RequestMapping(value="/getDepartEmployee")
	public String getDepartEmployee(String dname,HttpSession session) {
		List<Map<String, Object>>em=userService.getEmployeeByDepartName(dname);
		session.setAttribute("employees", em);
		System.out.println(em);
		return "employee";
	}
	
	@RequestMapping(value="/getIDAndNameByDepartNameAndAge")
	public String getIDAndNameByDepartNameAndAge(String dname,int age,HttpSession session) {
		List<Map<String, Object>>em=userService.getIdAndNameBydepartNameAndAge(dname, age);
		session.setAttribute("employee", em);
		//System.out.println(em);
		return "employee";
	}
	
	
	@RequestMapping(value="/getDepartNameByEmployeeName")
	public String getDepartNameByEmployeeName(String employeeName,HttpSession session) {
		String em=userService.getDepartNameByEmployeeName(employeeName);
		session.setAttribute("depart", em);
		return "d";
	}
	
	
	@RequestMapping(value="/deleteEmployeeByEmployeeName")
	public String deleteEmployeeByEmployeeName(String employeeName) {
		int val=userService.deleteEmployeeByEmployeeName(employeeName);
		System.out.println(val);
		return "delete";
	}
	
	//@NamedQuery方式
		@RequestMapping(value="/getUserByDepartNameAndAge")
		public String getUserByDepartNameAndAge(String dname,int age,HttpSession session) {
			List<Map<String, Object>>em=userService.getUserByDepartNameAndAge(dname, age);
			session.setAttribute("employee", em);
			//System.out.println(em);
			return "employee";
		}
		
		
	//Criteria对象Specification 
		@RequestMapping(value="/getIdAndNameByDepartNameAndAgeLikeSpecifition")
		public String getIdAndNameByDepartNameAndAgeToJS(String dname,int age,HttpSession session) {
			List<Employee>em=userService.getIdAndNameByDepartNameAndAgeLikeSpecifition(dname, age);
			session.setAttribute("employee", em);
			return "employee";
		}
	
		//使用JdbcTemplate
		@RequestMapping(value="/selectEmployee")
		public String selectEmployee(String dname,int age,HttpSession session) {
			List<Employee1> employee=userService.selectEmployee(dname, age);
			session.setAttribute("employee", employee);			
			return "employee";
		}
		
		@RequestMapping(value="/redis")
		public String redisUser(String dname,HttpSession session) {
			userService.insert(dname,dname);
			return "insert";
		}

		@RequestMapping(value="/rediss")
		public String redisUsers(String dname,HttpSession session) {
			Employee employee=userService.get(dname);
			session.setAttribute("employees", employee);;
			return "employee2";
		}

		
		//新
		@RequestMapping(value="/insertUserByRedis")
		public String insertUserByRedis(int id,String name,int age) {
			Employee employee=new Employee(id,name,age);
			userService.insertUserByRedis(employee);
			return "insert";
		}
		
		@RequestMapping(value="/findUserByRedis")
		public String selectUserByRedis(int id,HttpSession session) {
			Employee employee=userService.findUserByRedis(id);
			session.setAttribute("employee", employee);
			return "s";
		}
		
		
		@RequestMapping(value="/selectMinAgeEmployee")
		public String  selectMinAgeEmployee(@RequestParam String dname,
				HttpSession session) {
			Employee em = userService.selectMinAgeEmployee(dname);
			session.setAttribute("employees", em);
			return "employee";
		}
		
		@RequestMapping(value = "/getStringByRedis")
		public String getStringByRedis(HttpSession session){
			String s=userService.getStrByRedis();
			session.setAttribute("redis",s);
			return "redis";
		}

		@RequestMapping(value = "/insertUserByRedis")
		public String insertUserByRedis(String uid,String username,String password){
			User user=new User(uid,username,password);
			userService.insertUserByRedis(user);
			return "insert";
		}

		@RequestMapping(value = "/findUserByRedis")
		public String selectUserByRedis(String uid,HttpSession session){
			User user=userService.findUserByRedis(uid);
			session.setAttribute("user",user);
			return "s";
		}
}
