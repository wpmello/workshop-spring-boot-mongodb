package com.example.workshopmongo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	// ======= métodos de busca =======
	
	// busca simples com base no título dos posts ignorando letras maiúsculas ou minúsculas, mas agora com a 
	// especificidade do mongoDB
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	// busca simples com base no título dos posts ignorando letras maiúsculas ou minúsculas
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	// consulta com vários critérios onde busca um texto no título ou corpo ou nos comentários usando o padrão Json do mongoDB
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);
}
