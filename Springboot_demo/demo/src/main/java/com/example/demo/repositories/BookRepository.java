package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Books;

public interface BookRepository extends CrudRepository<Books, Long> {

}
