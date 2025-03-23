package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("________________________________________________");
		Iterable<ResultView1>it1=doctorRepo.findByIncomeBetween(100,2000000, ResultView1.class);
		it1.forEach(data->{
			System.out.println(data.getdocName()+"   "+data.getIncome());
		});
		
		System.out.println();
		
		System.out.println("________________________________________________");
		Iterable<ResultView2>it2=doctorRepo.findByIncomeBetween(100,2000000, ResultView2.class);
		it2.forEach(data->{
			System.out.println(data.getdocName()+"   "+data.getIncome()+"    "+data.getSpecialization());
		});
		
		
	}

}
