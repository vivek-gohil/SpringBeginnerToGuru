package com.borntocode.main.repositories;

import org.springframework.data.repository.CrudRepository;

import com.borntocode.main.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{

}
