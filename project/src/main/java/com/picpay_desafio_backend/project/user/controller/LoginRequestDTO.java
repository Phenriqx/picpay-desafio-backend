package com.picpay_desafio_backend.project.user.controller;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
    @NotBlank (message = "Email must not be null")
    String email,

    @NotBlank (message = "Password must not be null")
    String password
) {}
