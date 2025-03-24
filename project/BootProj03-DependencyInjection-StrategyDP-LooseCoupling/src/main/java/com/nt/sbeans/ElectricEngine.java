package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("eEngine")
@Lazy
//@Primary
public final class ElectricEngine implements IEngine {
	
	public ElectricEngine() {
		System.out.println("ElectricEngine::0-param constructor");
	}
	@Override
	public void start() {
		System.out.println("ElectricEngine.start()");
		
	}
	@Override
	public void stop() {
		System.out.println("ElectricEngine.stop()");
		
	}
}
