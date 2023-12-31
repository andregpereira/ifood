package com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.gateway.RestaurantGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class RestaurantFindByNameUcImpl implements RestaurantFindByNameUc {

    private final RestaurantGateway gateway;

    @Override
    public Uni<List<Restaurant>> findByName(String name) {
        return gateway.findByName(name);
    }

}
