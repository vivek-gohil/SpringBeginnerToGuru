package com.borntocode.main.services;

import org.springframework.stereotype.Service;

import com.borntocode.main.domain.Book;
import com.borntocode.main.repositories.BookRepository;

@Service
public class BookServiceImpl implements  BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public Iterable<Book> findAll() {
        return  bookRepository.findAll();
    }
}
