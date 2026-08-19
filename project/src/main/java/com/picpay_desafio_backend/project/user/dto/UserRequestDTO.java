package com.picpay_desafio_backend.project.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.picpay_desafio_backend.project.user.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Representa dados entrando pra API, então não faz sentido o user ter que informar o ID quando quer fazer login
public record UserRequestDTO(
    @NotBlank @NotNull
    @JsonProperty("full_name")
    String fullName,

    @NotNull @NotBlank @Email
    String email,

    @NotNull @NotBlank
    String cpf,

    @NotNull @NotBlank
    String password,

    @NotNull
    @JsonProperty("user_type")
    UserType userType
) {}
