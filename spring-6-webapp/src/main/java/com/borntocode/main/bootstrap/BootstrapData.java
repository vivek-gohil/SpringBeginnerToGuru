package com.borntocode.main.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.borntocode.main.domain.Author;
import com.borntocode.main.domain.Book;
import com.borntocode.main.repositories.AuthorRepository;
import com.borntocode.main.repositories.BookRepository;

@Component
public class BootstrapData implements  CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Eric");
        author.setLastName("Evans");

        Book book = new Book();
        book.setTitle("Domain Driven Design");
        book.setIsbn("123456");

        Author savedAuthor = authorRepository.save(author);
        Book savedBook = bookRepository.save(book);

        Author authorTwo = new Author();
        authorTwo.setFirstName("Vivek");
        authorTwo.setLastName("Gohil");

        Book bookTwo = new Book();
        bookTwo.setTitle("Java Programming Language");
        bookTwo.setIsbn("54321");

        Author savedAuthorTwo = authorRepository.save(authorTwo);
        Book savedBookTwo = bookRepository.save(bookTwo);

        author.getBooks().add(savedBook);
        authorTwo.getBooks().add(savedBookTwo);

        authorRepository.save(savedAuthor);
        authorRepository.save(savedAuthorTwo);

        System.out.println("In Bookstrap");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Book Count : " + bookRepository.count());
        
    }

}
