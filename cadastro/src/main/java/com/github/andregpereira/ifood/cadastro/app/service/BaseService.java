package com.github.andregpereira.ifood.cadastro.app.service;

import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

sealed interface BaseService<R> permits RestaurantService, DishService {

    Uni<R> findById(UUID id);

    Uni<List<R>> findAll();

    Uni<List<R>> findByName(String name);

}
