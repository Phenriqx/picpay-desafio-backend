package com.picpay_desafio_backend.project.transfer.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequestDTO(
    @NotBlank(message = "Payee must not be null.") @Email
    String payee,

    @DecimalMin(value = "0.00", inclusive = false)
    @Positive
    BigDecimal amount
) {}
