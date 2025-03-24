package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.docoment.Sport;

public interface ISportRepository extends MongoRepository<Sport, Integer> {

}
