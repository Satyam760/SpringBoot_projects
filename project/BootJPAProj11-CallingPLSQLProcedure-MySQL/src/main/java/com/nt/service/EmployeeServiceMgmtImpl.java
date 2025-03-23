package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `P_EMP_DETAILS_BY_SALARY_RANGE`(IN startSalary float,IN endSalary float)
BEGIN
  select * from employee_info where salary>=startSalary and salary<=endSalary;
END
*/

@Service("employeeService")
public class EmployeeServiceMgmtImpl implements IEmployeeManagementService {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Employee> showEmployeeBySalaryRange(double start, double end) {
		//create stored procedure query obj pointig PL/SQL procedure
		StoredProcedureQuery query=
				 manager.createStoredProcedureQuery("P_EMP_DETAILS_BY_SALARY_RANGE",Employee.class);
		
		//register bote in/out params by specifying their mode
		query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
		
		//set values to IN param 
		query.setParameter(1,start);
		query.setParameter(2,end);
		//call PL/SQL procedure 
		List<Employee> list=query.getResultList();
		
		return list;
	}

}
