package com.github.andregpereira.ifood.cadastro.infra.mapper;

import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import com.github.andregpereira.ifood.cadastro.infra.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface DishDataProviderMapper extends BaseDataProviderMapper<Dish, DishEntity> {

}
