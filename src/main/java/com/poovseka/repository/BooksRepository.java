package com.poovseka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poovseka.model.Books;


public interface BooksRepository extends CrudRepository<Books, Integer> {

}
