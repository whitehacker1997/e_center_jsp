package com.example.e_center_project.core;

import java.util.List;
public interface IEntityMapper {
    <D, E> D entityToDto(E entity, Class<D> dto);

    <D, E> List<D> entityListToDtoList(List<E> entityList, Class<D> dtoClass);

    <D, E> E dtoToEntity(D dto, Class<E> entityClass);
}


