package com.library.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
	
	private List<Book> books =  new ArrayList<Book>(Arrays.asList(
					new Book("ENGLISH", "JACK"),
					new Book("SPANISH", "JANE"),
					new Book("HINDI", "JAMES"),
					new Book("URDU", "JAMES"),
					new Book("TELUGU", "JOSEPH"),
					new Book("TELEBOOK", "JOSEPH")
					));
	
	public List<Book> getBooksList() {
		return books;
	}


	public List<Book> getBooksByAuthor(String authorName) {
		return books
				.stream()
				.filter(book -> book.getAuthor().equals(authorName.toUpperCase()))
				.collect(Collectors.toList());
	
	}

	
	public List<Book> getBooksByTitle(String authorName, String title) {
		return books
				.stream()
				 .filter(b -> {
					 	if (b.author.equals(authorName.toUpperCase()) && b.getTitle().contains(title.toUpperCase())) {
					 		return true;
					 	}
					 	return false;
	                })				
				.collect(Collectors.toList());
	}

	public void addBook(Book book) {
		books.add(book);
	}
	
}


