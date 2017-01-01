package com.alekseysamoylov.serviceiii.entity.security;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.Validate;
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

    /**
     * Конструирует новую роль по ее наименованию и идентификатору.
     *
     * @param id   идентификатор
     * @param name имя
     */
    public Role(Long id, String name) {
        this(name.toUpperCase(), name);
        this.setId(id);
    }

    /**
     * Конструирует новую роль по ее полномочиям и наименованию.
     *
     * @param authority строковое представление полномочий роли
     * @param name      наименование роли
     * @throws IllegalArgumentException если полномочия или наименование роли пусто
     */
    public Role(String authority, String name) {
        Validate.notEmpty(authority);
        Validate.notEmpty(name);
        this.authority = authority;
        this.name = name;
    }

}
