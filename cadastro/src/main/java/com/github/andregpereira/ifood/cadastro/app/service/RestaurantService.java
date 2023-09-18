package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {

    Uni<RestaurantDto> create(RestaurantCreateDto dto);

    Uni<RestaurantDto> findById(UUID id);

    Uni<List<RestaurantDto>> findAll();

    Uni<List<RestaurantDto>> findByName(String name);

}
