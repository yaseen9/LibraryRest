package com.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(value="/books", method= RequestMethod.GET)
	public List<Book> getBooksList() {
		return libraryService.getBooksList();
	}

	@RequestMapping(value="/books/{authorName}", method= RequestMethod.GET)
	public List<Book> getBookByAuthor(@PathVariable String authorName) {
		return libraryService.getBooksByAuthor(authorName);
	}

	@RequestMapping(value="/books/{authorName}/{titleName}", method= RequestMethod.GET)
	public List<Book> getBookByTitles(@PathVariable String authorName, @PathVariable String titleName) {
		return libraryService.getBooksByTitle(authorName, titleName);
	}

	@RequestMapping(value="/book", method= RequestMethod.POST)
	public void addBook(@RequestBody Book book) {
		libraryService.addBook(book);
	}

	
	
}
