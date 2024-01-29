package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.*;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantCreateUc createUc;
    private final RestaurantUpdateUc updateUc;
    private final RestaurantFindByIdUc findByIdUc;
    private final RestaurantFindAllUc findAllUc;
    private final RestaurantFindByNameUc findByNameUc;

    @Override
    public Uni<Restaurant> create(Restaurant restaurant) {
        return createUc.create(restaurant);
    }

    @Override
    public Uni<Restaurant> update(UUID id, Restaurant restaurant) {
        return updateUc.update(id, restaurant);
    }

    @Override
    public Uni<Void> delete(UUID id) {
        return null;
    }

    @Override
    public Uni<Restaurant> findById(UUID id) {
        return findByIdUc.findById(id);
    }

    @Override
    public Uni<List<Restaurant>> findAll() {
        return findAllUc.findAll();
    }

    @Override
    public Uni<List<Restaurant>> findByName(String name) {
        return findByNameUc.findByName(name);
    }

}
