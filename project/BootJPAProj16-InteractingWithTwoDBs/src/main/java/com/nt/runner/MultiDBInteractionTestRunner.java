package com.nt.runner;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.service.IProductMgmtService;

@Component
public class MultiDBInteractionTestRunner implements CommandLineRunner {

	@Autowired
	private IProductMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*List<Product>prodList=List.of(
				new Product("TV",55000.00,25,true,LocalDateTime.of(2090, 10,20,12,11,33)),
				new Product("chair",4000.00,20,true,LocalDateTime.of(2070, 11,11,12,11,33))
				);
		System.out.println(service.registerProducts(prodList));
		
		List<Offers>offersList=List.of(
				new Offers("winterSeasonSale", 33, LocalDateTime.now(),LocalDateTime.of(2023, 10,20,12,11,33)), 
		        new Offers("NewYearSpecialSale", 55,LocalDateTime.now(),LocalDateTime.of(2023, 9,20,12,11,33))
		        );
		System.out.println(service.registerOffers(offersList));*/
		
		System.out.println();
		service.showAllProducts().forEach(System.out::println);
		System.out.println();
		service.showAllOffers().forEach(System.out::println);
		System.out.println();
		
		
	}

}
