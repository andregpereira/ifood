package com.github.andregpereira.ifood.cadastro.app.service;

import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import com.github.andregpereira.ifood.cadastro.domain.usecase.dish.*;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
class DishServiceImpl implements DishService {

    private final DishCreateUc createUc;
    private final DishUpdateUc updateUc;
    private final DishDeleteUc deleteUc;
    private final DishFindAllUc findAllUc;
    private final DishFindByIdUc dishFindByIdUc;
    private final DishFindByNameUc findByNameUc;

    @Override
    public Uni<Dish> create(Dish dish) {
        return createUc.create(dish);
    }

    @Override
    public Uni<Dish> update(UUID id, Dish dish) {
        return updateUc.update(id, dish);
    }

    @Override
    public Uni<Void> delete(UUID id) {
        return deleteUc.delete(id);
    }

    @Override
    public Uni<Dish> findById(UUID id) {
        return dishFindByIdUc.findById(id);
    }

    @Override
    public Uni<List<Dish>> findAll() {
        return findAllUc.findAll();
    }

    @Override
    public Uni<List<Dish>> findByName(String name) {
        return findByNameUc.findByName(name);
    }

}
