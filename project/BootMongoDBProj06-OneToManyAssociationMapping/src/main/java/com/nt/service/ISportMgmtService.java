package com.nt.service;

import java.util.List;

import com.nt.docoment.Player;

public interface ISportMgmtService {
	
	public String registerPlayerWithSportAndMedals(Player player);
	
	public List<Player> fetchAllPlayerInfo();
	
}
