package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishDto;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public non-sealed interface DishService extends BaseService<DishDto> {

    Uni<DishDto> create(UUID restaurantId, DishCreateDto dto);

    Uni<DishDto> update(UUID restaurantId, UUID dishId, DishCreateDto dto);

    Uni<Void> delete(UUID restaurantId, UUID dishId);

}
