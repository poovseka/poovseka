package com.poovseka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poovseka.model.Books;
import com.poovseka.service.BooksService;

@RestController
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable("name") String name){
		return "welcome"+" "+name;
	}
	@GetMapping("/books")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/books/{bookId}")
	private Books getBook(@PathVariable("bookId") int bookId) {
		return booksService.getBookById(bookId);
	}

	@DeleteMapping("/book/{bookId}")
	private void delete(@PathVariable("bookId") int bookId) {
		booksService.delete(bookId);
	}

	@PostMapping("/books")
	private int saveBooks(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookId();
	}

	@PutMapping("/books/{bookId}")
	private Books update(@RequestBody Books books, @PathVariable("bookId") int bookId) {
		books.setBookId(bookId);
		booksService.update(books);
		return books;
	}

}
