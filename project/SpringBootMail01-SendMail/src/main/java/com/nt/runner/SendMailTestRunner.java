package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPurchaseOrder;

@Component
public class SendMailTestRunner implements CommandLineRunner {

	@Autowired
	private IPurchaseOrder order;
	
	@Override
	public void run(String... args) throws Exception {
		String msg=order.purchase(new String[] {"shirt","trouser","watch"},
				                  new double[] {50000,60000,70000},
				                  new String[] {"sahoosatyam12345@gmail.com","sahookunu1234@gmail.com"});

		System.out.println(msg);
		
		
	}

}
