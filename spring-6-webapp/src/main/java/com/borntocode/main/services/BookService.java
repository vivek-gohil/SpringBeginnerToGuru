package com.borntocode.main.services;

import com.borntocode.main.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
