package com.example.springapp.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Short categoryId;
}
