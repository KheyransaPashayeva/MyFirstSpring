package com.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliVeNinoDto {
    private String name;
    private Long stock;
    private Double price;
    private String author;

}
