package com.github.andregpereira.ifood.cadastro.domain.usecase;

import io.smallrye.mutiny.Uni;

public interface CreateUc<T> {

    Uni<T> create(T t);

}
