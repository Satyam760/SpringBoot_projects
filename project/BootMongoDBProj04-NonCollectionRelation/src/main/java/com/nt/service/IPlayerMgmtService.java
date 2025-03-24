package com.nt.service;

import java.util.List;

import com.nt.docoment.PlayerInfo;

public interface IPlayerMgmtService {
	public String registerPlayerInfo(PlayerInfo info);
	public List<PlayerInfo> showAllPlayerDoc();
	
}
