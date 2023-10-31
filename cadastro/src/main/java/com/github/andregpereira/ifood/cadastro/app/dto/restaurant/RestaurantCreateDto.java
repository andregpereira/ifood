package com.github.andregpereira.ifood.cadastro.app.dto.restaurant;

import com.github.andregpereira.ifood.cadastro.app.dto.location.LocationCreateDto;

public record RestaurantCreateDto(String name,
        String owner,
        String cnpj,
        LocationCreateDto location) {

}
