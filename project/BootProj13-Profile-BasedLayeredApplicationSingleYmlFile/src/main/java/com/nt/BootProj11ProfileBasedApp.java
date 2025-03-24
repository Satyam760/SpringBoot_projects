package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj11ProfileBasedApp {
	
	@Autowired
	private Environment env;
	
	@Bean(name="c3P0Ds")
	@Profile("test")
	public ComboPooledDataSource createC3P0Ds()throws Exception {
		System.out.println("BootProj11ProfileBasedApp.createC3P0Ds()");
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));
		
		cds.setMinPoolSize(Integer.parseInt(env.getProperty("c3P0.minSize")));
		cds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3P0.maxSize")));
		
		return cds;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj11ProfileBasedApp.class, args);
	    //get Controller class obj ref
		PayrollOperationController controller= ctx.getBean("payroll",PayrollOperationController.class);
		
		//invoke the b.method
		try {
			List<Employee> list=controller.showEmployeeByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Intenal problem --try again ::"+e.getMessage());
		}
		((ConfigurableApplicationContext) ctx).close();
	
	}

}
