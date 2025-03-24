package com.nt.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockDetails;
import com.nt.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private IStockMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("-------save document operation");
		StockDetails details=new StockDetails(new Random().nextInt(100000),"SBI",87788.8,"BSE");
		String result=service.registerStockDetails(details);
		System.out.println(result);*/
		
		
		/*StockDetails detail1=new StockDetails(new Random().nextInt(100000),"ICICI",88888.8,"BSE");
		StockDetails detail2=new StockDetails(new Random().nextInt(100000),"SBI",99999.9,"BSE");
		StockDetails detail3=new StockDetails(new Random().nextInt(100000),"Bajaj",77777.7,"BSE");
		StockDetails detail4=new StockDetails(new Random().nextInt(100000),"HDFC",66666.6,"BSE");
		String result=service.registerStockDetailBatch(List.of(detail1,detail2,detail3,detail4));
		System.out.println(result);
		*/
		
		/*service.fetchStockDetailsByPriceRange(1000.0,100000.0).forEach(System.out::println);
		System.out.println();
		service.fetchStockDetailsByExchange("BSE").forEach(System.out::println);
		*/
		
		//for modify or update
		System.out.println(service.fetchAndUpdateStockByStockId(45555,86674.0, "NFS"));
		
		
		
		
	}

}
