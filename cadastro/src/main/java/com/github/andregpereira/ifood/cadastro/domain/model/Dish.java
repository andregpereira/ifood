package com.github.andregpereira.ifood.cadastro.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Restaurant restaurant;

}
