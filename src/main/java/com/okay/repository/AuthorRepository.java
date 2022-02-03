package com.okay.repository;

import com.okay.core.BaseRepository;
import com.okay.entity.AuthorEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<AuthorEntity> {

    AuthorEntity findByName(String name);
}