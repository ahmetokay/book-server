package com.okay.service.impl;

import com.okay.converter.PublisherConverter;
import com.okay.entity.PublisherEntity;
import com.okay.model.PublisherDto;
import com.okay.repository.PublisherRepository;
import com.okay.service.PublisherService;
import org.springframework.stereotype.Component;

@Component
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repository;

    private final PublisherConverter converter;

    public PublisherServiceImpl(PublisherRepository repository, PublisherConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public PublisherDto saveOrUpdate(PublisherDto publisher) {
        PublisherEntity publisherEntity = repository.findByName(publisher.getName());
        if (publisherEntity == null) {
            publisherEntity = converter.convertToEntity(publisher);
        }
        return converter.convertToDto(repository.save(publisherEntity));
    }
}