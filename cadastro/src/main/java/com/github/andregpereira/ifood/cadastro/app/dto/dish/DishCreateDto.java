package com.github.andregpereira.ifood.cadastro.app.dto.dish;

import java.math.BigDecimal;

public record DishCreateDto(String name,
        String description,
        BigDecimal price) {

}
