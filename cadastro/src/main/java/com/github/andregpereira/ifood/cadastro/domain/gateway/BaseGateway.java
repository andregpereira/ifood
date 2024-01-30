package com.github.andregpereira.ifood.cadastro.domain.gateway;

import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

sealed interface BaseGateway<T> permits DishGateway, RestaurantGateway {

    Uni<T> create(T t);

    Uni<T> update(UUID id, T t);

    Uni<T> findById(UUID id);

    Uni<List<T>> findAll();

    Uni<List<T>> findByName(String name);

}
