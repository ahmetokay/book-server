package com.okay.service.impl;

import com.okay.converter.BookConverter;
import com.okay.entity.AuthorEntity;
import com.okay.entity.BookEntity;
import com.okay.model.AuthorDto;
import com.okay.model.BookDto;
import com.okay.model.PublisherDto;
import com.okay.repository.AuthorRepository;
import com.okay.repository.BookRepository;
import com.okay.repository.PublisherRepository;
import com.okay.service.AuthorService;
import com.okay.service.BookService;
import com.okay.service.PublisherService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private final AuthorService authorService;

    private final PublisherService publisherService;

    private final BookRepository repository;

    private final BookConverter converter;

    public BookServiceImpl(AuthorService authorService, PublisherService publisherService, BookRepository repository, BookConverter converter) {
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.repository = repository;
        this.converter = converter;
    }

    @Transactional
    @Override
    public BookDto saveOrUpdate(BookDto book) {

        // check author
        List<AuthorDto> authorList = book.getAuthorList();
        for (AuthorDto author : authorList) {
            authorService.saveOrUpdate(author);
        }

        // check publisher
        PublisherDto publisher = book.getPublisher();
        publisherService.saveOrUpdate(publisher);

        BookEntity bookEntity = repository.findByIsbn(book.getIsbn());
        if (bookEntity == null) {
            bookEntity = converter.convertToEntity(book);
        } else {
            //TODO update edilmesi implement edilecek
            bookEntity.setName(book.getName());
            bookEntity.setDescription(book.getDescription());
        }

        return converter.convertToDto(repository.save(bookEntity));
    }

    @Override
    public List<BookDto> list() {
        return converter.convertToDtoList(repository.findAll());
    }
}