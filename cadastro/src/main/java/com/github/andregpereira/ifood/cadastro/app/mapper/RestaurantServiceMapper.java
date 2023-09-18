package com.github.andregpereira.ifood.cadastro.app.mapper;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface RestaurantServiceMapper {

    Restaurant toModel(RestaurantCreateDto dto);

    RestaurantDto toDto(Restaurant r);

    default List<RestaurantDto> toDtoList(List<Restaurant> r) {
        return r.stream().map(this::toDto).toList();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Restaurant partialUpdate(RestaurantDto dto, @MappingTarget Restaurant r);

}
