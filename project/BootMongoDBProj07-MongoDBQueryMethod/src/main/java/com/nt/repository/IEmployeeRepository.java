package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {
	//===============Projection Query================ 
	//@Query(fields = "{id:0,eaddrs:1,salary:1}",value = "{eaddrs:?0}")
	@Query(fields = "{ename:1,eaddrs:1,salary:1}",value = "{ename:?0}")
	public List<Object[]> getEmpDataByAddrs(String addrs);
	
	//===============Entity Query=====================
   //@Query(fields = "{}",value = "{eaddrs:?0}")
	@Query(value = "{eaddrs:?0}")
	public List<Employee> getEmpAllDataByAddrs(String addrs);
	
	@Query(fields = "{}",value = "{ename:?0,eaddrs:?1}")
	public List<Employee> getEmpAllDataByNameAndAddrs(String name,String addrs);
	
	@Query(fields = "{}",value = "{salary:{$gte:?0,$lte:?1}}")
	public List<Employee> getEmpAllDataBySalaryRange(Double start,Double end);
	
	@Query(fields = "{}",value = "{$or:[{eaddrs:?0},{eaddrs:?1}]}")
	public List<Employee> getEmpAllDataByAddresses(String add1,String add2);
	

	//options(i) for case insensitivity(like letter upper and lower)
	@Query(fields = "{}",value = "{ename:{'$regex':?0,'$options':i}}") 
	//@Query(fields = "{}",value = "{ename:{'$regex':?0}}")
	public List<Employee> getEmpAllDataByEnameChars(String naneChar);
	
	//attribute query
	//just simplify count the no.of salary between salary range
	@Query(fields = "{}",value = "{salary:{$gte:?0,$lte:?1}}",count = true)
	public int getEmpAllDataCountBySalaryRange(Double add1,Double add2);
	
	//sort attribute in quer paraml (1 for ascending order and -1 for descending order )
	@Query(value="{}",sort = "{ename:1}")
	//@Query(value="{}",sort = "{ename:-1}")
	public List<Employee> getEmpAllDataBySortName();
	
	
	
	
	
	
	
	
	
}
