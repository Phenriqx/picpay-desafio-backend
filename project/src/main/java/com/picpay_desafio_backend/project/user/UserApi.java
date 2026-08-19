package com.picpay_desafio_backend.project.user;

import com.picpay_desafio_backend.project.shared.provider.AuthenticatedUser;
import com.picpay_desafio_backend.project.user.application.UserService;
import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import com.picpay_desafio_backend.project.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // faz o DI automaticamente
public class UserApi {
    // API pública acessível para os outros módulos. Isso significa que outros módulos, como transfer, por exemplo,
    // não consiga acessar os métodos internos desse módulo
    // transfer -> userAPI -> userService
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthenticatedUser findByLogin(String email) {
        User user = userService.findByEmail(email);
        return new AuthenticatedUser(
            user.getId(),
            user.getEmail()
        );
    }
}
