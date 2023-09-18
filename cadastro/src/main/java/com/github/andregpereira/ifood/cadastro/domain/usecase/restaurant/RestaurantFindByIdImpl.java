package com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.gateway.RestaurantGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class RestaurantFindByIdImpl implements RestaurantFindById {

    private final RestaurantGateway gateway;

    @Override
    public Uni<Restaurant> findById(UUID id) {
        return gateway.findById(id);
    }

}
