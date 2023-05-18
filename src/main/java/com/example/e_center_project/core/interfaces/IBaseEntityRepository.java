package com.example.e_center_project.core.interfaces;

import com.example.e_center_project.core.models.EntityDto;
import com.example.e_center_project.core.models.HaveId;
import com.example.e_center_project.core.models.IHaveIdProp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseEntityRepository<
        TId,
        E,
        S extends E,
        TDlDto,
        TCreateDto extends EntityDto<TDlDto, E>,
        TUpdateDto extends EntityDto<TDlDto, E>,
        TJpaRepository extends JpaRepository<E, TId>> {
    TCreateDto create(Class<E> entityClass, TCreateDto dto);

    <TUpdateDto extends IHaveIdProp<TId>> TUpdateDto update(Class<E> entityClass, TUpdateDto dto);

    HaveId<TId> delete(TId id);
    E onCreate(E entity);
    E onUpdate(E entity);
}
