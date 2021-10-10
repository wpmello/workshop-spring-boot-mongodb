package com.example.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

// == foi decidido que o 'Comment' seria um DTO por ser uma classe muito simples e não ter necessidade de ser tratada como uma entidade

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private LocalDate date;

	private AuthorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String text, LocalDate date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
