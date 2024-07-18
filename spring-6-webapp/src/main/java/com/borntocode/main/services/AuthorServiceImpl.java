package com.borntocode.main.services;

import org.springframework.stereotype.Service;

import com.borntocode.main.domain.Author;
import com.borntocode.main.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements  AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

}
