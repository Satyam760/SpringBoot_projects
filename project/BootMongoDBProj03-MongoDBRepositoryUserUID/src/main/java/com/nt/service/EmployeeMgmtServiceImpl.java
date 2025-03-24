package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("EmpService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public String saveEmployee(Employee emp) {
		return "MongoDB Doc is saved with id value :: "+empRepo.insert(emp).getEno();
	}

	@Override
	public Optional<Employee> showEmployeeById(Integer id) {
		return empRepo.findById(id);
	}

	@Override
	public List<Employee> searchEmployeeBySalaryRange(double start, double end) {
		List<Employee>list= empRepo.findBySalaryBetween(start, end);
		return list;
	}

	@Override
	public Employee searchEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByEname(name);
	}

	
}
