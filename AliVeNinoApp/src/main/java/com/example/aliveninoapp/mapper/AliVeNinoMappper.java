package com.example.aliveninoapp.mapper;

import com.example.aliveninoapp.dao.entity.AliVeNinoEntity;
import com.example.aliveninoapp.dto.AliVeNinoRequestDto;
import com.example.aliveninoapp.dto.AliVeNinoResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AliVeNinoMappper {
    @Mapping(source = "name", target = "name")
    AliVeNinoEntity toEntity(AliVeNinoRequestDto dto);
    AliVeNinoResponseDto toResponseDto(AliVeNinoEntity entity);
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequetToEntity(AliVeNinoRequestDto dto,@MappingTarget AliVeNinoEntity entity);
}
