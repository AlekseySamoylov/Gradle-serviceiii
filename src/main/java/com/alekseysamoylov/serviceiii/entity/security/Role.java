package com.alekseysamoylov.serviceiii.entity.security;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Роль пользователя.
 */
@Entity
@Immutable
@Table(name = "role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Role extends AbstractSequenceIdEntity implements GrantedAuthority {

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
