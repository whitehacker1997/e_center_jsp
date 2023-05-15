package com.example.e_center_project.core;

import java.util.stream.Stream;

public interface IUnitOfWork<TId, E, S extends E, TRepository> {
    <E, D extends EntityDto<E>> D readSingle(TId id, Class<D> dto);

    <E, D extends EntityDto<E>> Stream<D> projectEntityToDto(Class<D> dto);

    <E, D extends EntityDto<E>> D create(Class<E> entityClass, D dto);
    <S> E setEntityProperties(E entity);
}
