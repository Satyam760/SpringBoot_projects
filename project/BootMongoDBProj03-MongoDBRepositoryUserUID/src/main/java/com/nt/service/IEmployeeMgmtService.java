package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {

	public String saveEmployee(Employee emp);
	public Optional<Employee>showEmployeeById(Integer id);
	
	public List<Employee>searchEmployeeBySalaryRange(double start,double end);
	public Employee searchEmployeeByName(String name);
	
}
