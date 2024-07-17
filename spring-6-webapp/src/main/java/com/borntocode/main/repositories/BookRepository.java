package com.borntocode.main.repositories;

import org.springframework.data.repository.CrudRepository;

import com.borntocode.main.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
