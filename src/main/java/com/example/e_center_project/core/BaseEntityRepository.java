package com.example.e_center_project.core;

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
        TJpaRepository extends JpaRepository<E,TId>>
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
        //entity = (S) setEntityProperties(entity);

        S savedEntity = repository.save(entity);
        TCreateDto savedDto = (TCreateDto) entityMapper.entityToDto(savedEntity, dto.getClass());

        return savedDto;
    }

    @Override
    public TUpdateDto update(TUpdateDto dto) {
        return null;
    }
}
