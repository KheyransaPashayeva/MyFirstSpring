package com.example.myfirstspring.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class ProductRedisDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 42L;
    private Long id;
    private String name;
    private Integer price;

}
