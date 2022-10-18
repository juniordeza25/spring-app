package com.example.springapp.common.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class ExceptionResponseDto {
    private LocalDateTime timestamp;
    private String error;
    private Map<String, ?> message;
}
