package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO-mysql")
public class EmployeeDAOImpl_mySQL implements IEmployeeDAO{
	private static final String GET_EMPS_BY_DESGS=
			   "SELECT ENO,ENAME,DESG,SALARY,DEPTNO FROM EMPLOYEE_INFO WHERE DESG IN(?,?,?) ORDER BY DESG";
	
	@Autowired
	private DataSource ds;
	
    @Override
    public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
    	System.out.println("EmployeeDAOImpl.getEmployeeByDesgs()::ds class name::"+ds.getClass());
    	
    	List<Employee> list=null;
    	//get pooled jdbc con obj
    	try(Connection con=ds.getConnection();
    		PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);
    		){
    		//set value to query param
    		ps.setString(1, desg1);
    		ps.setString(2, desg2);
    		ps.setString(3, desg3);
    		
    		//execute the query
    		try(ResultSet rs=ps.executeQuery()){
    			//copy the records of  ResultSet obj to List<Employee> obj
    			list=new ArrayList();
    			while(rs.next()) {
    				//copy each records of rs to Employee obj
    				Employee emp=new Employee();
    				emp.setEno(rs.getInt(1));
    				emp.setEname(rs.getString(2));
    				emp.setDesg(rs.getString(3));
    				emp.setSalary(rs.getDouble(4));
    				emp.setDeptno(rs.getInt(5));
    				
    				//add Employee obj to list collection
    				list.add(emp);
    			}//while
    			
    		}//try2
    		
    	}//try1
    	catch(Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    	return list;
    	
    }//method
    
}//class