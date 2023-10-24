package com.github.andregpereira.ifood.cadastro.app.mapper;

import java.util.List;

sealed interface BaseServiceMapper<M, D, E> permits DishServiceMapper {

    M toModel(E e);

    D toDto(M m);

    default List<D> toDtoList(List<M> m) {
        return m.stream().map(this::toDto).toList();
    }

}
