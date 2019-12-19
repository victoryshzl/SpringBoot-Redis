package com.example.demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_depart")
public class Depart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departNo;
	private String departName;
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Employee.class,mappedBy="depart")
	private Set<Employee>employees=new HashSet<>();
	
	public Depart() {}
	public Depart(String s,Set<Employee> es) {
		departName=s;
		employees=es;
	}
	public int getDepartNo() {
		return departNo;
	}
	
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String s) {
		departName=s;
	}
	public Set<Employee>getEmplotees(){
		return employees;
	}
	public void setEmployees(Set<Employee> es) {
		employees=es;
	}
		
}
