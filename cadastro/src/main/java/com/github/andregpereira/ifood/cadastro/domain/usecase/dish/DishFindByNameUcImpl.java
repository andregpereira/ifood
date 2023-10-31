package com.github.andregpereira.ifood.cadastro.domain.usecase.dish;

import com.github.andregpereira.ifood.cadastro.domain.gateway.DishGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class DishFindByNameUcImpl implements DishFindByNameUc {

    private final DishGateway gateway;

    @Override
    public Uni<List<Dish>> findByName(String name) {
        return gateway.findByName(name);
    }

}
