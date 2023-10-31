package com.github.andregpereira.ifood.cadastro.app.dto.location;

import java.util.UUID;

public record LocationDto(UUID id,
        Double latitude,
        Double longitude) {

}
