package com.github.andregpereira.ifood.cadastro.app.facade;

import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishDto;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public non-sealed interface DishFacade extends BaseFacade<DishDto> {

    Uni<DishDto> create(UUID restaurantId, DishCreateDto dto);

    Uni<DishDto> update(UUID restaurantId, UUID dishId, DishCreateDto dto);

    Uni<Void> delete(UUID restaurantId, UUID dishId);

    Uni<DishDto> findById(UUID restaurantId, UUID dishId);

}
