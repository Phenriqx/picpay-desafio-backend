package com.picpay_desafio_backend.project.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
    @NotBlank @NotNull
    String fullName,

    @NotNull @NotBlank @Email
    String email,

    @NotNull @NotBlank
    String cpf,

    @NotNull @NotBlank
    String password
) {}
