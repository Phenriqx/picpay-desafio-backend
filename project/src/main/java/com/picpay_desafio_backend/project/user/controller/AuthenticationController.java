package com.picpay_desafio_backend.project.user.controller;

import com.picpay_desafio_backend.project.config.TokenService;
import com.picpay_desafio_backend.project.user.application.UserService;
import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.LoginRequestDTO;
import com.picpay_desafio_backend.project.user.dto.LoginResponseDTO;
import com.picpay_desafio_backend.project.user.dto.UserRequestDTO;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import com.picpay_desafio_backend.project.user.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO request) {
        User user = userService.saveUser(
            userMapper.toEntity(request)
        );
        return ResponseEntity.status(201).body(userMapper.toDto(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken(request.email());

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
    }
}

