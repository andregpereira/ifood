package com.github.andregpereira.ifood.cadastro.domain.usecase;

import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface UpdateUc<T> {

    Uni<T> update(UUID id, T t);

}
