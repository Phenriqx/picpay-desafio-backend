package com.picpay_desafio_backend.project.user.controller;

import com.picpay_desafio_backend.project.user.application.UserService;
import com.picpay_desafio_backend.project.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
}
