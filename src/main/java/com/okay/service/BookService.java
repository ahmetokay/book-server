package com.okay.service;

import com.okay.model.BookDto;

import java.util.List;

public interface BookService {

    BookDto saveOrUpdate(BookDto book);

    List<BookDto> list();
}