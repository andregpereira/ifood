package com.github.andregpereira.ifood.cadastro.infra.dataprovider;

import com.github.andregpereira.ifood.cadastro.domain.gateway.RestaurantGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import com.github.andregpereira.ifood.cadastro.infra.mapper.RestaurantDataProviderMapper;
import com.github.andregpereira.ifood.cadastro.infra.repository.RestaurantRepository;
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
public class RestaurantDataProvider implements RestaurantGateway {

    private final RestaurantRepository repository;
    private final RestaurantDataProviderMapper mapper;

    @Override
    public Uni<Restaurant> save(Restaurant restaurant) {
        return Panache.withTransaction(() -> repository.persist(mapper.toEntity(restaurant)).map(mapper::toModel));
    }

    @Override
    public Uni<Restaurant> findById(UUID id) {
        return Panache.withSession(() -> repository.findById(id).map(mapper::toModel));
    }

    @Override
    public Uni<List<Restaurant>> findAll() {
        return Panache.withSession(() -> repository.findAll(Sort.by("id")).page(Page.ofSize(10)).list().map(
                mapper::toModelList));
    }

    @Override
    public Uni<List<Restaurant>> findByName(String name) {
        return Panache.withSession(() -> repository.find("name ilike :name", Sort.by("name"),
                Parameters.with("name", name + "%").map()).page(Page.ofSize(10)).list().map(mapper::toModelList));
    }

}
