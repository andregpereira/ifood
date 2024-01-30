package com.github.andregpereira.ifood.cadastro.app.facade;

import io.smallrye.mutiny.Uni;

import java.util.List;

sealed interface BaseFacade<T> permits RestaurantFacade, DishFacade {

    Uni<List<T>> findAll();

    Uni<List<T>> findByName(String name);

}
