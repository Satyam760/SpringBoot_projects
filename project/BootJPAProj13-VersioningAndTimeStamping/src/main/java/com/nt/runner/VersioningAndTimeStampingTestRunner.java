package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICallerTuneInfoRepository;
import com.nt.service.ICallerTuneMgmtService;

@Component
public class VersioningAndTimeStampingTestRunner implements CommandLineRunner {

	@Autowired
	ICallerTuneMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			CallerTuneInfo info=new CallerTuneInfo("joome jo pathan","pathan");
			System.out.println(service.saveCallerTuneInfo(info));
			CallerTuneInfo info1=new CallerTuneInfo(" sanam Re","Sanam");
			System.out.println(service.saveCallerTuneInfo(info1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(service.updateTuneInfoById(1,"oo antava mama","puspa"));
			System.out.println(service.showCallerTuneDetailsById(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("________________________________________________________________");
		try {
			System.out.println(service.updateTuneInfoById(3,"Rama Rama","BolBachan"));
			System.out.println(service.showCallerTuneDetailsById(3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
