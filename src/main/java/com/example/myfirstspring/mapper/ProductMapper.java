package com.example.myfirstspring.mapper;

import com.example.myfirstspring.dao.entity.ProductEntity;
import com.example.myfirstspring.dto.ProductResponseDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
public class ProductMapper {

    public List<ProductResponseDto> getProduct(List<ProductEntity> entities){
        List<ProductResponseDto> dtos = new ArrayList<>();
        for(ProductEntity e : entities) {
            ProductResponseDto dto = ProductResponseDto.builder()
                    .name(e.getName())
                    .price(e.getPrice()).build();

            dtos.add(dto);
        }
        return dtos;
    }
    public ProductResponseDto getById(ProductEntity e){
        ProductResponseDto dto = ProductResponseDto.builder()
                .name(e.getName())
                .price(e.getPrice())
                .build();
        return dto;
    }
}
