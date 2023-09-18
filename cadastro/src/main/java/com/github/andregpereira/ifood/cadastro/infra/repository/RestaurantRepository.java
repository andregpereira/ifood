package com.github.andregpereira.ifood.cadastro.infra.repository;

import com.github.andregpereira.ifood.cadastro.infra.entity.RestaurantEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import java.util.UUID;

public interface RestaurantRepository extends PanacheRepositoryBase<RestaurantEntity, UUID> {

}
