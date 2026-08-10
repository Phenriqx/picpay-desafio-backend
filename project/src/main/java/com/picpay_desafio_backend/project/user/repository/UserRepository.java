package com.picpay_desafio_backend.project.user.repository;

import com.picpay_desafio_backend.project.user.domain.User;
import com.picpay_desafio_backend.project.user.dto.UserResponseDTO;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/*
    Repositórios Spring Data JPA são interfaces que herdam da hierarquia do Spring Data.
    Eles fornecem implementações automáticas para acesso à base de dados, reduzindo código boilerplate
*/
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCpf(String cpf);
    Optional<User> findByEmail(String email);

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

    Optional<User> getUserById(Integer id);
}
