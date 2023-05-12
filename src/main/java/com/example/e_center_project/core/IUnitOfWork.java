package com.example.e_center_project.core;

public interface IUnitOfWork<T> {
    <E, D> D readSingle(E entity, Class<D> dto);
}
