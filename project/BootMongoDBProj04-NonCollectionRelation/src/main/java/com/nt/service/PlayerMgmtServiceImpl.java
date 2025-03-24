package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.docoment.PlayerInfo;
import com.nt.repository.IPlayerInfoRepository;

@Service("playerService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {

	@Autowired
	private IPlayerInfoRepository playerRepo;
	
	@Override
	public String registerPlayerInfo(PlayerInfo info) {
		return "Player is saved with Id value :: "+ playerRepo.insert(info).getId();
	}

	@Override
	public List<PlayerInfo> showAllPlayerDoc() {
		return playerRepo.findAll();
	}

}
