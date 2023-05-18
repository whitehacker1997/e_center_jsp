package com.example.e_center_project.core.services;

import com.example.e_center_project.core.interfaces.IBaseEntityRepository;
import com.example.e_center_project.core.interfaces.IEntityMapper;
import com.example.e_center_project.core.models.EntityDto;
import com.example.e_center_project.core.models.HaveId;
import com.example.e_center_project.core.models.HaveIdResp;
import com.example.e_center_project.core.models.IHaveIdProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BaseEntityRepository<
        TId,
        E,
        S extends E,
        TDlDto,
        TCreateDto extends EntityDto<TDlDto, E>,
        TUpdateDto extends EntityDto<TDlDto, E>,
        TJpaRepository extends JpaRepository<E, TId>>
        implements IBaseEntityRepository<
                TId,
                E,
                S,
                TDlDto,
                TCreateDto,
                TUpdateDto,
                TJpaRepository> {


    private final IEntityMapper entityMapper;
    private final TJpaRepository repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public BaseEntityRepository(
            IEntityMapper entityMapper,
            TJpaRepository repository) {
        this.entityMapper = entityMapper;
        this.repository = repository;
    }

    @Override
    public TCreateDto create(Class<E> entityClass, TCreateDto dto) {
        S entity = (S) entityMapper.dtoToEntity(dto, entityClass);
        entity = (S) onCreate(entity);

        S savedEntity = repository.save(entity);
        TCreateDto savedDto = (TCreateDto) entityMapper.entityToDto(savedEntity, dto.getClass());

        return savedDto;
    }

    @Override
    public <TUpdateDto extends IHaveIdProp<TId>> TUpdateDto update(Class<E> entityClass, TUpdateDto dto) {
        E oldEntity = (E) repository.findById(dto.getId()).orElseThrow(() -> {
            throw new IllegalStateException("There is no county with this id %s".formatted(dto.getId()));
        });

        S entity = (S) entityMapper.dtoToEntity(dto, entityClass);

        entity = (S) onUpdate(entity);

        S savedEntity = repository.save(entity);

        TUpdateDto savedDto = (TUpdateDto) entityMapper.entityToDto(savedEntity, dto.getClass());
        return savedDto;
    }

    @Override
    public HaveId<TId> delete(TId id) {
        E entity = (E) repository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("There is no county with this id %s".formatted(id));
        });

        repository.deleteById(id);
        return new HaveIdResp<TId>().Create(id);
    }

    @Override
    public E onCreate(E entity) {
        return entity;
    }

    @Override
    public E onUpdate(E entity) {
        return entity;
    }
}
