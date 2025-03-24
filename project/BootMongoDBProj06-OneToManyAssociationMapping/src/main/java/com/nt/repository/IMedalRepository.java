package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.docoment.Medal;

public interface IMedalRepository extends MongoRepository<Medal, String> {

}
