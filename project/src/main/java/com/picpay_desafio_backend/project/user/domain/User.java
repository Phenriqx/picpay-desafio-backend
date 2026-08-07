package com.picpay_desafio_backend.project.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

// Quando usamos o Spring Security, nossa entity User precisa implementar a interface UserDetails, que vem do próprio Spring Security
public class User implements UserDetails {
    // aqui um simples ID sequencial funciona, mas pensando em segurança, talvez seria melhor usar um UUID ou algo semelhante
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
    Como emails e CPFs devem ser únicos, passamos pela annotation @Column o parâmetro unique = true;
    Também há outros parâmetros disponíveis, como:
        nullable
        name
        length, etc
    */

    @Column(name = "full_name", nullable = false, length = 128)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) // Com EnumType.STRING definido, o JPA irá salvar os valores como Strings na base de dados, ao invés de números
    @Column(name = "user_type")
    private UserType userType;

    public boolean canTransfer() {
        return userType == UserType.COMMON;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (userType == UserType.COMMON) {
            return List.of(
                new SimpleGrantedAuthority("transfer:send"),
                new SimpleGrantedAuthority("transfer:receive")
            );
        }

        // Se o usuário for do tipo MERCHANT, o único tipo de transferência possível é 'receive'
        return List.of(
            new SimpleGrantedAuthority("transfer:receive")
        );
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
