package com.github.andregpereira.ifood.cadastro.infra.dataprovider;

import com.github.andregpereira.ifood.cadastro.domain.gateway.DishGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import com.github.andregpereira.ifood.cadastro.infra.mapper.DishDataProviderMapper;
import com.github.andregpereira.ifood.cadastro.infra.repository.DishRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class DishDataProvider implements DishGateway {

    private final DishRepository repository;
    private final DishDataProviderMapper mapper;

    @Override
    public Uni<Dish> create(Dish dish) {
        return Panache.withTransaction(() -> repository.persist(mapper.toEntity(dish)).map(mapper::toModel));
    }

    @Override
    public Uni<Dish> update(UUID id, Dish dish) {
        return Panache.withTransaction(() -> repository.findById(id).map(d -> mapper.partialUpdate(dish, d)).map(
                mapper::toModel));
    }

    @Override
    public Uni<Dish> findById(UUID id) {
        return Panache.withSession(() -> repository.findById(id).map(mapper::toModel));
    }

    @Override
    public Uni<List<Dish>> findAll() {
        return Panache.withSession(() -> repository.findAll(Sort.by("id")).page(Page.ofSize(10)).list().map(
                mapper::toModelList));
    }

    @Override
    public Uni<List<Dish>> findByName(String name) {
        return Panache.withSession(() -> repository.find("name ilike :name", Sort.by("name"),
                Parameters.with("name", name + "%").map()).page(Page.ofSize(10)).list().map(mapper::toModelList));
    }

    @Override
    public Uni<Void> delete(UUID id) {
        return Panache.withTransaction(() -> repository.deleteById(id)).replaceWithVoid();
    }

}
