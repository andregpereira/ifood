package com.github.andregpereira.ifood.cadastro.domain.usecase.dish;

import com.github.andregpereira.ifood.cadastro.domain.gateway.DishGateway;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class DishDeleteUcImpl implements DishDeleteUc {

    private final DishGateway gateway;

    @Override
    public Uni<Void> delete(UUID id) {
        return gateway.delete(id);
    }

}
