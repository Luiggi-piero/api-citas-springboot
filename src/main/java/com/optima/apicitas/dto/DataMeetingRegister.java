package com.optima.apicitas.dto;

import jakarta.validation.constraints.NotBlank;

public record DataMeetingRegister(
        @NotBlank
        String consultation,

        @NotBlank
        String project
) {
}
