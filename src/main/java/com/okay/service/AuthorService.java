package com.okay.service;

import com.okay.model.AuthorDto;

public interface AuthorService {

    AuthorDto saveOrUpdate(AuthorDto author);
}