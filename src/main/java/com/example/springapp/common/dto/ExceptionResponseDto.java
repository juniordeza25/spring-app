package com.example.springapp.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponseDto {
    private LocalDateTime timestamp;
    private String error;
    private Map<String, ?> message;
}
