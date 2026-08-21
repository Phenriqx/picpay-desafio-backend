package com.picpay_desafio_backend.project.shared.provider;

public record WalletTransferResult(
    Integer payerWalletId,
    Integer payeeWalletId
) {}
