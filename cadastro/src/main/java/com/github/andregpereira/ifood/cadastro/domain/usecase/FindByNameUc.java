package com.github.andregpereira.ifood.cadastro.domain.usecase;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface FindByNameUc<T> {

    Uni<List<T>> findByName(String name);

}
