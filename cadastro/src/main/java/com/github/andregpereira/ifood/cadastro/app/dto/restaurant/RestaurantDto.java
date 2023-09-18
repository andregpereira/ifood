package com.github.andregpereira.ifood.cadastro.app.dto.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.model.Location;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.time.OffsetDateTime;
import java.util.UUID;

@JsonbPropertyOrder({"id", "owner", "cnpj", "name", "createdDate", "modifiedDate", "location"})
public record RestaurantDto(UUID id,
        String name,
        String owner,
        String cnpj,
        OffsetDateTime createdDate,
        OffsetDateTime modifiedDate,
        Location location) {

}
