package com.example.e_center_project.core;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
    public <D, E> List<D> entityListToDtoList(List<E> entityList,
                                              Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> entityToDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    @Override
    public <D, E> E dtoToEntity(D dto,
                                Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
