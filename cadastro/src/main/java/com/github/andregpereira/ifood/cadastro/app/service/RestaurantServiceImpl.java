package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.app.mapper.RestaurantServiceMapper;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.*;
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

    private final RestaurantCreateUc createUc;
    private final RestaurantUpdateUc updateUc;
    private final RestaurantFindByIdUc findByIdUc;
    private final RestaurantFindAllUc findAllUc;
    private final RestaurantFindByNameUc findByNameUc;
    private final RestaurantServiceMapper mapper;

    @Override
    public Uni<RestaurantDto> create(RestaurantCreateDto dto) {
        return createUc.create(mapper.toModel(dto)).map(mapper::toDto);
    }

    @Override
    public Uni<RestaurantDto> update(UUID id, RestaurantCreateDto dto) {
        return updateUc.update(id, mapper.toModel(dto)).map(mapper::toDto);
    }

    @Override
    public Uni<RestaurantDto> findById(UUID id) {
        return findByIdUc.findById(id).map(mapper::toDto);
    }

    @Override
    public Uni<List<RestaurantDto>> findAll() {
        return findAllUc.findAll().map(mapper::toDtoList);
    }

    @Override
    public Uni<List<RestaurantDto>> findByName(String name) {
        return findByNameUc.findByName(name).map(mapper::toDtoList);
    }

}
