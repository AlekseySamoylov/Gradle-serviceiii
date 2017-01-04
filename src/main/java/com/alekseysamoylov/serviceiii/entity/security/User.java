package com.alekseysamoylov.serviceiii.entity.security;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.CachableEntity;
import com.alekseysamoylov.serviceiii.entity.reference.Customer;
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
public class User extends AbstractSequenceIdEntity implements UserDetails, CachableEntity {

    public static final String CACHE_NAME = "user";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles = Sets.newHashSet();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

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
        return true;
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
