package com.example.e_center_project.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class UnitOfWork<TId, T, TRepository extends JpaRepository<T, TId>>
        implements IUnitOfWork<TId, T, TRepository> {
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
    public <T, D extends EntityDto<T>> D readSingle(TId id, Class<D> dto) {
        T entity = (T) repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entity not found"));

        var result = entityMapper.entityToDto(entity, dto);

        return result;
    }

    @Override
    public <E, D> Iterable<D> projectEntityToDto(E entity, Class<D> dto) {
        return null;
    }
}
