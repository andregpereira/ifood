package com.github.andregpereira.ifood.cadastro.infra.mapper;

import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import com.github.andregpereira.ifood.cadastro.infra.entity.RestaurantEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface RestaurantDataProviderMapper {

    Restaurant toModel(RestaurantEntity e);

    RestaurantEntity toEntity(Restaurant r);

    default List<Restaurant> toModelList(List<RestaurantEntity> e) {
        return e.stream().map(this::toModel).toList();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RestaurantEntity partialUpdate(Restaurant r, @MappingTarget RestaurantEntity e);

}
