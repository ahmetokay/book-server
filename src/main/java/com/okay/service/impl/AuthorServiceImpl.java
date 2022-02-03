package com.okay.service.impl;

import com.okay.converter.AuthorConverter;
import com.okay.entity.AuthorEntity;
import com.okay.model.AuthorDto;
import com.okay.repository.AuthorRepository;
import com.okay.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    private final AuthorConverter converter;

    public AuthorServiceImpl(AuthorRepository repository, AuthorConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public AuthorDto saveOrUpdate(AuthorDto author) {
        AuthorEntity authorEntity = repository.findByName(author.getName());
        if (authorEntity == null) {
            authorEntity = converter.convertToEntity(author);
        }
        return converter.convertToDto(repository.save(authorEntity));
    }
}