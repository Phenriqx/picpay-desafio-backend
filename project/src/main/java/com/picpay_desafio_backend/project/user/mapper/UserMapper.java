package com.picpay_desafio_backend.project.user.mapper;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserRequestDTO;
import com.picpay_desafio_backend.project.user.dto.UserRespondeDTO;
import org.apache.coyote.Response;
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

    public UserRespondeDTO toDto(User user) {
        UserRespondeDTO dto = new UserRespondeDTO();
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setCpf(user.getCpf());
        dto.setId(user.getId());

        return dto;
    }
}
