package com.picpay_desafio_backend.project.user.mapper;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserRequestDTO;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setFullName(dto.fullName());
        user.setCpf(dto.cpf());
        user.setPassword(dto.password());

        return user;
    }

    public UserResponseDTO toDto(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getFullName(),
            user.getEmail(),
            user.getCpf()
        );
    }
}
