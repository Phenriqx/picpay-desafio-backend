package com.picpay_desafio_backend.project.user;

import com.picpay_desafio_backend.project.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // faz o DI automaticamente
public class UserApi {
    // API pública acessível para os outros módulos. Isso significa que outros módulos, como transfer, por exemplo,
    // não consiga acessar os métodos internos desse módulo
    // transfer -> userAPI -> userService
    private final UserService userService;
}
