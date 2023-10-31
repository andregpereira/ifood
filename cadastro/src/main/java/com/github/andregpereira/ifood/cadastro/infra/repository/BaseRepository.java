package com.github.andregpereira.ifood.cadastro.infra.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import java.util.UUID;

public sealed interface BaseRepository<T> extends PanacheRepositoryBase<T, UUID> permits RestaurantRepository, DishRepository {

}
