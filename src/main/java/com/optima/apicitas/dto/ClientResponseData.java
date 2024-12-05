package com.optima.apicitas.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientResponseData(
        Long id,
        String name,
        String email,
        Integer age
) {
}
