package com.example.e_center_project.core;

import java.util.stream.Stream;

public interface IUnitOfWork<TId, E, S extends E, TRepository> {
    <E, D extends EntityDto<D , E>> D create(Class<E> entityClass, D dto);

    <S> E setEntityProperties(E entity);
}
