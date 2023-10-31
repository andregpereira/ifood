package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishDto;
import com.github.andregpereira.ifood.cadastro.app.mapper.DishServiceMapper;
import com.github.andregpereira.ifood.cadastro.domain.usecase.dish.*;
import com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant.RestaurantFindByIdUc;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class DishServiceImpl implements DishService {

    private final DishCreateUc createUc;
    private final DishUpdateUc updateUc;
    private final DishDeleteUc deleteUc;
    private final DishFindAllUc findAllUc;
    private final DishFindByIdUc dishFindByIdUc;
    private final DishFindByNameUc findByNameUc;
    private final RestaurantFindByIdUc restaurantFindByIdUc;
    private final DishServiceMapper mapper;

    @Override
    public Uni<DishDto> create(UUID restaurantId, DishCreateDto dto) {
        return Uni.createFrom()
                .item(() -> mapper.toModel(dto))
                .call(d -> restaurantFindByIdUc.findById(restaurantId)
                        .invoke(d::setRestaurant))
                .chain(createUc::create)
                .map(mapper::toDto);
//        outros métodos
//        Dish dish = mapper.toModel(dto);
//        return restaurantFindById.findById(restaurantId).flatMap(
//                r -> Uni.createFrom().item(() -> mapper.toModel(dto)).invoke(d -> d.setRestaurant(r))).chain(
//                createUc::create).map(mapper::toDto);
//        return restaurantFindById.findById(restaurantId).map(r -> {
//            Dish dish = mapper.toModel(dto);
//            dish.setRestaurant(r);
//            return dish;
//        }).chain(createUc::create).map(mapper::toDto);
//        return restaurantFindById.findById(restaurantId).chain(r -> {
//            Dish dish = mapper.toModel(dto);
//            dish.setRestaurant(r);
//            return createUc.create(dish);
//        }).map(mapper::toDto);
    }

    @Override
    public Uni<DishDto> update(UUID restaurantId, UUID dishId, DishCreateDto dto) {
        return Uni.createFrom()
                .item(() -> mapper.toModel(dto))
                .call(d -> restaurantFindByIdUc.findById(restaurantId)
                        .invoke(d::setRestaurant))
                .chain(d -> updateUc.update(dishId, d))
                .map(mapper::toDto);
//        outros métodos
//        return dishFindByIdUc.findById(dishId)
//                .call(d -> restaurantFindById.findById(restaurantId)
//                        .invoke(d::setRestaurant))
//                .chain(d -> updateUc.update(dishId, d))
//                .map(mapper::toDto);
//        return restaurantFindById.findById(restaurantId)
//                .chain(r -> {
//                    Dish dish = mapper.toModel(dto);
//                    dish.setRestaurant(r);
//                    return updateUc.update(dishId, mapper.toModel(dto));
//                })
//                .map(mapper::toDto);
    }

    @Override
    public Uni<Void> delete(UUID restaurantId, UUID dishId) {
        return restaurantFindByIdUc.findById(restaurantId)
                .chain(() -> deleteUc.delete(dishId));
    }

    @Override
    public Uni<DishDto> findById(UUID id) {
        return dishFindByIdUc.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public Uni<List<DishDto>> findAll() {
        return findAllUc.findAll()
                .map(mapper::toDtoList);
    }

    @Override
    public Uni<List<DishDto>> findByName(String name) {
        return findByNameUc.findByName(name)
                .map(mapper::toDtoList);
    }

}
