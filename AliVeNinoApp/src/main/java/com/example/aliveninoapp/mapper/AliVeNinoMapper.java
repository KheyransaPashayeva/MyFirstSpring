package com.example.aliveninoapp.mapper;

import com.example.aliveninoapp.dao.entity.AliVeNinoEntity;
import com.example.aliveninoapp.dto.AliVeNinoResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AliVeNinoMapper {
    public List<AliVeNinoResponseDto> entityListToDto(List<AliVeNinoEntity> entities) {
        List<AliVeNinoResponseDto> dtos = new ArrayList<AliVeNinoResponseDto>();
        for (AliVeNinoEntity entity : entities) {
            AliVeNinoResponseDto dto = AliVeNinoResponseDto.builder()
                    .name(entity.getName())
                    .author(entity.getAuthor())
                    .stock(entity.getStock())
                    .price(entity.getPrice())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    public AliVeNinoResponseDto entityToDto(AliVeNinoEntity entity) {
        AliVeNinoResponseDto dto=AliVeNinoResponseDto.builder()
                .name(entity.getName())
                .author(entity.getAuthor())
                .stock(entity.getStock())
                .price(entity.getPrice())
                .build();
        return dto;
    }
}
