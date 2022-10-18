package com.example.springapp.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ProductDto {
    private Long id;

    @NotEmpty(message = "The name is required") @Size(max = 100, message = "The length of the name must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "The price is required")
    private BigDecimal price;

    @NotNull(message = "The categoryId is required")
    private Short categoryId;
}
