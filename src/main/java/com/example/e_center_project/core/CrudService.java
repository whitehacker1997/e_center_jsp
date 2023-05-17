package com.example.e_center_project.core;

import com.example.e_center_project.core.models.ILinkToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Component
public class CrudService<TId, E, S extends E>
        implements ICrudService<TId, E, S> {

    private final IEntityMapper entityMapper;
    private final JpaRepository<E,TId> repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public CrudService(IEntityMapper entityMapper,
                       JpaRepository<E,TId> repository) {
        this.entityMapper = entityMapper;
        this.repository = repository;
    }

    @Override
    public <E, D extends ILinkToEntity<D, E>> D readSingle(TId id, Class<D> dto) {
        E entity = (E) repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entity not found"));

        var result = entityMapper.entityToDto(entity, dto);

        return result;
    }

    @Override
    public <E, D extends ILinkToEntity<D, E>> Stream<D> projectEntityToDto(Class<D> dto) {
        List<E> query = (List<E>) repository.findAll();

        return entityMapper.entityListToDtoList(query, dto);
    }
}
