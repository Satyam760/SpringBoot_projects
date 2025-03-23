package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	public Employee() {
		System.out.println("Employee:0-param constructor ::+p"+this.getClass());
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;
	private Integer deptno;
	
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", deptno=" + deptno + ", salary="
				+ salary + "]";
	}
	
}
