package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class BootProj09YmlAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj09YmlAppApplication.class, args);
		Customer cust = ctx.getBean("cust",Customer.class);
		System.out.println("Customer Info ::"+cust);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
