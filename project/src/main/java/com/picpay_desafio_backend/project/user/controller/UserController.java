package com.picpay_desafio_backend.project.user.controller;

import com.picpay_desafio_backend.project.user.application.UserService;
import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserRequestDTO;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import com.picpay_desafio_backend.project.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request) {
        User user = userMapper.toEntity(request);
        user = userService.saveUser(user);
        return ResponseEntity.status(201).body(userMapper.toDto(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO request) {
        return null;
    }
}
