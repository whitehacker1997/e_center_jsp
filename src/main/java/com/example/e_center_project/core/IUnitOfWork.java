package com.example.e_center_project.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUnitOfWork<TId, T, TRepository> {
    <T, D extends EntityDto<T>> D readSingle(TId id, Class<D> dto);

    <E, D> Iterable<D> projectEntityToDto(E entity, Class<D> dto);
}
