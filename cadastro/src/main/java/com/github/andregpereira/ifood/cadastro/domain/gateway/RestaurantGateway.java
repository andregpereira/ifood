package com.github.andregpereira.ifood.cadastro.domain.gateway;

import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

public interface RestaurantGateway {

    Uni<Restaurant> save(Restaurant restaurant);

    Uni<Restaurant> findById(UUID id);

    Uni<List<Restaurant>> findAll();

    Uni<List<Restaurant>> findByName(String name);

}
