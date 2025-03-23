package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeManagementService {
	public List<Employee> showEmployeeBySalaryRange(double start,double end);
}
