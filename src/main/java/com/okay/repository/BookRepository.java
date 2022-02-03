package com.okay.repository;

import com.okay.core.BaseRepository;
import com.okay.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<BookEntity> {

    BookEntity findByIsbn(String isbn);
}