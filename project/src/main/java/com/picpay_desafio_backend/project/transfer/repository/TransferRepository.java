package com.picpay_desafio_backend.project.transfer.repository;

import com.picpay_desafio_backend.project.transfer.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {}
