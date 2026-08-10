package com.picpay_desafio_backend.project.shared.exception;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ErrorResponse(
    HttpStatus status,
    String errorCode,
    String message,
    Instant timestamp
) {}
