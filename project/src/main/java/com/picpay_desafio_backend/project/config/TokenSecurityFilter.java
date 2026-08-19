package com.picpay_desafio_backend.project.config;

import com.picpay_desafio_backend.project.shared.provider.UserProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenSecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    // Aqui usamos a api pública de User para evitar que esta classe acesse o userRepository, o qual ela não deve ter acesso
    private final UserProvider userProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            var subject = tokenService.validateToken(token);
            Optional<UserDetails> user = userProvider.findByLogin(subject);
            if (user.isPresent()) {
                var authenticate = new UsernamePasswordAuthenticationToken(
                    user.get(),
                    null,
                    user.get().getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authenticate);
            }
        }

        // Chama o próximo filtro
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            return null;

        return authHeader.replace("Bearer ", "");
    }
}
