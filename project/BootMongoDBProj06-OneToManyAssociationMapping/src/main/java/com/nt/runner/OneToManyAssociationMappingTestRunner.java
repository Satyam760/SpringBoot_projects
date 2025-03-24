package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.docoment.Medal;
import com.nt.docoment.Player;
import com.nt.docoment.Sport;
import com.nt.service.ISportMgmtService;



@Component
public class OneToManyAssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private ISportMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*//child1 obj
		Sport sport1=new Sport(new Random().nextInt(100000), "cricket",new String[] {"bat","ball","stomp","bell"});
		Sport sport2=new Sport(new Random().nextInt(100000),"footBall",new String[] {"ball","dressCode","referry"});
		
		//child2 obj
		Medal medal1=new Medal("olympic-gold","gold","Tokyo-olympic","tokyo");
		Medal medal2=new Medal("cwg-silver","silver","cwg-japan","tokyo");
		
		//parent obj
		Player player=new Player(new Random().nextInt(100000), "satyam", "Arnapur",
				                 Set.of(sport1,sport2), 
				                 Map.of("medal1", medal1,"medal2",medal2));
		
		System.out.println(service.registerPlayerWithSportAndMedals(player));
		*/
		service.fetchAllPlayerInfo().forEach(per->{
			System.out.println("parent :: "+per);
			//access the sport child
			Set<Sport>sport=per.getSports();
			sport.forEach(sports->{
				System.out.println("sport :: "+sports);
			});
			
			//access the medals child
			Map<String, Medal>medals=per.getMedals();
			medals.forEach((type,medal)->{
				System.out.println("medal :: "+type +"...."+medal);
			});
		});
		
		
		
		
	}
		
}
