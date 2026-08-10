package com.picpay_desafio_backend.project.user.domain.exception;

import com.picpay_desafio_backend.project.shared.BusinessException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException() {
        super("User already exists", HttpStatus.CONFLICT, "USER_ALREADY_EXISTS");
    }
}
