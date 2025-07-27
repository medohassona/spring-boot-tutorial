package com.demo.springboot.dto;

import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
        @NotBlank(message = "Firstname should not be empty")
        String firstname,
        @NotBlank(message = "Please provide the lastname")
        String lastname,
        @NotBlank(message = "The email is required for the student creation")
        String email
) {
}
