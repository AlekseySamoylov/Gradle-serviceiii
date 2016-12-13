package com.alekseysamoylov.serviceiii.entity.security;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Сущность Пользователь
 */
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User extends AbstractSequenceIdEntity implements UserDetails {

    /**
     * Логин
     */
    @Column(length = 255, nullable = false, unique = true)
    private String username;

    /**
     * Хеш пароля
     */
    @Column(nullable = false)
    private String pass;


    /**
     * Роль пользователя.
     */
    @Getter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles = Sets.newHashSet();

    /**
     * Реализация интерфейса UserDetails
     *
     * @return список ролей авторизации
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = Sets.newHashSet();
        for (UserRole userRole : getUserRoles()) {
            roles.add(userRole.getRole());
        }
        return roles;
    }

    /**
     * Реализация интерфейса UserDetails
     *
     * @return пароль
     */
    @Override
    public String getPassword() {
        return pass;
    }

    /**
     * Реализция интерфейса UserDetails
     *
     * @return флаг истечения действия аккаунта
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * Реализация интерфейса UserDetails
     * Возвращает отрицание поля блокировки
     *
     * @return флаг блокирования
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Реализация интерфейса UserDetails
     *
     * @return флаг истечения скрока пароля
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Реализация интерфейса UserDetails
     *
     * @return флаг включения пользователя
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                "username='" + username + '\'' +
                '}';
    }
}
