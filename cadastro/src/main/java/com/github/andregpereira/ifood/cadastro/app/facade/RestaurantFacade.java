package com.github.andregpereira.ifood.cadastro.app.facade;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public non-sealed interface RestaurantFacade extends BaseFacade<RestaurantDto> {

    Uni<RestaurantDto> create(RestaurantCreateDto dto);

    Uni<RestaurantDto> update(UUID id, RestaurantCreateDto dto);

    Uni<Void> delete(UUID id);

    Uni<RestaurantDto> findById(UUID id);

}
