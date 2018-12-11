package com.learn.spring5webapp.bootstrap;

import com.learn.spring5webapp.model.Author;
import com.learn.spring5webapp.model.Book;
import com.learn.spring5webapp.model.Publisher;
import com.learn.spring5webapp.repositories.AuthorRepository;
import com.learn.spring5webapp.repositories.BookRepository;
import com.learn.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

//    @Autowired
//    public DevBootstrap(AuthorRepositoryFacade authorRepository, BookRepositoryFacade bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
//        Author shubh = authorRepository.create().with("Shubhanshu", "Kumar");
//        Book cleanCode = bookRepository.create().with("Clean Code", "54682", "POP");
//        shubh.getBooks().add(cleanCode);
//        cleanCode.getAuthors().add(shubh);
        Author shubh = new Author().with("Shubhanshu", "Kumar");
        Publisher pop = new Publisher().with("POP","GNoida");
        Book cleanCode = new Book().with("Clean Code", "585585", pop );
        shubh.getBooks().add(cleanCode);
        cleanCode.getAuthors().add(shubh);

        authorRepository.save(shubh);
        publisherRepository.save(pop);
        bookRepository.save(cleanCode);
    }
}
