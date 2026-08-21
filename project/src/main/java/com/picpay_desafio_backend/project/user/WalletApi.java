package com.picpay_desafio_backend.project.user;

import com.picpay_desafio_backend.project.shared.provider.WalletTransferResult;
import com.picpay_desafio_backend.project.user.application.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletApi {
    private final WalletService walletService;

   public WalletTransferResult transfer(Integer payerID, Integer payeeID, BigDecimal amount) {
       return walletService.transfer(payerID, payeeID, amount);
   }
}
