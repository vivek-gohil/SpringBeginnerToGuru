package com.borntocode.main.services;

import com.borntocode.main.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
