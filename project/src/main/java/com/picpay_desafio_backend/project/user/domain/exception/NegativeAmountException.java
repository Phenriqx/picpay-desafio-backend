package com.picpay_desafio_backend.project.user.domain.exception;

import com.picpay_desafio_backend.project.shared.BusinessException;
import org.springframework.http.HttpStatus;

public class NegativeAmountException extends BusinessException {
    public NegativeAmountException() {
        super("Amount to deposit/withdraw cannot be negative", HttpStatus.BAD_REQUEST, "AMOUNT_CANNOT_BE_NEGATIVE");
    }
}
