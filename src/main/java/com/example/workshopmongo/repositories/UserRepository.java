package com.example.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
