package com.example.customerapp.dto;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {
    private String fullName;
    private Integer age;
    private BigDecimal balance;
}
