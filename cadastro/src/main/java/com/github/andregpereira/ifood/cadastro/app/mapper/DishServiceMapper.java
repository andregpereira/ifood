package com.github.andregpereira.ifood.cadastro.app.mapper;

import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishDto;
import com.github.andregpereira.ifood.cadastro.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public non-sealed interface DishServiceMapper extends BaseServiceMapper<Dish, DishDto, DishCreateDto> {

}
