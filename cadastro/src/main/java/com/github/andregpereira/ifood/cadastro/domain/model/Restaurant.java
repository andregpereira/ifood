package com.github.andregpereira.ifood.cadastro.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private UUID id;
    private String name;
    private String owner;
    private String cnpj;
    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;
    private Location location;

}
