package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {

	public String saveEmployee(Employee emp);
	public void saveAllEmployee(List<Employee>list);
	public List<Employee> showAllEmployee();
	public String showEmployeeById(String id);
	public List<Employee>showAllEmployees(boolean asc,String... properties);
	
}
