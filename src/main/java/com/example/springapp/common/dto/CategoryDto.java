package com.example.springapp.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CategoryDto {
    private Short id;

    @NotEmpty(message = "The name is required") @Size(max = 50, message = "The length of the name must be between 1 and 50 characters")
    private String name;
}
