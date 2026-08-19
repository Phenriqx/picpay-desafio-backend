package com.picpay_desafio_backend.project.user.domain;

import com.picpay_desafio_backend.project.user.domain.exception.InsufficientBalanceException;
import com.picpay_desafio_backend.project.user.domain.exception.NegativeAmountException;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(
        name = "user_id",
        nullable = false,
        unique = true
    )
    private User user;

    public Wallet(User user) {
        this.user = user;
        this.balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount) {
        validateAmountPositive(amount);
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        validateAmountPositive(amount);
        if (this.balance.compareTo(amount) < 0)
            throw new InsufficientBalanceException();

        this.balance = this.balance.subtract(amount);
    }

    private void validateAmountPositive(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeAmountException();
    }
}
