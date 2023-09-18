package com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import io.smallrye.mutiny.Uni;

public interface CreateRestaurant {

    Uni<Restaurant> create(Restaurant restaurant);

}
