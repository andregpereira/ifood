package com.github.andregpereira.ifood.cadastro.app.facade;

import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishDto;
import com.github.andregpereira.ifood.cadastro.app.mapper.DishServiceMapper;
import com.github.andregpereira.ifood.cadastro.app.service.DishService;
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
final class DishFacadeImpl implements DishFacade {

    private final DishService dishService;
    private final RestaurantService restaurantService;
    private final DishServiceMapper mapper;

    @Override
    @WithTransaction
    public Uni<DishDto> create(UUID restaurantId, DishCreateDto dto) {
        return Uni.createFrom()
                .item(() -> mapper.toModel(dto))
                .call(d -> restaurantService.findById(restaurantId).invoke(d::setRestaurant))
                .chain(dishService::create)
                .map(mapper::toDto);
    }

    @Override
    @WithTransaction
    public Uni<DishDto> update(UUID restaurantId, UUID dishId, DishCreateDto dto) {
        return Uni.createFrom()
                .item(() -> mapper.toModel(dto))
                .call(d -> restaurantService.findById(restaurantId).invoke(d::setRestaurant))
                .chain(d -> dishService.update(dishId, d))
                .map(mapper::toDto);
    }

    @Override
    @WithTransaction
    public Uni<Void> delete(UUID restaurantId, UUID dishId) {
        return restaurantService.findById(restaurantId).chain(() -> dishService.delete(dishId));
    }

    @Override
    @WithSession
    public Uni<DishDto> findById(UUID restaurantId, UUID dishId) {
        return restaurantService.findById(restaurantId).chain(() -> dishService.findById(dishId)).map(mapper::toDto);
    }

    @Override
    @WithSession
    public Uni<List<DishDto>> findAll() {
        return dishService.findAll().map(mapper::toDtoList);
    }

    @Override
    @WithSession
    public Uni<List<DishDto>> findByName(String name) {
        return dishService.findByName(name).map(mapper::toDtoList);
    }

}
