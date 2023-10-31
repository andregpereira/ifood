package com.github.andregpereira.ifood.cadastro.domain.usecase.dish;

import com.github.andregpereira.ifood.cadastro.domain.gateway.DishGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class DishUpdateUcImpl implements DishUpdateUc {

    private final DishGateway gateway;

    @Override
    public Uni<Dish> update(UUID id, Dish dish) {
        return gateway.update(id, dish);
    }

}
