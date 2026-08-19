package com.picpay_desafio_backend.project.user;

import com.picpay_desafio_backend.project.user.application.WalletService;
import com.picpay_desafio_backend.project.user.domain.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletApi {
    private final WalletService walletService;

   public void transfer(Integer payerID, Integer payeeID, BigDecimal amount) {
       walletService.transfer(payerID, payeeID, amount);
   }
}
