package com.okay.converter;

import com.okay.core.AbstractBaseConverter;
import com.okay.entity.PublisherEntity;
import com.okay.model.PublisherDto;
import org.springframework.stereotype.Component;

@Component
public class PublisherConverter extends AbstractBaseConverter<PublisherDto, PublisherEntity> {
}