package com.picpay_desafio_backend.project.shared;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String errorCode;

    protected BusinessException(String message, HttpStatus status, String code) {
        super(message);
        this.httpStatus = status;
        this.errorCode = code;
    }
}
