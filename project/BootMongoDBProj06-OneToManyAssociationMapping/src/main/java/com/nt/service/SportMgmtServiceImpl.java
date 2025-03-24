package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.docoment.Player;
import com.nt.repository.IMedalRepository;
import com.nt.repository.IPlayerRepository;
import com.nt.repository.ISportRepository;

@Service("sportService")
public class SportMgmtServiceImpl implements ISportMgmtService {
	
	@Autowired
	private ISportRepository sportRepo;
	@Autowired
	private IMedalRepository medalRepo;
	@Autowired
	private IPlayerRepository playerRepo;
	
	@Override
	public String registerPlayerWithSportAndMedals(Player player) {
		return "Player with Sports and Medals Info is saved with "+playerRepo.save(player).getPid()+" Id value";
	}

	@Override
	public List<Player> fetchAllPlayerInfo() {
		return playerRepo.findAll();
	}

}
