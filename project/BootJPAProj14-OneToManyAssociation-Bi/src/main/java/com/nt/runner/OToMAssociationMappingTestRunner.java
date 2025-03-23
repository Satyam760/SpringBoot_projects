package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOTMAssociationMgmtSevice;

@Component
public class OToMAssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IOTMAssociationMgmtSevice service;
	
	@Override
	public void run(String... args) throws Exception {
		//service.saveDataUsingParent();
		//service.saveDataUsingChild();
		service.loadDataUsingParent();

		
		
	}

}
