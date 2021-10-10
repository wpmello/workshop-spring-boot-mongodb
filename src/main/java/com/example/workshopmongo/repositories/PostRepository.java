package com.example.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
