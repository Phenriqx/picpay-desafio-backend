package com.picpay_desafio_backend.project.user.application;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.domain.Wallet;
import com.picpay_desafio_backend.project.user.domain.exception.UserAlreadyExistsException;
import com.picpay_desafio_backend.project.user.domain.exception.UserNotFoundException;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import com.picpay_desafio_backend.project.user.mapper.UserMapper;
import com.picpay_desafio_backend.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User saveUser(User user) {
        if (existsByCpf(user.getCpf()))
            throw new UserAlreadyExistsException();

        if (existsByEmail(user.getEmail()))
            throw new UserAlreadyExistsException();

        // faz o hashing da senha do usuário para não salvar texto puro na base de dados
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toResponseDTOList(users);
    }

    public User getUserByID(Integer id) {
        return userRepository.getUserById(id)
            .orElseThrow(UserNotFoundException::new);
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
            .orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(UserNotFoundException::new);
    }
}
