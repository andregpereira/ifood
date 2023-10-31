package com.github.andregpereira.ifood.cadastro.infra.mapper;

import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import com.github.andregpereira.ifood.cadastro.infra.entity.RestaurantEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface RestaurantDataProviderMapper extends BaseDataProviderMapper<Restaurant, RestaurantEntity> {

}
