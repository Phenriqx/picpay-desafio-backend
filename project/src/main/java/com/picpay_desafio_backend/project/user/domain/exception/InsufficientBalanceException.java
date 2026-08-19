package com.picpay_desafio_backend.project.user.domain.exception;

import com.picpay_desafio_backend.project.shared.BusinessException;
import org.springframework.http.HttpStatus;

public class InsufficientBalanceException extends BusinessException {
    public InsufficientBalanceException() {
        super("Insufficient balance", HttpStatus.BAD_REQUEST, "INSUFFICIENT_BALANCE");
    }
}
