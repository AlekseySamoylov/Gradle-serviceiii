package com.alekseysamoylov.serviceiii.entity.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * Сущность - Роль пользователя системы
 */
@Entity
@Immutable
@Table(name = "role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class UserRole {

    public UserRole(Long id, User user, Role role) {
        this.setId(id);
        this.setUser(user);
        this.setRole(role);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Пользователь
     */
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Роль.
     */
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}
