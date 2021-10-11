package com.example.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.repositories.PostRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
	
	public List<Post> fullsearch(String text, LocalDate minDate, LocalDate maxDate) {
		maxDate = maxDate.plusDays(1);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
