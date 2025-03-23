package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.servicel.IDoctorService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {
		//service.showDoctorByIncomeRange(50000, 100000).forEach(System.out::println);
		
		//service.searchDoctorBySpecialization("Cardio", "physician").forEach(System.out::println);
		
		
		/*service.searchDoctoresDataByIncome(50000,100000).forEach(row->{
			for(Object obj:row) {
				System.out.println(obj+"  ");
			}
			System.out.println();
		});*/
		/*service.searchDoctoresDataByIncome(50000,100000).forEach(row->{
			System.out.println(Arrays.toString(row));
		});*/
		
		
		//service.searchAllDoctoresNameByIncomeRange(100000,1000000).forEach(System.out::println);
		
		/*Doctor doc=service.searchDoctorByNamedocName("kunu");
		System.out.println(doc);
		
		System.out.println("___________________________________________________________________");
		Object obj=service.searchDoctorDataByName("kunu");
		Object data[]=(Object[]) obj;		
		for(Object o:data) {
			System.out.println(o+"  ");
		}
		System.out.println();
		System.out.println("Result is :: "+Arrays.toString(data));
		
		
		System.out.println("___________________________________________________________________");
		String result=service.searchDoctorSpecializationByName("kunu");
		System.out.println("Specialization is :: "+result);*/
		
		
		System.out.println("unique doctor names count :: "+service.showDoctorNamesCount());
		System.out.println();
		Object[] result=(Object[]) service.showDAggregateData();
		System.out.println("records in count :: "+result[0]);
		System.out.println("Max income value :: "+result[1]);
		System.out.println("Min income value :: "+result[2]);
		System.out.println("avg of income :: "+result[3]);
		System.out.println("sum of income :: "+result[4]);
		
		
	}

}
