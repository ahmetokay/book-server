package com.okay.core;

import java.util.Collection;
import java.util.List;

public interface ModelConverter<D extends BaseModel, E extends BaseEntity> {

    List<D> convertToDtoList(Collection<E> entityList);

    D convertToDto(E entity);
}