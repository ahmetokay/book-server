package com.okay.converter;

import com.okay.core.AbstractBaseConverter;
import com.okay.entity.AuthorEntity;
import com.okay.model.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter extends AbstractBaseConverter<AuthorDto, AuthorEntity> {
}