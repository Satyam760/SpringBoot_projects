package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo custRepo;
	
	@Override
	public String registerCustomer(Customer cust) {
		int idVal=custRepo.save(cust).getCustId();
		return "Customer is saved with id Val :: "+idVal;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

}
