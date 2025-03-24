package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj05LayeredAppApplicationMySQL {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj05LayeredAppApplicationMySQL.class, args);
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
