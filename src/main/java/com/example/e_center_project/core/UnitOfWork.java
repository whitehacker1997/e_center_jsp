package com.example.e_center_project.core;

import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Component
public class UnitOfWork<TId, E, S extends E, TRepository extends JpaRepository<E, TId>>
        implements IUnitOfWork<TId, E, S, TRepository> {
    private final IEntityMapper entityMapper;
    private final TRepository repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public UnitOfWork(IEntityMapper entityMapper,
                      TRepository repository) {
        this.entityMapper = entityMapper;
        this.repository = repository;
    }



    @Override
    public <E, D extends EntityDto<D, E>> D create(Class<E> entityClass, D dto) {
        S entity = (S) entityMapper.dtoToEntity(dto, entityClass);
        entity = (S) setEntityProperties(entity);
        S savedEntity = repository.save(entity);
        D savedDto = (D) entityMapper.entityToDto(savedEntity, dto.getClass());
        return savedDto;
    }

    public <S1> E setEntityProperties(E entity) {
        return entity;
    }
}





