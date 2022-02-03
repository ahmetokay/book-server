package com.okay.service.impl;

import com.okay.converter.BookConverter;
import com.okay.entity.BookEntity;
import com.okay.model.BookDto;
import com.okay.repository.BookRepository;
import com.okay.service.BookService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookConverter converter;

    public BookServiceImpl(BookRepository repository, BookConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public BookDto saveOrUpdate(BookDto book) {
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