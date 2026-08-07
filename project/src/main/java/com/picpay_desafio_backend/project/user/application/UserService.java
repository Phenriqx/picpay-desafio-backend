package com.picpay_desafio_backend.project.user.application;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        if (existsByCpf(user.getCpf()))
            throw new RuntimeException("CPFs duplicados não são permitidos");

        if (existsByEmail(user.getEmail()))
            throw new RuntimeException("Emails duplicados não são permitidos");

        // faz o hashing da senha do usuário para não salvar texto puro na base de dados
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public boolean existsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
