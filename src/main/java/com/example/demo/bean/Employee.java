package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_employee")
@NamedQuery(name="Employee.findUserByDepartNameAndAge",
	query="select s from Employee s where s.depart.departName=:departName and s.age<:age")


public class Employee implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	
	
	private int id;
	private String name;
	private int age;
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Depart.class)
	@JoinColumn(name="departId",referencedColumnName="departNo")
	private Depart depart;
	public Employee() {super();}
	public Employee(String s,int i,Depart d) {
		super();
		name=s;
		age=i;
		depart=d;
	}
	
	public Employee(int id2, String name2, int age2) {
		id2=id2;name2=name2;age2=age2;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;		
	}
	public void setName(String s) {
		name=s;
	}
	public int getAge() {
		return age;
	}
	
}
