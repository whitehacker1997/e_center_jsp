package com.example.e_center_project.core.services;

import com.example.e_center_project.core.interfaces.IEntityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Stream;

@Component
public class EntityMapper
        implements IEntityMapper {
    private final ModelMapper modelMapper;

    public EntityMapper() {
        this.modelMapper = new ModelMapper();
    }

    public <D, E> D entityToDto(E entity,
                                Class<D> dto) {
        return modelMapper.map(entity, dto);
    }

    @Override
    public <D, E> Stream<D> entityListToDtoList(List<E> entityList,
                                                Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> entityToDto(entity, dtoClass));
    }

    @Override
    public <D, S extends E, E> S dtoToEntity(D dto, Class<E> entityClass) {
        return (S)modelMapper.map(dto, entityClass);
    }
}
