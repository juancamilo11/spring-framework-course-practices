package dev.j3c.practice.bootstrap;

import dev.j3c.practice.domain.Author;
import dev.j3c.practice.domain.Book;
import dev.j3c.practice.domain.Publisher;
import dev.j3c.practice.repositories.AuthorRepository;
import dev.j3c.practice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author juan = new Author("Juan Camilo", "Cardona");
        Author pedro = new Author("Pedro", "Marín");

        Book libro = new Book("Software Architecture", "35443456");
        Book libro2 = new Book("Domain Driven Design", "3243536");

        Publisher publisher = new Publisher("Publisher name", "Publisher Address", "New York", "EEUU", "055010");

        juan.getBooks().add(libro);
        libro.getAuthors().add(juan);
        juan.getBooks().add(libro2);
        pedro.getBooks().add(libro2);
        publisher.getBooks().add(libro);
        publisher.getBooks().add(libro2);


        this.authorRepository.save(juan);
        this.authorRepository.save(pedro);
        this.bookRepository.save(libro);
        this.bookRepository.save(libro2);

    }
}
