package com.nt;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01FirstAppDependencyInjectionApplication {

	@Bean(name="ldt")
	LocalDateTime createLDT() {
		return LocalDateTime.now();
	}
	
	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj01FirstAppDependencyInjectionApplication.class, args);
		//get target class spring bean class obj
		WishMessageGenerator generator= ctx.getBean("wmg",WishMessageGenerator.class);
		
		Scanner scn =new Scanner(System.in);
		System.out.println("Enter your name::");
		String name=scn.nextLine();
		
		//invoke the b.method
		String result=generator.generatorMessage(name);
		System.out.println("Wish Message is::"+result);
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		scn.close();
	}//main
}//class
