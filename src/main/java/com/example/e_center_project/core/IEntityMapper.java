package com.example.e_center_project.core;

import java.util.List;
import java.util.stream.Stream;

public interface IEntityMapper {
    <D, E> D entityToDto(E entity, Class<D> dto);

    <D, E> Stream<D> entityListToDtoList(List<E> entityList, Class<D> dtoClass);

    <D, S extends E, E> S dtoToEntity(D dto, Class<E> entityClass);
}


