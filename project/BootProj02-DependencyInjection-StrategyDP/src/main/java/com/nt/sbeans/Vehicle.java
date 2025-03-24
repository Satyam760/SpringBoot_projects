package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	//has-a property
	@Autowired
	@Qualifier("dEngine")
	private IEngine engine;
	
	public Vehicle() {
		System.out.println("Vehicle::0-param constructor");
	}
	
	public void move(String start,String stop) {
		engine .start();
		System.out.println("Journy start from  :: "+start);
		System.out.println("Journy is going on........");
		engine.stop();
		System.out.println("Journy  end from :: "+stop);
	}
	
}
