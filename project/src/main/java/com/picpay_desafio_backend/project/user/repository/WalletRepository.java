package com.picpay_desafio_backend.project.user.repository;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Optional<Wallet> findByUserId(Integer userId);
}
