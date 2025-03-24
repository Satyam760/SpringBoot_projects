package com.nt.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner1 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Non option args value::"+args.getNonOptionArgs());
		
		System.out.println("Option args value::");
		for(String name:args.getOptionNames()) {
			System.out.println(name+"---->"+args.getOptionValues(name));
		}
		
	}

}
