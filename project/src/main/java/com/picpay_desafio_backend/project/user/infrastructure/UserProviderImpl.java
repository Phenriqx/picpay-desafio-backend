package com.picpay_desafio_backend.project.user.infrastructure;

import com.picpay_desafio_backend.project.shared.provider.UserProvider;
import com.picpay_desafio_backend.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserProviderImpl implements UserProvider {
    private final UserRepository userRepository;

    @Override
    public Optional<UserDetails> findByLogin(String email) {
        // Fazemos um casting porque findByEmail retorna um User e não UserDetails
        return userRepository.findByEmail(email)
            .map(user -> (UserDetails) user);
    }
}
