package com.example.myfirstspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.swing.text.Style;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String name;
    private BigDecimal price;
    private String created_at;
    private String updated_at;

}
