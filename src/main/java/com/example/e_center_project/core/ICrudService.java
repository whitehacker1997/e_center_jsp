package com.example.e_center_project.core;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.stream.Stream;

public interface ICrudService<TId, E, S extends E> {
    <E, D extends ILinkToEntity<D,E>> D readSingle(TId id, Class<D> dto);

    <E, D extends ILinkToEntity<D,E>> Stream<D> projectEntityToDto(Class<D> dto);
}
