package com.github.andregpereira.ifood.cadastro.domain.gateway;

import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public non-sealed interface DishGateway extends BaseGateway<Dish> {

    Uni<Void> delete(UUID id);

}
