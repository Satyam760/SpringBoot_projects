package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.docoment.PlayerInfo;

public interface IPlayerInfoRepository extends MongoRepository<PlayerInfo, String> {

}
