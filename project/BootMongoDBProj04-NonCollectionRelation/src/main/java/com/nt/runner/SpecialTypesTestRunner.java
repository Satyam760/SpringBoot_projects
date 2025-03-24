package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.docoment.PlayerInfo;
import com.nt.service.IPlayerMgmtService;

@Component
public class SpecialTypesTestRunner implements CommandLineRunner {

	@Autowired
	private IPlayerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*PlayerInfo info=new PlayerInfo();
		info.setPname("satyam");
		info.setPaddrs("hyd");
		info.setContactNumber(Set.of(99999999l,888888888l,7777777777l,6666666666l));
		info.setFriends(new String[] {"dhoni","rahul","ram","hari"});
		info.setImpKnocks(Map.of("asiaCup","35runs","2019 world cup final","56+runs"));
		info.setNickNames(List.of("sahoo","sahu","dhoni"));
		Properties per =new Properties();
		per.put("aadhar","926038146595");
		per.put("votor","fs603814df5");
		per.put("pan","9gd0381jsh95");
		info.setIdDetails(per);
		
		System.out.println(service.registerPlayerInfo(info));
		*/
		
		service.showAllPlayerDoc().forEach(System.out::println);
		

	}

}
