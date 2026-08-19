package com.picpay_desafio_backend.project.user.domain;

import lombok.Getter;

@Getter
public enum UserType {
    COMMON("COMMON"),
    MERCHANT("MERCHANT");

    private String role;
    UserType(String role) {
        this.role = role;
    }
}
