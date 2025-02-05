package com.example.librafapp.mapper;

import com.example.librafapp.dao.entity.LibrafEntity;
import com.example.librafapp.dto.LibrafResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LibrafMapper {
    public List<LibrafResponseDto> entityListToDto(List<LibrafEntity> entities) {
        List<LibrafResponseDto> dtos = new ArrayList<LibrafResponseDto>();
        for (LibrafEntity entity : entities) {
            LibrafResponseDto dto = LibrafResponseDto.builder()
                    .bookName(entity.getBookName())
                    .category(entity.getCategory())
                    .stock(entity.getStock())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    public LibrafResponseDto entityToDto(LibrafEntity entity) {
        LibrafResponseDto dto=LibrafResponseDto.builder()
                .bookName(entity.getBookName())
                .category(entity.getCategory())
                .stock(entity.getStock())
                .build();
        return dto;
    }
}
