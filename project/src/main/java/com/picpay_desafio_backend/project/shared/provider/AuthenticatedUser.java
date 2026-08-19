package com.picpay_desafio_backend.project.shared.provider;

public record AuthenticatedUser(
    Integer userId,
    String email
) {}
