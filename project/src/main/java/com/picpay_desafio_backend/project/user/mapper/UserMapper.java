package com.picpay_desafio_backend.project.user.mapper;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserRequestDTO;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class UserMapper {
    public User toEntity(UserRequestDTO dto) {
        return new User(
            dto.fullName(),
            dto.cpf(),
            dto.email(),
            dto.password(),
            dto.userType()
        );
    }

    public UserResponseDTO toDto(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getFullName(),
            user.getEmail(),
            user.getCpf(),
            user.getUserType()
        );
    }

    public List<UserResponseDTO> toResponseDTOList(List<User> users) {
        return users.stream()
            .map(this::toDto)
            .toList();
    }
}
