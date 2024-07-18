package com.borntocode.main.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.borntocode.main.domain.Author;
import com.borntocode.main.domain.Book;
import com.borntocode.main.domain.Publisher;
import com.borntocode.main.repositories.AuthorRepository;
import com.borntocode.main.repositories.BookRepository;
import com.borntocode.main.repositories.PublisherRepository;

@Component
public class BootstrapData implements  CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        savedAuthor.getBooks().add(savedBook);
        savedAuthorTwo.getBooks().add(savedBookTwo);
        savedBook.getAuthors().add(savedAuthor);
        savedBookTwo.getAuthors().add(savedAuthorTwo);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Panguin");
        publisher.setAddress("India");
        Publisher savedPublisher = publisherRepository.save(publisher);

        savedBook.setPublisher(savedPublisher);
        savedBookTwo.setPublisher(savedPublisher);

        authorRepository.save(savedAuthor);
        authorRepository.save(savedAuthorTwo);

        bookRepository.save(savedBook);
        bookRepository.save(savedBookTwo);

        System.out.println("In Bookstrap");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Book Count : " + bookRepository.count());

        

        System.out.println("Publisher Count : " + publisherRepository.count());

        
    }

}
