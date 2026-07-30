package com.picpay_desafio_backend.project.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
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
}
