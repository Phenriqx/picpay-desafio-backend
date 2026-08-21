package com.picpay_desafio_backend.project.transfer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Table(name = "transfers")
@Entity
@Getter
@ToString
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "payer_wallet_id")
    private Integer payerID;

    @Column(name = "payee_wallet_id")
    private Integer payeeID;

    @Column(name = "amount")
    private BigDecimal amount;

    public Transfer(Integer payerId, Integer payeeId, BigDecimal amount) {
        this.payerID = payerId;
        this.payeeID = payeeId;
        this.amount = amount;
    }
}
