package com.picpay_desafio_backend.project.user.dto;

// Representa dados saindo da API, seria inseguro mandar na resposta a senha do usuário
public record UserResponseDTO(
    Integer id,
    String fullname,
    String email,
    String cpf
) {}
