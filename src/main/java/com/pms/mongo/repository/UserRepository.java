package com.pms.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.mongo.entity.User;


public interface UserRepository extends MongoRepository<User, String> {

}
