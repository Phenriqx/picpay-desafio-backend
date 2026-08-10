package com.picpay_desafio_backend.project.user.domain.exception;

import com.picpay_desafio_backend.project.shared.BusinessException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super("User not found", HttpStatus.NOT_FOUND, "USER_NOT_FOUND");
    }
}
