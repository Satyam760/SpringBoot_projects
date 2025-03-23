package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;
import com.nt.view.ResultView;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Iterable<ResultView>it=doctorRepo.findBySpecializationIn(List.of("MD-Sprcial"));
		it.forEach(doc->{
			//head "doc" represent in InMomery Proxy class implementing ResultView(I)
			System.out.println(doc.getdocName()+" ... "+doc.getIncome());
		});

	}

}
