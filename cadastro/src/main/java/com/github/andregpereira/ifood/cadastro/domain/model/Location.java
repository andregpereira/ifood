package com.github.andregpereira.ifood.cadastro.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private UUID id;
    private double latitude;
    private double longitude;

}
