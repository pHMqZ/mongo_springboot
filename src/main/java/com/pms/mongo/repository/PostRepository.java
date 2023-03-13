package com.pms.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.mongo.entity.Post;


public interface PostRepository extends MongoRepository<Post, String>{

}
