package com.picpay_desafio_backend.project.shared.provider;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

// Definimos essa interface como um provider de UserDetails exclusivamente para o módulo config
// Isso porque estava havendo uma dependência circular entre o módulo User e Config, então precisamos de um provider separado
// Essa interface é implementada no módulo User e, portanto, o módulo config nunca sabe como é implementado.
public interface UserProvider {
    Optional<UserDetails> findByLogin(String email);
}
