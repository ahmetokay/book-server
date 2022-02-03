package com.okay.core;

import java.util.Collection;
import java.util.List;

public interface EntityConverter<D extends BaseModel, E extends BaseEntity> {

    List<E> convertToEntityList(Collection<D> dtoList);

    E convertToEntity(D dto);
}