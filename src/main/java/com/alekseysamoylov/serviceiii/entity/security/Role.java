package com.alekseysamoylov.serviceiii.entity.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Роль пользователя.
 */
@Entity
@Immutable
@Table(name = "role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Код.
     * Строковое представление полномочий роли.
     */
    @NotBlank
    @Column(nullable = false, updatable = false, unique = true)
    private String authority;

    /**
     * Наименование.
     */
    @NotBlank
    @Column(nullable = false)
    private String name;

}
