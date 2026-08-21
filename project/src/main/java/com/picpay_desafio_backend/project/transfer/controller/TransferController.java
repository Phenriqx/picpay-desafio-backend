package com.picpay_desafio_backend.project.transfer.controller;

import com.picpay_desafio_backend.project.transfer.application.TransferService;
import com.picpay_desafio_backend.project.transfer.dto.TransferRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    // usando o PreAuthorize com a role COMMON, dizemos que somente usuários do tipo common podem efetuar transferências
    // isso vem da regra de negócio, então usuários MERCHANT não conseguiriam acessar esse endpoint
    @PreAuthorize("hasAuthority('transfer:send')")
    @PostMapping("/new")
    public ResponseEntity<Void> transfer(Authentication authentication, @RequestBody @Valid TransferRequestDTO request) {
        transferService.transfer(
            authentication.getName(),
            request.payee(),
            request.amount()
        );

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
