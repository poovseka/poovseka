package com.poovseka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poovseka.model.Books;
import com.poovseka.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		List<Books> booksList = new ArrayList<>();
		booksRepository.findAll().forEach(books -> booksList.add(books));
		return booksList;
	}

	public Books getBookById(int bookId) {
		return booksRepository.findById(bookId).get();
	}

	public void delete(int bookId) {
		booksRepository.deleteById(bookId);
	}

	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	public void update(Books books) {
		booksRepository.save(books);
	}

}
