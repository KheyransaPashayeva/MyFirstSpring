package com.example.aliveninoapp.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AliVeNinoResponseDto {
    private String name;
    private Long stock;
    private Double price;
    private String author;
}
