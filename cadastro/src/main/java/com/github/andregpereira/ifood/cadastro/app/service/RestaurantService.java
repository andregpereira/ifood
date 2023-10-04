package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public non-sealed interface RestaurantService extends BaseService<RestaurantDto> {

    Uni<RestaurantDto> create(RestaurantCreateDto dto);

    Uni<RestaurantDto> update(UUID id, RestaurantCreateDto dto);

}
