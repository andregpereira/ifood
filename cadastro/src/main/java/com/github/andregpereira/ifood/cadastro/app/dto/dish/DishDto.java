package com.github.andregpereira.ifood.cadastro.app.dto.dish;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.math.BigDecimal;
import java.util.UUID;

@JsonbPropertyOrder({"id", "name", "description", "price", "restaurant"})
public record DishDto(UUID id,
        String name,
        String description,
        BigDecimal price,
        RestaurantDto restaurant) {

}
