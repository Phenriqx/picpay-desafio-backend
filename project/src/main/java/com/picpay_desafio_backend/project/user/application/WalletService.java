package com.picpay_desafio_backend.project.user.application;

import com.picpay_desafio_backend.project.user.domain.Wallet;
import com.picpay_desafio_backend.project.user.domain.exception.UserNotFoundException;
import com.picpay_desafio_backend.project.user.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    public void transfer(Integer payerID, Integer payeeID, BigDecimal amount) {
        Wallet payer = walletRepository.findByUserId(payerID)
            .orElseThrow(UserNotFoundException::new);

        Wallet payee = walletRepository.findByUserId(payeeID)
            .orElseThrow(UserNotFoundException::new);

        payer.withdraw(amount);
        payee.deposit(amount);
    }
}
