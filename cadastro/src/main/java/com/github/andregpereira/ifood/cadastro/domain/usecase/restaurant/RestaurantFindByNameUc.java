package com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface RestaurantFindByNameUc {

    Uni<List<Restaurant>> findByName(String name);

}
