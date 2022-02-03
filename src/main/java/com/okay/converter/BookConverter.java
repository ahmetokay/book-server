package com.okay.converter;

import com.okay.core.AbstractBaseConverter;
import com.okay.entity.BookEntity;
import com.okay.model.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookConverter extends AbstractBaseConverter<BookDto, BookEntity> {
}