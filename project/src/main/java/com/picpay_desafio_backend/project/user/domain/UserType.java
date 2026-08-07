package com.picpay_desafio_backend.project.user.domain;

import lombok.Getter;

@Getter
public enum UserType {
    COMMON("common"),
    MERCHANT("merchant");

    private String role;
    UserType(String role) {
        this.role = role;
    }
}
