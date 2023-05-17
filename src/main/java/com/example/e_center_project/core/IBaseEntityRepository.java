package com.example.e_center_project.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseEntityRepository<
        TId,
        E,
        S extends E,
        TDlDto,
        TCreateDto extends EntityDto<TDlDto, E>,
        TUpdateDto extends EntityDto<TDlDto, E>,
        TJpaRepository extends JpaRepository<E,TId>> {
    TCreateDto create(Class<E> entityClass,TCreateDto dto);
    TUpdateDto update(TUpdateDto dto);
}
