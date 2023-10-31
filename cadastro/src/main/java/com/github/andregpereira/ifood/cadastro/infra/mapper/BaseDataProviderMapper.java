package com.github.andregpereira.ifood.cadastro.infra.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface BaseDataProviderMapper<M, E> {

    M toModel(E e);

    E toEntity(M m);

    default List<M> toModelList(List<E> e) {
        return e.stream().map(this::toModel).toList();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E partialUpdate(M m, @MappingTarget E e);

}
