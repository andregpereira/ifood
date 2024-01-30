package com.github.andregpereira.ifood.cadastro.app.facade;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.app.mapper.RestaurantServiceMapper;
import com.github.andregpereira.ifood.cadastro.app.service.RestaurantService;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
final class RestaurantFacadeImpl implements RestaurantFacade {

    private final RestaurantService service;
    private final RestaurantServiceMapper mapper;

    @Override
    @WithTransaction
    public Uni<RestaurantDto> create(RestaurantCreateDto dto) {
        return Uni.createFrom().item(() -> mapper.toModel(dto)).chain(service::create).map(mapper::toDto);
    }

    @Override
    @WithTransaction
    public Uni<RestaurantDto> update(UUID id, RestaurantCreateDto dto) {
        return Uni.createFrom().item(() -> mapper.toModel(dto)).chain(r -> service.update(id, r)).map(mapper::toDto);
    }

    @Override
    @WithTransaction
    public Uni<Void> delete(UUID id) {
        return service.delete(id);
    }

    @Override
    @WithSession
    public Uni<RestaurantDto> findById(UUID id) {
        return service.findById(id).map(mapper::toDto);
    }

    @Override
    @WithSession
    public Uni<List<RestaurantDto>> findAll() {
        return service.findAll().map(mapper::toDtoList);
    }

    @Override
    @WithSession
    public Uni<List<RestaurantDto>> findByName(String name) {
        return service.findByName(name).map(mapper::toDtoList);
    }

}
