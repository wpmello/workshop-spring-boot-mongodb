package com.example.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	// ======= métodos de busca =======
	
	// busca simples com base no título dos posts ignorando letras maiúsculas ou minúsculas
	List<Post> findByTitleContainingIgnoreCase(String text);
}
