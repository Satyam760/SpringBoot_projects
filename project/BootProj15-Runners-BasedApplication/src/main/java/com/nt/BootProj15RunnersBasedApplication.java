package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj15RunnersBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProj15RunnersBasedApplication.class, args);
	}

}
