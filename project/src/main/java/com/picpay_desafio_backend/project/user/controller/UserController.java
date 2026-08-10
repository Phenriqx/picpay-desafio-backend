package com.picpay_desafio_backend.project.user.controller;

import com.picpay_desafio_backend.project.user.application.UserService;
import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserRequestDTO;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import com.picpay_desafio_backend.project.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {
        UserResponseDTO user = userMapper.toDto(
            userService.getUserByID(id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
