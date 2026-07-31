package com.picpay_desafio_backend.project.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserRespondeDTO {
    private Integer id;
    String fullName;
    String email;
    String cpf;
}
