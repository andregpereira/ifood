package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.app.mapper.RestaurantServiceMapper;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.CreateRestaurant;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.FindAllRestaurant;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.FindByNameRestaurant;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.RestaurantFindById;
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

    private final CreateRestaurant createRestaurant;
    private final RestaurantFindById findById;
    private final FindAllRestaurant findAllRestaurant;
    private final FindByNameRestaurant findByNameRestaurant;
    private final RestaurantServiceMapper mapper;

    @Override
    public Uni<RestaurantDto> create(RestaurantCreateDto dto) {
        return createRestaurant.create(mapper.toModel(dto)).map(mapper::toDto);
    }

    @Override
    public Uni<RestaurantDto> findById(UUID id) {
        return findById.findById(id).map(mapper::toDto);
    }

    @Override
    public Uni<List<RestaurantDto>> findAll() {
        return findAllRestaurant.findAll().map(mapper::toDtoList);
    }

    @Override
    public Uni<List<RestaurantDto>> findByName(String name) {
        return findByNameRestaurant.findByName(name).map(mapper::toDtoList);
    }

}
