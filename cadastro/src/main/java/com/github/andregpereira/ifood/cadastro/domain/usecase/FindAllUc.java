package com.github.andregpereira.ifood.cadastro.domain.usecase;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface FindAllUc<T> {

    Uni<List<T>> findAll();

}
