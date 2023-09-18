package com.github.andregpereira.ifood.cadastro.app.dto.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.model.Location;

public record RestaurantCreateDto(String name,
        String owner,
        String cnpj,
        Location location) {

}
