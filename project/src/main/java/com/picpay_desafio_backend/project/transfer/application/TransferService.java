package com.picpay_desafio_backend.project.transfer.application;

import com.picpay_desafio_backend.project.shared.provider.AuthenticatedUser;
import com.picpay_desafio_backend.project.transfer.dto.TransferRequestDTO;
import com.picpay_desafio_backend.project.user.UserApi;
import com.picpay_desafio_backend.project.user.WalletApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final UserApi userApi;
    private final WalletApi walletApi;

    public void transfer(String payer, String payee, BigDecimal amount) {
        AuthenticatedUser payeeUser = userApi.findByLogin(payee);
        AuthenticatedUser payerUser = userApi.findByLogin(payer);

        walletApi.transfer(payerUser.userId(), payeeUser.userId(), amount);
    }
}
