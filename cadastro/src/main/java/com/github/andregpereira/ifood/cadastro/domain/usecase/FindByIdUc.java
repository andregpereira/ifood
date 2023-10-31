package com.github.andregpereira.ifood.cadastro.domain.usecase;

import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface FindByIdUc<T> {

    Uni<T> findById(UUID id);

}
