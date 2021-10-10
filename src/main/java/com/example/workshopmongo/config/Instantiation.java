package com.example.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.repositories.PostRepository;
import com.example.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		// '.deleteAll()' -> deleta todos os objetos no banco de dados
		userRepository.deleteAll();
		postRepository.deleteAll();;
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, LocalDate.parse("2021-03-21"), "Partiu viagem", "Vou viajar para o Rio. Abraços", maria);
		Post post2 = new Post(null, LocalDate.parse("2021-03-23"), "Bom dia", "Acordei feliz hoje", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
