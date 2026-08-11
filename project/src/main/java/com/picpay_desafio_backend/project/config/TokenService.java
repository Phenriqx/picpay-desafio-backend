package com.picpay_desafio_backend.project.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    // gera um token JWT
    public String generateToken(String email) {
        try {
            Algorithm algo = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("desafio-picpay")
                .withSubject(email)
                .withExpiresAt(generateExpirationDate())
                .sign(algo);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token.", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algo = Algorithm.HMAC256(secret);
            return JWT.require(algo)
                .withIssuer("desafio-picpay")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Error validating token", e);
        }
   }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
