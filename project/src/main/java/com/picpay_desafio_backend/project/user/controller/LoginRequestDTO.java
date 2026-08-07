package com.picpay_desafio_backend.project.user.controller;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
    @NotBlank
    String email,

    @NotBlank
    String password
) {}
