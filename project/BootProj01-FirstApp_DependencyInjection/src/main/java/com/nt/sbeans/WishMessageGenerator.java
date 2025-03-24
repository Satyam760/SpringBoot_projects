package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	@Autowired  //field injection
	private LocalDateTime ldt;  //has-a property
	
	//b.method
	public String generatorMessage(String user) {
		//get current hour of day
		int hour=ldt.getHour();
		//generator wish message
		if(hour<12) 
			return "Good Morning  "+user;
		else if(hour<16)
			return "Good Afternoon  "+user;
		else if(hour<20)
			return "Good Evening  "+user;
		else
			return "Good Night  "+user;
	}	
	
}
