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
		return "MongoDB Doc is saved with id value :: "+empRepo.insert(emp).getId();
	}

	@Override
	public void saveAllEmployee(List<Employee> list) {
		empRepo.saveAll(list);
		
	}

	@Override
	public List<Employee> showAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public String showEmployeeById(String id) {
		Optional<Employee>opt=empRepo.findById(id);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			return "Employee data :: "+emp;
		}
		else {
			return id+" :: Id not found";
		}
	}

	@Override
	public List<Employee> showAllEmployees(boolean asc, String... properties) {
		//create the short obj
		Sort sort= Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		//get the doc by sorting
		List<Employee>list=empRepo.findAll(sort);
		return list;
	}

}
