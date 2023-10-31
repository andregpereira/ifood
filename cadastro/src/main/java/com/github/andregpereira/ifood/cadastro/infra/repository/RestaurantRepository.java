package com.github.andregpereira.ifood.cadastro.infra.repository;

import com.github.andregpereira.ifood.cadastro.infra.entity.RestaurantEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import java.util.UUID;

public non-sealed interface RestaurantRepository extends BaseRepository<RestaurantEntity> {

}
